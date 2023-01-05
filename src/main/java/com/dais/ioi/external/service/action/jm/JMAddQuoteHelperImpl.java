package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.AgentInfoDto;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.AdditionalItemInfoDto;
import com.dais.ioi.external.domain.dto.jm.JMAuthData;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.ioi.external.util.NormalizedPremium;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.enums.AmountType;
import com.dais.ioi.quote.domain.dto.enums.ContentScopeType;
import com.dais.ioi.quote.domain.dto.enums.PremiumScaleType;
import com.dais.ioi.quote.domain.dto.enums.QuoteType;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDetailDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoveragesDto;
import com.dais.ioi.quote.domain.dto.pub.PubDurationDto;
import com.dais.ioi.quote.domain.dto.pub.PubExternalDataDto;
import com.dais.ioi.quote.domain.dto.pub.PubMessageDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumTaxesDto;
import com.dais.ioi.quote.domain.dto.pub.PubQuoteDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Iterables;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dais.ioi.external.service.action.jm.JMUtils.convertDateTimeToDate;
import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;



@Service
@Slf4j
public class JMAddQuoteHelperImpl
{
    public static final DateTimeFormatter EFFECTIVE_DATE_FORMAT = DateTimeFormatter.ofPattern( "yyyy-MM-dd'T'HH:mm:ss" );

    private static final String EXTERNAL_QUOTE_METADATA_KEY = "EXTERNAL_QUOTE";

    private static final String GENERIC_FAILED_QUOTE_MESSSAGE = "We are unable to provide a quote at this time.";

    private final JMQuoteClient jmQuoteClient;

    private final ObjectMapper objectMapper;

    private final ExternalQuoteDataService externalQuoteDataService;

    private final JmQuoteOptionsService jmQuoteOptionsService;

    private final JMAuthService jmAuthService;


    public JMAddQuoteHelperImpl( @Autowired final JMQuoteClient jmQuoteClient,
                                 @Autowired final ObjectMapper objectMapper,
                                 @Autowired final ExternalQuoteDataService externalQuoteDataService,
                                 @Autowired final JmQuoteOptionsService jmQuoteOptionsService,
                                 @Autowired final JMAuthService jmAuthService )
    {
        this.jmQuoteClient = jmQuoteClient;
        this.objectMapper = objectMapper;
        this.externalQuoteDataService = externalQuoteDataService;
        this.jmQuoteOptionsService = jmQuoteOptionsService;
        this.jmAuthService = jmAuthService;
    }


    public TriggerResponseDto processAddQuote( FiredTriggerDto firedTriggerDto,
                                               ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {

        final UUID requestId = null == firedTriggerDto.getTriggerRequestId() ? UUID.randomUUID() : firedTriggerDto.getTriggerRequestId();

        log.info( "(" + requestId.toString() + ") IMPORTANT: Begin getAddQuote call" );
        log.info( "(" + requestId.toString() + ") IMPORTANT: Received getAddQuote request with FiredTriggerDto: " + objectMapper.writeValueAsString( firedTriggerDto ) );

        String externalQuoteId = (String) firedTriggerDto.getPayload().get( "externalQuoteId" );

        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );

        // Collect plugin fields for email
        HashMap<String, String> pluginFields = new HashMap<>();

        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto, pluginFields );

        final String effectiveDateAnswer = triggerSpec.getIntake().get( actionJMSQuoteSpecDto.getEffectiveDate() ).getAnswer();

        final LocalDateTime effectiveDate = OffsetDateTime.parse( effectiveDateAnswer ).toLocalDateTime().with( LocalTime.MIDNIGHT );

        final JmSource jmSource = JmSource.valueOf( String.valueOf( triggerSpec.getMetadata().get( "jmSource" ) ) );

        final JMAuthData jmAuthData = jmAuthService.getAuthData( jmSource );

        try
        {
            final String formattedEffectiveDateForJmQuoteRequest = effectiveDate.format( EFFECTIVE_DATE_FORMAT );
            addQuoteRequest.setEffectiveDate( formattedEffectiveDateForJmQuoteRequest );

            final LinkedHashMap<String, String> agentInfoMap = (LinkedHashMap<String, String>) firedTriggerDto.getPayload().get( "agent" );
            addUserInfo( addQuoteRequest, agentInfoMap );


            // If the external quote id is sent, its treated as exclusively for updating
            // TODO: This should be a completely separate call
            if ( externalQuoteId != null && !externalQuoteId.equalsIgnoreCase( "" ) )
            {
                log.info( "(" + requestId.toString() + ") IMPORTANT: Entering Depricated updateQuoteCall" );

                addQuoteRequest.setQuoteId( externalQuoteId );

                String planName = getValue( () -> ( (Map) firedTriggerDto.getPayload().get( "selectedPaymentPlan" ) ).get( "name" ).toString(), "" );

                if ( firedTriggerDto.getPayload().containsKey( "selectedPaymentPlan" ) )
                {
                    Integer numberOfInstallments = Integer.parseInt( getValue( () -> ( (Map) firedTriggerDto.getPayload().get( "selectedPaymentPlan" ) ).get( "numberOfInstallments" ).toString(), "" ) );

                    addPaymentPlan( addQuoteRequest, planName, numberOfInstallments );
                }

                log.info( "(" + requestId.toString() + ") IMPORTANT: DEPRICATED JM ADDQUOTE request uri: " + jmAuthData.getBaseUri().toString() );
                log.info( "(" + requestId.toString() + ") IMPORTANT: DEPRICATED JM ADDQUOTE request body: " + objectMapper.writeValueAsString( addQuoteRequest ) );

                AddQuoteResult updQuoteResult = getUpdateQuoteResponse( jmAuthData, addQuoteRequest );

                log.info( "(" + requestId.toString() + ") IMPORTANT: DEPRICATED JM ADDQUOTE request response: " + objectMapper.writeValueAsString( updQuoteResult ) );

                if ( getValue( () -> updQuoteResult.getErrorMessages().size(), 0 ) > 0 )
                {
                    log.error( "(" + requestId.toString() + ") IMPORTANT: DEPRICATED JM ADDQUOTE request response has errors in it" );

                    String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );

                    //TODO DONT THROW EXCEPTION
                    log.info( "(" + requestId.toString() + ") IMPORTANT: DEPRICATED JM ADDQUOTE request complete: " + objectMapper.writeValueAsString( updQuoteResult ) );
                    throw new Exception( errorMessage );
                }

                TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

                HashMap<String, Object> idMap = new HashMap<>();

                idMap.put( "externalQuoteId", externalQuoteId );

                triggerResponseDto.setTriggerRequestId( requestId );

                triggerResponseDto.setMetadata( idMap );

                //TODO CHECK RESPONSE
                return triggerResponseDto;
            }

            log.info( "(" + requestId.toString() + ") IMPORTANT: JM ADDQUOTE request uri: " + jmAuthData.getBaseUri().toString() );
            log.info( "(" + requestId.toString() + ") IMPORTANT: JM ADDQUOTE request body: " + objectMapper.writeValueAsString( addQuoteRequest ) );
            AddQuoteResult addQuoteResult = getAddQuoteResult( jmAuthData, addQuoteRequest );
            log.info( "(" + requestId.toString() + ") IMPORTANT: JM ADDQUOTE request response: " + objectMapper.writeValueAsString( addQuoteResult ) );


            // This block will be hit if there is no coverage and the http response is 200
            if ( addQuoteResult.getIsCoverageAvailable() == null || addQuoteResult.getIsCoverageAvailable() == false )
            {

                log.info( "(" + requestId.toString() + ") IMPORTANT: JM ADDQUOTE Has Been Rejected due to isCoverageAvailable flag is false or is null.  Constructing Rejected QuoteDto" );
                TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

                HashMap<String, Object> metaDatamap = new HashMap<>();

                metaDatamap.put( "isUnderwritingNeeded", addQuoteResult.isUnderwritingNeeded() );
                metaDatamap.put( "isCoverageAvailable", addQuoteResult.getIsCoverageAvailable() );
                metaDatamap.put( "errorMessages", addQuoteResult.getErrorMessages() );
                metaDatamap.put( "messageList", addQuoteResult.getRespMessageList() );
                metaDatamap.put( "accountNumber", addQuoteResult.getAccountNumber() );


                log.info( "setting request Id to " + requestId );
                triggerResponseDto.setTriggerRequestId( requestId );

                QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), addQuoteResult, metaDatamap );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Rejected JM AddQuote QuoteDto: " + objectMapper.writeValueAsString( rejectedQuote ) );
                triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Returning Rejected JM AddQuote triggerResponseDto: " + objectMapper.writeValueAsString( triggerResponseDto ) );
                log.info( "(" + requestId.toString() + ") IMPORTANT: End of AddQuote call" );

                return triggerResponseDto;
            }

            externalQuoteId = addQuoteResult.getQuoteId();

            if ( getValue( () -> addQuoteResult.getErrorMessages().size(), 0 ) > 0 )
            {
                log.info( "(" + requestId.toString() + ") IMPORTANT: JM ADDQUOTE Has Been Rejected due to error message size is non-zero.  Constructing Rejected QuoteDto" );
                TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
                QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), addQuoteResult, Collections.emptyMap() );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Rejected JM AddQuote QuoteDto: " + objectMapper.writeValueAsString( rejectedQuote ) );
                triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Returning Rejected JM AddQuote triggerResponseDto: " + objectMapper.writeValueAsString( triggerResponseDto ) );
                log.info( "(" + requestId.toString() + ") IMPORTANT: End of AddQuote call" );
                return triggerResponseDto;
            }

            addQuoteRequest.setQuoteId( externalQuoteId );

            log.info( "(" + requestId.toString() + ") IMPORTANT: JM UPDATEQUOTE request uri: " + jmAuthData.getBaseUri().toString() );
            log.info( "(" + requestId.toString() + ") IMPORTANT: JM UPDATEQUOTE request body: " + objectMapper.writeValueAsString( addQuoteRequest ) );
            AddQuoteResult updateQuoteResult = getJmUpdateQuoteResult( jmAuthData, addQuoteRequest );
            log.info( "(" + requestId.toString() + ") IMPORTANT: JM UPDATEQUOTE request response: " + objectMapper.writeValueAsString( updateQuoteResult ) );


            if ( getValue( () -> updateQuoteResult.getErrorMessages().size(), 0 ) > 0 )
            {
                log.info( "(" + requestId.toString() + ") IMPORTANT: JM UPDATEQUOTE Has Been Rejected due to error message size is non-zero.  Constructing Rejected QuoteDto" );
                TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
                QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), addQuoteResult, Collections.emptyMap() );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Rejected JM UPDATEQUOTE QuoteDto: " + objectMapper.writeValueAsString( rejectedQuote ) );
                triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
                log.info( "(" + requestId.toString() + ") IMPORTANT: Returning Rejected JM UPDATEQUOTE triggerResponseDto: " + objectMapper.writeValueAsString( triggerResponseDto ) );
                log.info( "(" + requestId.toString() + ") IMPORTANT: End of AddQuote call" );
                return triggerResponseDto;
            }


            PubQuoteDetailsDto quoteDetailsForQuoteOption = getQuoteDetailsForQuoteOption( updateQuoteResult, addQuoteRequest, actionJMSQuoteSpecDto, triggerSpec.getIntake() );
            PubQuoteDetailsDto quoteDetailsForIOI = getQuoteDetailsForIOI( updateQuoteResult, addQuoteRequest, actionJMSQuoteSpecDto, triggerSpec.getIntake() );

            saveFieldsForPlugin( requestId, addQuoteResult, pluginFields, triggerSpec.getClientId() );

            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

            HashMap<String, Object> metaDatamap = new HashMap<>();
            metaDatamap.put( "ratePlans", updateQuoteResult.getPaymentPlans() );
            metaDatamap.put( "isUnderwritingNeeded", addQuoteResult.isUnderwritingNeeded() );
            metaDatamap.put( "isCoverageAvailable", addQuoteResult.getIsCoverageAvailable() );
            metaDatamap.put( "minimumPremium", addQuoteResult.getRatingInfo().getMinimumPremium() );
            metaDatamap.put( "minimumTaxesAndSurcharges", addQuoteResult.getRatingInfo().getMinimumTaxesAndSurcharges() );


            QuoteDto newQuote = getQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), quoteDetailsForIOI, metaDatamap );
            QuoteDto quoteOptions = getQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), quoteDetailsForQuoteOption, metaDatamap );
            log.info( "(" + requestId.toString() + ") IMPORTANT: IOI QuoteDto for Add Quote: " + objectMapper.writeValueAsString( newQuote ) );

            triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, newQuote );

            triggerResponseDto.setTriggerRequestId( requestId );

            //Override details for quote option
            quoteOptions.setQuoteDetails( quoteDetailsForQuoteOption );

            String intakeKey = objectMapper.writeValueAsString( triggerSpec.getIntake() );

            JmQuoteOptionDto jmQuoteOptionDto = JmQuoteOptionDto.builder().quoteOption( quoteOptions )
                                                                .clientId( quoteOptions.getClientId() )
                                                                .lineId( firedTriggerDto.getLineId() )
                                                                .submissionDate( quoteOptions.getQuoteTimestamp() )
                                                                .intakeKey( intakeKey )
                                                                .build();

            jmQuoteOptionsService.save( jmQuoteOptionDto );
            log.info( "(" + requestId.toString() + ") IMPORTANT: Saving JM Add Quote Options to database: " + objectMapper.writeValueAsString( quoteOptions ) );
            log.info( "(" + requestId.toString() + ") IMPORTANT: Returning JM Add Quote TriggerResponseDto: " + objectMapper.writeValueAsString( triggerResponseDto ) );
            log.info( "(" + requestId.toString() + ") IMPORTANT: End getAddQuote call" );
            return triggerResponseDto;
        }
        catch ( Exception e )
        {
            QuoteDto quoteRequestFailedQuoteDto = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate.toLocalDate(), e );
            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
            triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, quoteRequestFailedQuoteDto );
            triggerResponseDto.setTriggerRequestId( requestId );
            return triggerResponseDto;
        }
    }


    public AddPaymentPlanResponseDto addPaymentPlan( final String externalQuoteId,
                                                     final AgentInfoDto agentInfoDto,
                                                     final Map<String, ClientAnswerDto> intake,
                                                     final Map<String, Object> selectedPaymentPlan,
                                                     final JmSource jmSource,
                                                     final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace.toString() + ") IMPORTANT: Begin addPaymentPlan JM UPDATEQUOTE" );
        log.info( "(" + trace.toString() + ") IMPORTANT: addPaymentPlan JM UPDATEQUOTE externalQuoteId: " + externalQuoteId );
        log.info( "(" + trace.toString() + ") IMPORTANT: addPaymentPlan JM UPDATEQUOTE agentInfo: " + objectMapper.writeValueAsString( agentInfoDto ) );
        log.info( "(" + trace.toString() + ") IMPORTANT: addPaymentPlan JM UPDATEQUOTE intake: " + objectMapper.writeValueAsString( intake ) );
        log.info( "(" + trace.toString() + ") IMPORTANT: addPaymentPlan JM UPDATEQUOTE selectedPaymentPlan: " + objectMapper.writeValueAsString( selectedPaymentPlan ) );
        HashMap<String, String> pluginFields = new HashMap<>();
        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( intake, actionJMSQuoteSpecDto, pluginFields );
        final String effectiveDateAnswer = intake.get( actionJMSQuoteSpecDto.getEffectiveDate() ).getAnswer();
        final LocalDateTime effectiveDate = OffsetDateTime.parse( effectiveDateAnswer ).toLocalDateTime().with( LocalTime.MIDNIGHT );
        final String formattedEffectiveDateForJmRequest = effectiveDate.format( EFFECTIVE_DATE_FORMAT );
        addQuoteRequest.setEffectiveDate( formattedEffectiveDateForJmRequest );
        addUserInfo( addQuoteRequest, objectMapper.convertValue( agentInfoDto, Map.class ) );

        addQuoteRequest.setQuoteId( externalQuoteId );

        if ( !selectedPaymentPlan.isEmpty() )
        {
            String planName = getValue( () -> ( (Map) selectedPaymentPlan ).get( "name" ).toString(), "" );
            Integer numberOfInstallments = Integer.parseInt( getValue( () -> ( (Map) selectedPaymentPlan ).get( "numberOfInstallments" ).toString(), "" ) );
            addPaymentPlan( addQuoteRequest, planName, numberOfInstallments );
        }

        log.info( "(" + trace.toString() + ") IMPORTANT: Update Quote Request going to JM for add Payment Plan: " + objectMapper.writeValueAsString( addQuoteRequest ) );

        final JMAuthData jmAuthData = jmAuthService.getAuthData( jmSource );

        AddQuoteResult updQuoteResult = getUpdateQuoteResponse( jmAuthData, addQuoteRequest );
        log.info( "(" + trace.toString() + ") IMPORTANT: Update Quote Response from JM for add Payment Plan: " + objectMapper.writeValueAsString( updQuoteResult ) );

        if ( getValue( () -> updQuoteResult.getErrorMessages().size(), 0 ) > 0 )
        {
            log.error( "(" + trace.toString() + ") IMPORTANT: JM UPDATEQUOTE for add Payment Plan has Been Rejected due to error message size is non-zero." );
            String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
            throw new Exception( errorMessage );
        }
        log.info( "(" + trace.toString() + ") IMPORTANT: Update Quote Response from JM for add Payment Plan is complete, quoteId: " + updQuoteResult.getQuoteId() );
        return new AddPaymentPlanResponseDto( UUID.fromString( updQuoteResult.getQuoteId() ) );
    }


    private AddQuoteResult getUpdateQuoteResponse( final JMAuthData jmAuthData,
                                                   final AddQuoteRequest addQuoteRequest )
    {
        try
        {
            return jmQuoteClient.updateQuote( jmAuthData.getBaseUri(),
                                              "Bearer " + jmAuthData.getAccessToken(),
                                              jmAuthData.getApiSubscriptionKey(),
                                              addQuoteRequest );
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UpdateQuote response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URL: " + jmAuthData.getBaseUri().toString() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UpdateQuote response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URL: " + jmAuthData.getBaseUri().toString() + " Message: " + e.getMessage(), e );
        }
    }


    private QuoteDto getQuoteDto( final FiredTriggerDto firedTriggerDto,
                                  final UUID requestId,
                                  final QuoteRequestSpecDto triggerSpec,
                                  final LocalDate effectiveDate,
                                  final PubQuoteDetailsDto quoteDetailsForIOI,
                                  final HashMap<String, Object> metaDatamap )
    {
        QuoteDto newQuote = QuoteDto.builder()
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .quoteTimestamp( OffsetDateTime.now() )
                                    .source( firedTriggerDto.getSource() )
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .type( QuoteType.QUOTE )
                                    .clientId( triggerSpec.getClientId() )
                                    .requestId( requestId )
                                    .effectiveDate( effectiveDate )
                                    .bindable( true )
                                    .quoteDetails( quoteDetailsForIOI )
                                    .metadata( metaDatamap )
                                    .build();
        return newQuote;
    }


    private AddQuoteResult getJmUpdateQuoteResult( final JMAuthData jmAuthData,
                                                   final AddQuoteRequest addQuoteRequest )
    {
        try
        {
            return jmQuoteClient.updateQuote( jmAuthData.getBaseUri(),
                                              "Bearer " + jmAuthData.getAccessToken(),
                                              jmAuthData.getApiSubscriptionKey(),
                                              addQuoteRequest );
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UpdateQuote response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            log.error( "IMPORTANT: an error occurred when calling JM UpdateQuote: " + e.getMessage() );
            return processFeignException( e );
        }
    }


    private AddQuoteResult getAddQuoteResult( final JMAuthData jmAuthData,
                                              final AddQuoteRequest addQuoteRequest )
    {
        try
        {
            AddQuoteResult addQuoteResult = jmQuoteClient.addQuote( jmAuthData.getBaseUri(),
                                                                    "Bearer " + jmAuthData.getAccessToken(),
                                                                    jmAuthData.getApiSubscriptionKey(),
                                                                    addQuoteRequest );
            return addQuoteResult;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a AddQuote response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            log.error( "IMPORTANT: an error occurred when calling JM AddQuote: " + e.getMessage() );
            return processFeignException( e );
        }
    }


    private QuoteDto getRejectedQuoteDto( final FiredTriggerDto firedTriggerDto,
                                          final UUID requestId,
                                          final QuoteRequestSpecDto triggerSpec,
                                          final LocalDate effectiveDate,
                                          final AddQuoteResult addQuoteResult,
                                          final Map<String, Object> metaDatamap )
    {
        List<PubMessageDto> errorMessages = new ArrayList<>();
        if ( addQuoteResult.getErrorMessages() != null )
        {
            errorMessages = addQuoteResult.getErrorMessages().stream().map( message -> PubMessageDto.builder()
                                                                                                    .type( ContentScopeType.ERROR )
                                                                                                    .message( message.toString() )
                                                                                                    .build()
            ).collect( Collectors.toList() );
        }

        List<PubMessageDto> responseMessages = new ArrayList<>();
        if ( addQuoteResult.getRespMessageList() != null )
        {
            responseMessages = addQuoteResult.getRespMessageList().stream().map( message -> PubMessageDto.builder()
                                                                                                         .type( ContentScopeType.CONSUMER )
                                                                                                         .message( message )
                                                                                                         .build()
            ).collect( Collectors.toList() );
        }


        final PubPremiumDto premiumDto = PubPremiumDto.builder().amount( new BigDecimal( -1 ) ).per( PremiumScaleType.YEAR ).build();
        final PubDurationDto durationDto = PubDurationDto.builder().length( 12 ).scale( PremiumScaleType.MONTH ).build();
        final PubQuoteDetailsDto quoteDetails = PubQuoteDetailsDto.builder().premium( premiumDto ).duration( durationDto ).build();

        final QuoteDto rejectedQuote = QuoteDto.builder()
                                               .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                               .quoteTimestamp( OffsetDateTime.now() )
                                               .source( firedTriggerDto.getSource() )
                                               .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                               .type( QuoteType.QUOTE )
                                               .clientId( triggerSpec.getClientId() )
                                               .requestId( requestId )
                                               .effectiveDate( effectiveDate )
                                               .bindable( true )
                                               .quoteDetails( quoteDetails )
                                               .metadata( metaDatamap )
                                               .messages( ListUtils.union( responseMessages, errorMessages ) )
                                               .build();
        return rejectedQuote;
    }


    private QuoteDto getRejectedQuoteDto( final FiredTriggerDto firedTriggerDto,
                                          final UUID requestId,
                                          final QuoteRequestSpecDto triggerSpec,
                                          final LocalDate effectiveDate,
                                          final Exception e )
    {
        QuoteDto rejectedQuoteDto = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, new AddQuoteResult(), Collections.emptyMap() );
        List<PubMessageDto> messages = rejectedQuoteDto.getMessages();
        PubMessageDto errorMessage = PubMessageDto.builder().type( ContentScopeType.ERROR ).message( e.getMessage() ).build();
        PubMessageDto consumerMessage = PubMessageDto.builder().type( ContentScopeType.CONSUMER ).message( GENERIC_FAILED_QUOTE_MESSSAGE ).build();
        messages.add( errorMessage );
        messages.add( consumerMessage );
        return rejectedQuoteDto;
    }


    // Add Quote Methods
    public AddQuoteRequest createAddQuoteRequest( Map<String, ClientAnswerDto> intake,
                                                  ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                  Map<String, String> pluginFields )
    {
        AddQuoteRequest addQuoteRequest = AddQuoteRequest.builder().build();

        addProducerCode( addQuoteRequest, actionJMSQuoteSpecDto, intake );

        addPaperLessOption( addQuoteRequest, actionJMSQuoteSpecDto, intake );

        AddQuoteRequest.PrimaryContact primaryContact = new AddQuoteRequest.PrimaryContact();

        AddQuoteRequest.ResidentialAddress residentialAddress = new AddQuoteRequest.ResidentialAddress();

        //Map primary contact
        primaryContact.setFirstName(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactFirstName() ).getAnswer().toString(), "" )
        );
        primaryContact.setLastName(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactLastName() ).getAnswer().toString(), "" )
        );
        primaryContact.setDateOfBirth(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactDob() ).getAnswer().toString(), "" )
        );
        primaryContact.setEmailAddress(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactEmail() ).getAnswer().toString(), "" )
        );
        primaryContact.setPhoneNumber(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactPhoneNumber() ).getAnswer().toString(), "" )
        );
        // Map residential address
        residentialAddress.setAddress1(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddr1() ).getAnswer(), "" )
        );
        residentialAddress.setAddress2(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddr2() ).getAnswer(), "" )
        );
        residentialAddress.setCity(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCity() ).getAnswer(), "" )
        );
        residentialAddress.setCountry(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCountry() ).getAnswer(), "" )
        );
        residentialAddress.setCounty(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCounty() ).getAnswer(), "" )
        );
        residentialAddress.setState(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrState() ).getAnswer(), "" )
        );
        residentialAddress.setPostalCode(
              JMUtils.formatZipCode( getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrPostalCode() ).getAnswer(), "" ) )
        );
        addQuoteRequest.setIsMailingAddressSame( false );

        // Map mailing address
        if ( getValue( () -> intake.get( actionJMSQuoteSpecDto.getHasMailingAddr() ).getAnswer(), StringUtils.EMPTY ).equals( "[]" ) )
        {
            String mailingPostalCode = intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrPostalCode() ).getAnswer();
            String mailingCounty = intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrCounty() ).getAnswer();
            if ( StringUtils.isEmpty( mailingCounty ) || StringUtils.isEmpty( mailingPostalCode ) )
            {
                log.warn( "Primary Contact Mailing address PostalCode/County is Empty.  Mailing address will not be included in JM Request" );
            }
            else
            {
                AddQuoteRequest.ResidentialAddress mailingAddress = new AddQuoteRequest.ResidentialAddress();
                mailingAddress.setAddress1(
                      getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddr1() ).getAnswer(), "" )
                );
                mailingAddress.setAddress2(
                      getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddr2() ).getAnswer(), "" )
                );
                mailingAddress.setCity(
                      getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrCity() ).getAnswer(), "" )
                );
                mailingAddress.setState(
                      getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrState() ).getAnswer(), "" )
                );
                mailingAddress.setPostalCode(
                      JMUtils.formatZipCode( getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrPostalCode() ).getAnswer(), "" ) )
                );
                String mailingAddressCountry = getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCountry() ).getAnswer(), "" );
                mailingAddress.setCountry( mailingAddressCountry );
                if ( !mailingAddressCountry.equals( "CA" ) )
                {
                    mailingAddress.setCounty(
                          getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactMailingAddrCounty() ).getAnswer(), "" )
                    );
                }
                primaryContact.setMailingAddress( mailingAddress );
            }
        }
        else if ( getValue( () -> intake.get( actionJMSQuoteSpecDto.getHasMailingAddr() ).getAnswer(),
                            StringUtils.EMPTY ).equals( "[\"Is this your Mailing Address?\"]" ) )
        {
            addQuoteRequest.setIsMailingAddressSame( true );
        }

        primaryContact.setResidentialAddress( residentialAddress );

        addQuoteRequest.setPrimaryContact( primaryContact );

        processUnderWriting( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        List<ClientLoopIterationDto> jewerlyWearers = intake.get( "jewelryWearers" ).getIterations();

        final Map<Integer, String> possessionAnswersByItemNumber = mapPossessionAnswers( intake, actionJMSQuoteSpecDto );

        List<ClientLoopIterationDto> appraisalIterations = getValue( () -> intake.get( actionJMSQuoteSpecDto.getAppraisalForm() ).getIterations(), Collections.emptyList() );

        processAddQuoteIteration( addQuoteRequest, intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), actionJMSQuoteSpecDto, jewerlyWearers, pluginFields, appraisalIterations, possessionAnswersByItemNumber );

        setCanadianParameters( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        return addQuoteRequest;
    }


    private Map<Integer, String> mapPossessionAnswers( final Map<String, ClientAnswerDto> intake,
                                                       final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        final Map<Integer, String> possessionAnswers = new HashMap<>();
        final Optional<String> possessionOfAllItems = Optional.ofNullable( getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemPossession() ).getAnswer(), null ) );
        possessionOfAllItems.ifPresent( value -> {
            final List<ClientLoopIterationDto> iterations = intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations();
            if ( "yes".equalsIgnoreCase( value ) )
            {
                for ( int i = 1; i <= iterations.size(); i++ )
                {
                    possessionAnswers.put( i, "Yes" );
                }
            }
            else if ( "no".equalsIgnoreCase( value ) )
            {
                final String itemsNotInPossession = getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemsNotInPossession() ).getAnswer(), "" );

                for ( int i = 1; i <= iterations.size(); i++ )
                {
                    if ( itemsNotInPossession.contains( String.format( "(optionIndex: %d)", i - 1 ) ) )
                    {
                        possessionAnswers.put( i, "No" );
                    }
                    else
                    {
                        possessionAnswers.put( i, "Yes" );
                    }
                }
            }
            else if ( "no - items shipped".equalsIgnoreCase( value ) )
            {
                final String itemsShipped = getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemsShipped() ).getAnswer(), "" );

                for ( int i = 1; i <= iterations.size(); i++ )
                {
                    if ( itemsShipped.contains( String.format( "(optionIndex: %d)", i - 1 ) ) )
                    {
                        possessionAnswers.put( i, "No - items shipped" );
                    }
                    else
                    {
                        possessionAnswers.put( i, "Yes" );
                    }
                }
            }
            else
            {
                log.error( "ItemPossession value found but NOT recognized! Value: {}", value );
            }
        } );

        return possessionAnswers;
    }


    private void setCanadianParameters( final AddQuoteRequest addQuoteRequest,
                                        final Map<String, ClientAnswerDto> intake,
                                        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        if ( getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCountry() ).getAnswer().toString(), StringUtils.EMPTY ).equals( "CA" ) )
        {
            AddQuoteRequest.PrimaryContact primaryContact = addQuoteRequest.getPrimaryContact();
            AddQuoteRequest.ResidentialAddress residential = primaryContact.getResidentialAddress();
            residential.setCounty( StringUtils.EMPTY );
            if ( Objects.nonNull( primaryContact.getResidentialAddress() ) )
            {
                AddQuoteRequest.ResidentialAddress mailingAddress = primaryContact.getResidentialAddress();
                if ( mailingAddress.getCountry().equals( "CA" ) )
                {
                    mailingAddress.setCounty( StringUtils.EMPTY );
                }
            }
            String consentToCredit = getValue( () -> intake.get( actionJMSQuoteSpecDto.getConsentToCredit() ).getAnswer(), "" );
            addQuoteRequest.setConsentToCredit( false );

            if ( !StringUtils.isEmpty( consentToCredit ) )
            {
                addQuoteRequest.setConsentToCredit( Boolean.parseBoolean( consentToCredit ) );
            }
        }
    }


    private void processUnderWriting( AddQuoteRequest addQuoteRequest,
                                      Map<String, ClientAnswerDto> intake,
                                      ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {

        AddQuoteRequest.UnderwritingInfo underwritingInfo = new AddQuoteRequest.UnderwritingInfo();
        underwritingInfo.setUnderwritingQuestions( new ArrayList<>() );
        underwritingInfo.setLossHistoryEvents( new ArrayList<>() );


        String conviction = getValue( () -> intake.get( "conviction" ).getAnswer(), "" );
        String misdemeanorFlag = "no";
        String felonyFlag = "no";
        if ( conviction.contains( "Misdemeanor" ) )
        {
            misdemeanorFlag = "yes";
        }
        if ( conviction.contains( "Felony" ) )
        {
            felonyFlag = "yes";
        }

        AddQuoteRequest.UnderwritingQuestion misdemeanor = new AddQuoteRequest.UnderwritingQuestion();
        misdemeanor.setKey( "misdemeanorConviction" );
        misdemeanor.setValue( misdemeanorFlag );
        underwritingInfo.getUnderwritingQuestions().add( misdemeanor );


        AddQuoteRequest.UnderwritingQuestion felony = new AddQuoteRequest.UnderwritingQuestion();
        felony.setKey( "felonyConviction" );
        felony.setValue( felonyFlag );
        underwritingInfo.getUnderwritingQuestions().add( felony );

        AddQuoteRequest.UnderwritingQuestion lostWithin7Years = new AddQuoteRequest.UnderwritingQuestion();
        lostWithin7Years.setKey( "lostWithin7Years" );
        lostWithin7Years.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getLostWithin7Years() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( lostWithin7Years );


        AddQuoteRequest.UnderwritingQuestion crimeForProfit = new AddQuoteRequest.UnderwritingQuestion();
        crimeForProfit.setKey( "crimeForProfit" );
        crimeForProfit.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCrimeForProfit() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( crimeForProfit );

        AddQuoteRequest.UnderwritingQuestion cancelledCoverage = new AddQuoteRequest.UnderwritingQuestion();
        cancelledCoverage.setKey( "canceledOrDeniedCoverage" );
        cancelledCoverage.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCanceledOrDeniedCoverage() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( cancelledCoverage );

        AddQuoteRequest.UnderwritingQuestion coverageDenyReason = new AddQuoteRequest.UnderwritingQuestion();
        coverageDenyReason.setKey( "CoverageDenyReason" );
        coverageDenyReason.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCoverageDenyReason() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( coverageDenyReason );

        AddQuoteRequest.UnderwritingQuestion storeJewelryInSafeDepositBox = new AddQuoteRequest.UnderwritingQuestion();
        storeJewelryInSafeDepositBox.setKey( "StoreJewelryInSafeDepositBox" );
        storeJewelryInSafeDepositBox.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getStoreJewelryInSafeDepositBox() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( storeJewelryInSafeDepositBox );

        AddQuoteRequest.UnderwritingQuestion safeDepositBoxLocation = new AddQuoteRequest.UnderwritingQuestion();
        safeDepositBoxLocation.setKey( "SafeDepositBoxLocation" );
        safeDepositBoxLocation.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getSafeDepositBoxLocation() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( safeDepositBoxLocation );

        AddQuoteRequest.UnderwritingQuestion livesInGatedEntranceCommunity = new AddQuoteRequest.UnderwritingQuestion();
        livesInGatedEntranceCommunity.setKey( "LivesInGatedEntranceCommunity" );
        livesInGatedEntranceCommunity.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getLivesInGatedEntranceCommunity() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( livesInGatedEntranceCommunity );

        AddQuoteRequest.UnderwritingQuestion communityHasFence = new AddQuoteRequest.UnderwritingQuestion();
        communityHasFence.setKey( "CommunityHasFence" );
        communityHasFence.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityHasFence() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( communityHasFence );

        AddQuoteRequest.UnderwritingQuestion communityHasGuardsAtGate = new AddQuoteRequest.UnderwritingQuestion();
        communityHasGuardsAtGate.setKey( "CommunityHasGuardsAtGate" );
        communityHasGuardsAtGate.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityHasGuardsAtGate() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( communityHasGuardsAtGate );

        AddQuoteRequest.UnderwritingQuestion communityGuardsFrequency = new AddQuoteRequest.UnderwritingQuestion();
        communityGuardsFrequency.setKey( "CommunityGuardsFrequency" );
        communityGuardsFrequency.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityGuardsFrequency() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( communityGuardsFrequency );

        AddQuoteRequest.UnderwritingQuestion communityIsPatrolled = new AddQuoteRequest.UnderwritingQuestion();
        communityIsPatrolled.setKey( "CommunityIsPatrolled" );
        communityIsPatrolled.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityIsPatrolled() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( communityIsPatrolled );

        AddQuoteRequest.UnderwritingQuestion communityPatrolFrequency = new AddQuoteRequest.UnderwritingQuestion();
        communityPatrolFrequency.setKey( "CommunityPatrolFrequency" );
        communityPatrolFrequency.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityPatrolFrequency() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( communityPatrolFrequency );

        AddQuoteRequest.UnderwritingQuestion communityResidentEntranceDescription = new AddQuoteRequest.UnderwritingQuestion();
        communityResidentEntranceDescription.setKey( "CommunityResidentEntranceDescription" );
        final String communityResidentEntranceDescriptionValue = getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityResidentEntranceDescription() ).getAnswer(), "" );
        if ( "Other".equalsIgnoreCase( communityResidentEntranceDescriptionValue ) )
        {
            communityResidentEntranceDescription.setValue( "Other - " + getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityResidentEntranceDescriptionOther() ).getAnswer(), "" ) );
        }
        else
        {
            communityResidentEntranceDescription.setValue( communityResidentEntranceDescriptionValue );
        }
        underwritingInfo.getUnderwritingQuestions().add( communityResidentEntranceDescription );

        AddQuoteRequest.UnderwritingQuestion communityGuestEntranceDescription = new AddQuoteRequest.UnderwritingQuestion();
        communityGuestEntranceDescription.setKey( "CommunityGuestEntranceDescription" );
        final String communityGuestEntranceDescriptionValue = getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityGuestEntranceDescription() ).getAnswer(), "" );
        if ( "Other".equalsIgnoreCase( communityGuestEntranceDescriptionValue ) )
        {
            communityGuestEntranceDescription.setValue( "Other - " + getValue( () -> intake.get( actionJMSQuoteSpecDto.getCommunityGuestEntranceDescriptionOther() ).getAnswer(), "" ) );
        }
        else
        {
            communityGuestEntranceDescription.setValue( communityGuestEntranceDescriptionValue );
        }
        underwritingInfo.getUnderwritingQuestions().add( communityGuestEntranceDescription );

        AddQuoteRequest.UnderwritingQuestion domesticHelpEmployed = new AddQuoteRequest.UnderwritingQuestion();
        domesticHelpEmployed.setKey( "DomesticHelpEmployed" );
        domesticHelpEmployed.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpEmployed() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( domesticHelpEmployed );

        AddQuoteRequest.UnderwritingQuestion domesticHelpDescription = new AddQuoteRequest.UnderwritingQuestion();
        domesticHelpDescription.setKey( "DomesticHelpDescription" );
        final String domesticHelpDescriptionValue = getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpDescription() ).getAnswer(), "" );
        if ( "Other".equalsIgnoreCase( domesticHelpDescriptionValue ) )
        {
            domesticHelpDescription.setValue( "Other - " + getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpDescriptionOther() ).getAnswer(), "" ) );
        }
        else
        {
            domesticHelpDescription.setValue( domesticHelpDescriptionValue );
        }
        underwritingInfo.getUnderwritingQuestions().add( domesticHelpDescription );

        AddQuoteRequest.UnderwritingQuestion domesticHelpEmploymentLength = new AddQuoteRequest.UnderwritingQuestion();
        domesticHelpEmploymentLength.setKey( "DomesticHelpEmploymentLength" );
        domesticHelpEmploymentLength.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpEmploymentLength() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( domesticHelpEmploymentLength );

        AddQuoteRequest.UnderwritingQuestion domesticHelpResidesAtHome = new AddQuoteRequest.UnderwritingQuestion();
        domesticHelpResidesAtHome.setKey( "DomesticHelpResidesAtHome" );
        domesticHelpResidesAtHome.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpResidesAtHome() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( domesticHelpResidesAtHome );

        AddQuoteRequest.UnderwritingQuestion domesticHelpVisitFrequency = new AddQuoteRequest.UnderwritingQuestion();
        domesticHelpVisitFrequency.setKey( "DomesticHelpVisitFrequency" );
        domesticHelpVisitFrequency.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getDomesticHelpVisitFrequency() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( domesticHelpVisitFrequency );

        AddQuoteRequest.UnderwritingQuestion homeHasOtherResidents = new AddQuoteRequest.UnderwritingQuestion();
        homeHasOtherResidents.setKey( "HomeHasOtherResidents" );
        homeHasOtherResidents.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getHomeHasOtherResidents() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( homeHasOtherResidents );

        AddQuoteRequest.UnderwritingQuestion homeOtherResidentsDescription = new AddQuoteRequest.UnderwritingQuestion();
        homeOtherResidentsDescription.setKey( "HomeOtherResidentsDescription" );
        homeOtherResidentsDescription.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getHomeOtherResidentsDescription() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( homeOtherResidentsDescription );

        AddQuoteRequest.UnderwritingQuestion howOftenJewelryWorn = new AddQuoteRequest.UnderwritingQuestion();
        howOftenJewelryWorn.setKey( "HowOftenJewelryWorn" );
        howOftenJewelryWorn.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getHowOftenJewelryWorn() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( howOftenJewelryWorn );

        AddQuoteRequest.UnderwritingQuestion travelOvernightFrequency = new AddQuoteRequest.UnderwritingQuestion();
        travelOvernightFrequency.setKey( "TravelOvernightFrequency" );
        travelOvernightFrequency.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getTravelOvernightFrequency() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( travelOvernightFrequency );

        AddQuoteRequest.UnderwritingQuestion travelOverseas = new AddQuoteRequest.UnderwritingQuestion();
        travelOverseas.setKey( "TravelOverseas" );
        travelOverseas.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getTravelOverseas() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( travelOverseas );

        AddQuoteRequest.UnderwritingQuestion travelPrecautionOption = new AddQuoteRequest.UnderwritingQuestion();
        travelPrecautionOption.setKey( "TravelPrecautionOption" );
        travelPrecautionOption.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getTravelPrecautionOption() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( travelPrecautionOption );

        AddQuoteRequest.UnderwritingQuestion travelPrecautionOtherDescription = new AddQuoteRequest.UnderwritingQuestion();
        travelPrecautionOtherDescription.setKey( "TravelPrecautionOtherDescription" );
        travelPrecautionOtherDescription.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getTravelPrecautionOtherDescription() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( travelPrecautionOtherDescription );

        AddQuoteRequest.UnderwritingQuestion additionalUnderwriting = new AddQuoteRequest.UnderwritingQuestion();
        additionalUnderwriting.setKey( "IsAdditionalUnderwritingNeeded" );
        additionalUnderwriting.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getAdditionalUnderwriting() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( additionalUnderwriting );


        AddQuoteRequest.UnderwritingQuestion alarmId = new AddQuoteRequest.UnderwritingQuestion();
        alarmId.setKey( "AlarmId" );

        String alarmText = getValue( () -> intake.get( actionJMSQuoteSpecDto.getAlarmId() ).getAnswer().toString(), "" );

        alarmId.setValue( alarmText );
        underwritingInfo.getUnderwritingQuestions().add( alarmId );

        AddQuoteRequest.UnderwritingQuestion convictionType = new AddQuoteRequest.UnderwritingQuestion();
        convictionType.setKey( "ConvictionType" );
        convictionType.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getConvictionType() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( convictionType );

        AddQuoteRequest.UnderwritingQuestion convictionSentenceCompletionDate = new AddQuoteRequest.UnderwritingQuestion();
        convictionSentenceCompletionDate.setKey( "ConvictionSentenceCompletionDate" );

        String completionDate = getValue( () -> intake.get( actionJMSQuoteSpecDto.getConvictionSentenceCompletionDate() ).getAnswer(), "" );
        if ( completionDate != null && completionDate.length() > 10 )
        {
            completionDate = completionDate.substring( 0, 10 );
        }
        convictionSentenceCompletionDate.setValue( completionDate );
        underwritingInfo.getUnderwritingQuestions().add( convictionSentenceCompletionDate );
        //add underwriting questions here

        addQuoteRequest.setUnderwritingInfo( underwritingInfo );

        List<ClientLoopIterationDto> lostTheftDamage = getValue( () -> intake.get( actionJMSQuoteSpecDto.getLostTheftDamageLoop() ).getIterations(), new ArrayList<ClientLoopIterationDto>() );

        for ( ClientLoopIterationDto clientLoopIterationDto : lostTheftDamage )
        {

            AddQuoteRequest.LossHistoryEvent lossHistoryEvent = new AddQuoteRequest.LossHistoryEvent();
            lossHistoryEvent.setLossType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getTypeOfLoss() ).getAnswer().toLowerCase(), "" ).toString()

            );
            lossHistoryEvent.setAmount(
                  Double.parseDouble( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getAmountOfLoss() ).getAnswer().toString(), "" ) )

            );
            lossHistoryEvent.setLossDate(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getDateOfLoss() ).getAnswer().toString(), "" ).toString()

            );
            addQuoteRequest.getUnderwritingInfo().getLossHistoryEvents().add( lossHistoryEvent );
        }
    }


    private void processAddQuoteIteration( AddQuoteRequest addQuoteRequest,
                                           List<ClientLoopIterationDto> iterations,
                                           ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                           List<ClientLoopIterationDto> jewerlyWearers,
                                           Map<String, String> pluginFields,
                                           final List<ClientLoopIterationDto> appraisalIterations,
                                           final Map<Integer, String> possessionAnswersByItemNumber )
    {
        ArrayList<AddQuoteRequest.JeweleryItem> jeweleryItems = new ArrayList<>();
        int itemNumber = 1;
        ArrayList<AddQuoteRequest.DeductibleOption> deductibleOptions = new ArrayList<>();
        for ( ClientLoopIterationDto clientLoopIterationDto : iterations )
        {
            AddQuoteRequest.JeweleryItem item = new AddQuoteRequest.JeweleryItem();

            item.setJeweleryType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemType() ).getAnswer().toLowerCase(), "" ).toString()
            );
            item.setJewelerySubType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemSubType() ).getAnswer(), "" ).toString()
            );

            item.setItemNumber(
                  itemNumber
            );
            item.setItemValue(
                  Double.parseDouble( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer(), "0.00" ) )
            );

            item.setItemDescription(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemDescription() ).getAnswer(), "" )
            );

            final String itemDamage = getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemDamage() ).getAnswer(), null );

            if ( itemDamage != null )
            {
                item.setItemDamage( ( "none".equalsIgnoreCase( itemDamage ) || itemDamage.isEmpty() ) ? "no" : "yes" );
            }

            final int finalItemNumber = itemNumber;
            item.setItemPossession(
                  getValue( () -> possessionAnswersByItemNumber.get( finalItemNumber ), null )
            );

            item.setSerialNumber(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getSerialNumber() ).getAnswer(), "" )
            );

            item.setGender(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemGender() ).getAnswer(), "" )
            );

            AddQuoteRequest.PrimaryWearer primaryWearer;

            String wearerId = getValue( () -> clientLoopIterationDto.getAnswers().get( "wearerValue" ).getAnswer(), "primary" );

            // wearerId will give the ID of the wearer or say primary if the applicant is same as the primary
            ClientLoopIterationDto wearerDto;

         /*   if ( wearerId.equalsIgnoreCase( "primary" )) {
                primaryWearer = mapToPrimary( clientLoopIterationDto, actionJMSQuoteSpecDto );
            }*/
            primaryWearer = mapToPrimary( clientLoopIterationDto, actionJMSQuoteSpecDto );

            if ( !wearerId.equalsIgnoreCase( "primary" ) )
            {
                wearerDto = jewerlyWearers.stream().filter( wearer -> getValue( () -> wearer.getAnswers().get( "id" ).getAnswer().toString(), "" ).equalsIgnoreCase( wearerId ) ).findFirst().get();
                AddQuoteRequest.PrimaryWearer nonContactWearer = mapToWearer( wearerDto, actionJMSQuoteSpecDto );
                if ( getValue( () -> wearerDto.getAnswers().get( "sameAsPrimary" ).getAnswer().toString(), "" ).contains( "same" ) )
                {
                    nonContactWearer.setResidentialAddress( primaryWearer.getResidentialAddress() );
                }
                primaryWearer = nonContactWearer;
            }

            AddQuoteRequest.DeductibleOption deductibleOption = new AddQuoteRequest.DeductibleOption();

            deductibleOption.setDeductible(
                  Double.parseDouble( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getDeductible() ).getAnswer(), "0" ) )
            );

            deductibleOption.setItemNumber(
                  itemNumber
            );

            deductibleOptions.add( deductibleOption );

            item.setPrimaryWearer( primaryWearer );

            final int appraisalIterationNumber = itemNumber - 1;

            item.setLastAppraisalDate(
                  getValue( () -> convertDateTimeToDate( Iterables.get( appraisalIterations, appraisalIterationNumber, null )
                                                                  .getAnswers().get( actionJMSQuoteSpecDto.getLastAppraisalDate() ).getAnswer() ), "" )
            );

            item.setIsItemHasAppraisal(
                  getValue( () -> !Iterables.get( appraisalIterations, appraisalIterationNumber, null )
                                            .getAnswers().get( actionJMSQuoteSpecDto.getAppraisalDocUpload() ).getFiles().isEmpty(), false )
            );

            jeweleryItems.add( item );

            pluginFields.put( "ItemDamage" + itemNumber,
                              getValue( () -> clientLoopIterationDto.getAnswers().get( "existingDamage" ).getAnswer().toString(), "" )
            );

            itemNumber++;
        }
        addQuoteRequest.setDeductibleOptions( deductibleOptions );
        addQuoteRequest.setJeweleryItems( jeweleryItems );
    }


    private void addUserInfo( AddQuoteRequest addQuoteRequest,
                              final Map<String, String> agentInfoMap )
    {

        AddQuoteRequest.User userInfo = new AddQuoteRequest.User();


        String emailString = getValue( () -> agentInfoMap.get( "email" ).toString(), "@" );

        String emailId = "";

        if ( emailString.contains( "@" ) )
        {
            emailId = emailString.substring( 0, emailString.indexOf( "@" ) );
        }
        String userId = "JEWELERSNT/" + emailId;


        userInfo.setUserId( userId );
        userInfo.setUserFirstName( getValue( () -> agentInfoMap.get( "firstName" ), "" ) );
        userInfo.setUserLastName( getValue( () -> agentInfoMap.get( "lastName" ), "" ) );
        userInfo.setUserEmailAddress( getValue( () -> agentInfoMap.get( "email" ), "" ) );
        userInfo.setUserPhoneNumber( getValue( () -> agentInfoMap.get( "phoneNumber" ), "" ) );

        addQuoteRequest.setUser( userInfo );
    }


    private AddQuoteRequest.PrimaryWearer mapToWearer( ClientLoopIterationDto wearerDto,
                                                       ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {

        AddQuoteRequest.PrimaryWearer primaryWearer = new AddQuoteRequest.PrimaryWearer();

        primaryWearer.setLastName(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerLastName() ).getAnswer().toString(), "" )
        );

        primaryWearer.setFirstName(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerFirstName() ).getAnswer().toString(), "" )
        );

        primaryWearer.setPhoneNumber(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerPhoneNumber() ).getAnswer().toString(), "" )
        );

        primaryWearer.setDateOfBirth(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerDob() ).getAnswer().toString(), "" )
        );

        primaryWearer.setEmailAddress(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerEmail() ).getAnswer().toString(), "" )
        );

        primaryWearer.setPhoneNumber(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerPhoneNumber() ).getAnswer().toString(), "" )
        );

        primaryWearer.setRelationWithApplicant(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerRelationWithApplicant() ).getAnswer().toString(), "" )
        );

        AddQuoteRequest.ResidentialAddress primaryWearerResidentialAddress = new AddQuoteRequest.ResidentialAddress();

        primaryWearerResidentialAddress.setAddress1(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddr1() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setAddress2(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddr2() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setCity(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCity() ).getAnswer(), "" )
        );

        String primaryWearerResidentialCountry = getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCountry() ).getAnswer(), "" );
        primaryWearerResidentialAddress.setCountry( primaryWearerResidentialCountry );

        if ( !primaryWearerResidentialCountry.equals( "CA" ) )
        {
            primaryWearerResidentialAddress.setCounty(
                  getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCounty() ).getAnswer(), "" )
            );
        }


        primaryWearerResidentialAddress.setState(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrState() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setPostalCode(
              JMUtils.formatZipCode( getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrPostalCode() ).getAnswer().toString(), "" ) )
        );

        primaryWearer.setResidentialAddress( primaryWearerResidentialAddress );

        return primaryWearer;
    }


    private AddQuoteRequest.PrimaryWearer mapToPrimary( ClientLoopIterationDto wearerDto,
                                                        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {

        AddQuoteRequest.PrimaryWearer primaryWearer = new AddQuoteRequest.PrimaryWearer();

        primaryWearer.setLastName(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactLastName() ).getAnswer().toString(), "" )
        );

        primaryWearer.setFirstName(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactFirstName() ).getAnswer().toString(), "" )
        );

        primaryWearer.setPhoneNumber(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactPhoneNumber() ).getAnswer().toString(), "" )
        );

        primaryWearer.setDateOfBirth(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactDob() ).getAnswer().toString(), "" )
        );

        primaryWearer.setEmailAddress(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactEmail() ).getAnswer().toString(), "" )
        );

        primaryWearer.setRelationWithApplicant(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerRelationWithApplicant() ).getAnswer().toString(), "" )
        );

        AddQuoteRequest.ResidentialAddress primaryWearerResidentialAddress = new AddQuoteRequest.ResidentialAddress();

        primaryWearerResidentialAddress.setAddress1(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddr1() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setAddress2(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddr2() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setCity(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCity() ).getAnswer(), "" )
        );

        String primaryWearerResidentialCountry = getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCountry() ).getAnswer(), "" );
        primaryWearerResidentialAddress.setCountry( primaryWearerResidentialCountry );
        if ( !primaryWearerResidentialCountry.equals( "CA" ) )
        {
            primaryWearerResidentialAddress.setCounty(
                  getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCounty() ).getAnswer(), "" )
            );
        }

        primaryWearerResidentialAddress.setState(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddrState() ).getAnswer(), "" )
        );
        primaryWearerResidentialAddress.setPostalCode(
              JMUtils.formatZipCode( getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryContactResAddrPostalCode() ).getAnswer(), "" ) )
        );

        primaryWearer.setResidentialAddress( primaryWearerResidentialAddress );

        return primaryWearer;
    }


    private void addPaymentPlan( AddQuoteRequest addQuoteRequest,
                                 String name,
                                 int installments )
    {

        AddQuoteRequest.SelectedPlan selectedPlan = new AddQuoteRequest.SelectedPlan();
        selectedPlan.setName( name );
        selectedPlan.setNumberOfInstallments( installments );
        addQuoteRequest.setSelectedPaymentPlan( selectedPlan );
    }


    private void addProducerCode( AddQuoteRequest addQuoteRequest,
                                  ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                  Map<String, ClientAnswerDto> intake )
    {

        String producerCode = "";

        String customerInfoReferralSource = getValue( () -> intake.get( actionJMSQuoteSpecDto.getCustomerInfoReferralSource() ).getAnswer(), "" );

        if ( customerInfoReferralSource.equalsIgnoreCase( "Agency Express" ) )
        {
            producerCode = getValue( () -> intake.get( actionJMSQuoteSpecDto.getCustomerInfoAgencyExpressOptions() ).getAnswer(), "" );
        }
        else
        {
            producerCode = customerInfoReferralSource;
        }

        if ( producerCode.equalsIgnoreCase( "" ) )
        {
            producerCode = "DIRD";
        }
        addQuoteRequest.setProducerCode( producerCode );
    }


    private void addPaperLessOption( AddQuoteRequest addQuoteRequest,
                                     ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                     Map<String, ClientAnswerDto> intake )
    {

        boolean paperlessOption = false;

        String hasPaperlessDelivery = getValue( () -> intake.get( actionJMSQuoteSpecDto.getHasPaperlessDelivery() ).getAnswer().toString(), "" );

        if ( hasPaperlessDelivery.equalsIgnoreCase( "true" ) )
        {
            paperlessOption = true;
        }

        addQuoteRequest.setHasPaperlessDelivery( paperlessOption );
    }



    private PubQuoteDetailsDto getQuoteDetailsForIOI( AddQuoteResult addQuoteResult,
                                                      final AddQuoteRequest addQuoteRequest,
                                                      final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                      final LinkedHashMap<String, ClientAnswerDto> intake )
    {

        Map<Integer, AdditionalItemInfoDto> itemIdToAdditionalItemInfo = getItemIdToAdditionalItemInfo( addQuoteResult, intake, actionJMSQuoteSpecDto );

        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        quoteBuilder.premium( buildPremium( addQuoteResult ) );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        addQuoteResult.getRatingInfo().getItemRateDetails().forEach( itemRateDetail -> {

            PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

            AddQuoteRequest.JeweleryItem jeweleryItem = addQuoteRequest.getJeweleryItems()
                                                                       .stream()
                                                                       .filter( item -> item.getItemNumber() == itemRateDetail.getItemNumber() )
                                                                       .collect( Collectors.toList() )
                                                                       .iterator()
                                                                       .next();
            pubCoveragesBuilder.type( jeweleryItem.getJeweleryType() );

            ArrayList<AddQuoteRequest.DeductibleOption> deductibleOptions = addQuoteRequest.getDeductibleOptions();
            deductibleOptions.forEach( deductibleOption -> {
                if ( deductibleOption.getItemNumber() == itemRateDetail.getItemNumber() )
                {
                    AdditionalItemInfoDto additionalItemInfoDto = itemIdToAdditionalItemInfo.getOrDefault( jeweleryItem.getItemNumber(), new AdditionalItemInfoDto() );
                    List<PubCoverageDto> coverages = getPubCoveragesForDeductibleOption( itemRateDetail, deductibleOption, additionalItemInfoDto );
                    pubCoveragesBuilder.coverages( coverages );
                }
            } );

            pubCoverages.add( pubCoveragesBuilder.build() );
        } );
        quoteBuilder.coverageTypes( pubCoverages );

        PubExternalDataDto.PubExternalDataDtoBuilder externalDataBuilder = PubExternalDataDto.builder();

        externalDataBuilder.externalQuoteId( addQuoteResult.getQuoteId() );

        quoteBuilder.externalData( externalDataBuilder.build() );

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
    }



    private PubQuoteDetailsDto getQuoteDetailsForQuoteOption( AddQuoteResult addQuoteResult,
                                                              final AddQuoteRequest addQuoteRequest,
                                                              final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                              final LinkedHashMap<String, ClientAnswerDto> intake )
    {
        Map<Integer, AdditionalItemInfoDto> itemIdToAdditionalItemInfo = getItemIdToAdditionalItemInfo( addQuoteResult, intake, actionJMSQuoteSpecDto );

        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        quoteBuilder.premium( buildPremium( addQuoteResult ) );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        addQuoteResult.getRatingInfo().getItemRateDetails().forEach( itemRateDetail -> {

            PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

            AddQuoteRequest.JeweleryItem jeweleryItem = addQuoteRequest.getJeweleryItems()
                                                                       .stream()
                                                                       .filter( item -> item.getItemNumber() == itemRateDetail.getItemNumber() )
                                                                       .collect( Collectors.toList() )
                                                                       .iterator()
                                                                       .next();
            pubCoveragesBuilder.type( jeweleryItem.getJeweleryType() );

            ArrayList<AddQuoteRequest.DeductibleOption> deductibleOptions = addQuoteRequest.getDeductibleOptions();
            deductibleOptions.forEach( deductibleOption -> {
                if ( deductibleOption.getItemNumber() == itemRateDetail.getItemNumber() )
                {
                    AdditionalItemInfoDto additionalItemInfoDto = itemIdToAdditionalItemInfo.get( jeweleryItem.getItemNumber() );
                    List<PubCoverageDto> coverages = getPubCoverages( itemRateDetail, additionalItemInfoDto );
                    pubCoveragesBuilder.coverages( coverages );
                }
            } );

            pubCoverages.add( pubCoveragesBuilder.build() );
        } );
        quoteBuilder.coverageTypes( pubCoverages );

        PubExternalDataDto.PubExternalDataDtoBuilder externalDataBuilder = PubExternalDataDto.builder();

        externalDataBuilder.externalQuoteId( addQuoteResult.getQuoteId() );

        quoteBuilder.externalData( externalDataBuilder.build() );

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
    }


    private Map<Integer, AdditionalItemInfoDto> getItemIdToAdditionalItemInfo( final AddQuoteResult addQuoteResult,
                                                                               final LinkedHashMap<String, ClientAnswerDto> intake,
                                                                               final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        final Map<Integer, AdditionalItemInfoDto> itemIdToIterationId = new HashMap<>();
        if ( intake.containsKey( actionJMSQuoteSpecDto.getItemLoop() ) )
        {
            final List<ClientLoopIterationDto> intakeItems = getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), new ArrayList<>() );
            final AddQuoteResult.RatingInfo ratingInfo = addQuoteResult.getRatingInfo();
            final ArrayList<AddQuoteResult.ItemRateDetail> jmItemInfo = ratingInfo.getItemRateDetails();
            final Integer jmItemCount = jmItemInfo.size();
            final Integer intakeItemCount = intakeItems.size();
            if ( NumberUtils.compare( jmItemCount, intakeItemCount ) != 0 )
            {
                //TODO: Reenable when JM PROD is stable
                //throw new InvalidParameterException( String.format( "jmItemCount(%s) is not equal to intakeItemCount(%s)", jmItemCount, intakeItemCount ) );
            }
            else
            {
                for ( final ClientLoopIterationDto item : intakeItems )
                {
                    final AddQuoteResult.ItemRateDetail itemRateDetail = jmItemInfo.get( intakeItems.indexOf( item ) );
                    final Integer itemId = Integer.valueOf( itemRateDetail.getItemNumber() );
                    final UUID iterationId = item.getIterationId();

                    final AdditionalItemInfoDto.AdditionalItemInfoDtoBuilder additionalItemInfoDtoBuilder = AdditionalItemInfoDto.builder();
                    additionalItemInfoDtoBuilder.iterationId( iterationId );

                    final Map<String, ClientAnswerDto> itemAnswers = item.getAnswers();
                    if ( itemAnswers.containsKey( getValue( () -> actionJMSQuoteSpecDto.getItemValue(), "" ) ) )
                    {
                        final ClientAnswerDto itemValueAnswer = itemAnswers.get( getValue( () -> actionJMSQuoteSpecDto.getItemValue(), "" ) );
                        final String itemValue = itemValueAnswer.getAnswer();
                        additionalItemInfoDtoBuilder.itemValue( itemValue );
                    }
                    itemIdToIterationId.put( itemId, additionalItemInfoDtoBuilder.build() );
                }
            }
        }
        return itemIdToIterationId;
    }


    private PubPremiumDto buildPremium( AddQuoteResult addQuoteResult )
    {
        PubPremiumDto.PubPremiumDtoBuilder premiumBuilder = PubPremiumDto.builder();

        final NormalizedPremium normalizedPremium = new NormalizedPremium( addQuoteResult.ratingInfo );

        premiumBuilder.amount( normalizedPremium.getPremiumOnly() );

        premiumBuilder.taxesAndFees( Arrays.asList( PubPremiumTaxesDto.builder()
                                                                      .amount( normalizedPremium.getTotalTaxesAndSurcharges() )
                                                                      .type( "Taxes and Surcharges" ).build(),
                                                    PubPremiumTaxesDto.builder()
                                                                      .amount( normalizedPremium.getDiscount() )
                                                                      .type( "Discount" ).build() ) );

        return premiumBuilder.build();
    }


    private List<PubCoverageDto> getPubCoverages( final AddQuoteResult.ItemRateDetail itemRateDetail,
                                                  final AdditionalItemInfoDto additionalItemInfoDto )
    {
        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            PubCoverageDto pubCoverageDto = getPubCoverageDto( itemRateDetail.getItemNumber(), additionalItemInfoDto, rateOption );
            coverages.add( pubCoverageDto );
        }
        return coverages;
    }


    private List<PubCoverageDto> getPubCoveragesForDeductibleOption( AddQuoteResult.ItemRateDetail itemRateDetail,
                                                                     AddQuoteRequest.DeductibleOption deductibleOption,
                                                                     final AdditionalItemInfoDto additionalItemInfoDto )
    {
        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            if ( Double.valueOf( rateOption.getDeductible() ).equals( deductibleOption.getDeductible() ) )
            {
                PubCoverageDto pubCoverageDto = getPubCoverageDto( deductibleOption.getItemNumber(), additionalItemInfoDto, rateOption );
                coverages.add( pubCoverageDto );
            }
        }
        return coverages;
    }


    private PubCoverageDto getPubCoverageDto( final int itemNumber,
                                              final AdditionalItemInfoDto additionalItemInfo,
                                              final AddQuoteResult.RateOption rateOption )
    {
        PubCoverageDto.PubCoverageDtoBuilder pubCoverageBuilder = PubCoverageDto.builder();
        BigDecimal premium = new BigDecimal( rateOption.getRateBreakdown().get( 0 ).getRateValue() ).setScale( 2, RoundingMode.HALF_EVEN );
        pubCoverageBuilder.premium( premium );
        Map<String, List<PubCoverageDetailDto>> details = new HashMap<>();

        PubCoverageDetailDto.PubCoverageDetailDtoBuilder deductibleBuilder = PubCoverageDetailDto.builder();
        deductibleBuilder.amountType( AmountType.DOLLAR );
        deductibleBuilder.amount( ( (Integer) rateOption.getDeductible() ).toString() );
        details.put( "deductible", Collections.singletonList( deductibleBuilder.build() ) );

        PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemTaxesAndSurchargesBuilder = PubCoverageDetailDto.builder();
        itemTaxesAndSurchargesBuilder.amountType( AmountType.DOLLAR );
        itemTaxesAndSurchargesBuilder.amount( ( (Double) rateOption.getRateBreakdown().get( 1 ).getRateValue() ).toString() );
        details.put( "itemTaxesAndSurcharges", Collections.singletonList( itemTaxesAndSurchargesBuilder.build() ) );

        PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemIdBuilder = PubCoverageDetailDto.builder();
        itemIdBuilder.amountType( AmountType.TEXT );
        itemIdBuilder.amount( String.valueOf( itemNumber ) );
        details.put( "itemId", Collections.singletonList( itemIdBuilder.build() ) );

        if ( additionalItemInfo.getItemValue() != null )
        {
            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemValueBuilder = PubCoverageDetailDto.builder();
            itemValueBuilder.amountType( AmountType.DOLLAR );
            itemValueBuilder.amount( Double.valueOf( additionalItemInfo.getItemValue() ).toString() );
            details.put( "itemValue", Collections.singletonList( itemValueBuilder.build() ) );
        }


        //TODO: Disabled until JM Prod is Stable
        //        if ( additionalItemInfo.getIterationId() != null )
        //        {
        //            PubCoverageDetailDto.PubCoverageDetailDtoBuilder iterationIdBuilder = PubCoverageDetailDto.builder();
        //            iterationIdBuilder.amountType( AmountType.TEXT );
        //            iterationIdBuilder.amount( additionalItemInfo.getIterationId().toString() );
        //            details.put( "iterationId", Collections.singletonList( iterationIdBuilder.build() ) );
        //        }


        pubCoverageBuilder.details( details );
        PubCoverageDto pubCoverageDto = pubCoverageBuilder.build();
        return pubCoverageDto;
    }


    private void saveFieldsForPlugin( UUID requestId,
                                      AddQuoteResult addQuoteResult,
                                      HashMap<String, String> fieldsForPlugin,
                                      UUID clientId )
    {

        ExternalQuoteDataDto externalQuoteDataDto = new ExternalQuoteDataDto();

        externalQuoteDataDto.setQuoteId( requestId );

        externalQuoteDataDto.setExternalQuoteId( addQuoteResult.getQuoteId() );

        externalQuoteDataDto.setQuoteData( fieldsForPlugin );

        externalQuoteDataDto.setClientId( clientId );

        externalQuoteDataService.saveOrUpdate( externalQuoteDataDto );
    }


    private AddQuoteResult processFeignException( final FeignException e )
    {
        AddQuoteResult addQuoteResult = null;
        if ( e.status() == 400 )
        {
            try
            {
                addQuoteResult = objectMapper.readValue( e.contentUTF8(), AddQuoteResult.class );
            }
            catch ( Exception ex )
            {
                log.error( "IMPORTANT: Error while parsing exception content to AddQuoteResult. Content: {}", e.contentUTF8() );
            }


            if ( addQuoteResult == null )
            {
                addQuoteResult = AddQuoteResult.builder().errorMessages( Arrays.asList( "An Error Occurred when calling JM Add or Update Quote." ) )
                                               .respMessageList( Arrays.asList( GENERIC_FAILED_QUOTE_MESSSAGE ) ).build();
            }
            if ( CollectionUtils.isEmpty( addQuoteResult.getRespMessageList() ) )
            {
                addQuoteResult.setRespMessageList( addQuoteResult.getErrorMessages() != null ? addQuoteResult.getErrorMessages() : Arrays.asList( GENERIC_FAILED_QUOTE_MESSSAGE ) );
            }
            if ( CollectionUtils.isEmpty( addQuoteResult.getErrorMessages() ) )
            {
                addQuoteResult.setErrorMessages( Arrays.asList( "An Error Occurred when calling JM Add or Update Quote." ) );
            }
        }
        else
        {
            addQuoteResult = AddQuoteResult.builder().errorMessages( Arrays.asList( "An Error Occurred when calling JM Add or Update Quote." ) )
                                           .respMessageList( Arrays.asList( GENERIC_FAILED_QUOTE_MESSSAGE ) ).build();
        }
        return addQuoteResult;
    }
}

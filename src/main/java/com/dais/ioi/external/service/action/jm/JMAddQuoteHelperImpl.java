package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
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
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.LocalDate;
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
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;



@Service
@Slf4j
public class JMAddQuoteHelperImpl
{
    public static final DateTimeFormatter EFFECTIVE_DATE_FORMAT = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    private static final String EXTERNAL_QUOTE_METADATA_KEY = "EXTERNAL_QUOTE";

    private final JMQuoteClient jmQuoteClient;

    private final ObjectMapper objectMapper;

    private final ExternalQuoteDataService externalQuoteDataService;

    private final JmQuoteOptionsService jmQuoteOptionsService;


    public JMAddQuoteHelperImpl( @Autowired final JMQuoteClient jmQuoteClient,
                                 @Autowired final ObjectMapper objectMapper,
                                 @Autowired final ExternalQuoteDataService externalQuoteDataService,
                                 @Autowired final JmQuoteOptionsService jmQuoteOptionsService )
    {
        this.jmQuoteClient = jmQuoteClient;
        this.objectMapper = objectMapper;
        this.externalQuoteDataService = externalQuoteDataService;
        this.jmQuoteOptionsService = jmQuoteOptionsService;
    }


    public TriggerResponseDto processAddQuote( FiredTriggerDto firedTriggerDto,
                                               JMAuthResult jmAuthResult,
                                               ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {

        final UUID requestId = null == firedTriggerDto.getTriggerRequestId() ? UUID.randomUUID() : firedTriggerDto.getTriggerRequestId();

        String externalQuoteId = (String) firedTriggerDto.getPayload().get( "externalQuoteId" );

        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );

        // Collect plugin fields for email
        HashMap<String, String> pluginFields = new HashMap<>();

        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto, pluginFields );

        final String effectiveDateAnswer = triggerSpec.getIntake().get( actionJMSQuoteSpecDto.getEffectiveDate() ).getAnswer();

        final LocalDate effectiveDate = OffsetDateTime.parse( effectiveDateAnswer ).toLocalDate();

        addQuoteRequest.setEffectiveDate( effectiveDate.format( EFFECTIVE_DATE_FORMAT ) );

        final LinkedHashMap<String, String> agentInfoMap = (LinkedHashMap<String, String>) firedTriggerDto.getPayload().get( "agent" );
        addUserInfo( addQuoteRequest, agentInfoMap );


        // If the external quote id is sent, its treated as exclusively for updating
        // TODO: This should be a completely separate call
        if ( externalQuoteId != null && !externalQuoteId.equalsIgnoreCase( "" ) )
        {
            URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getUpdateQuoteUrl() );

            addQuoteRequest.setQuoteId( externalQuoteId );

            String planName = getValue( () -> ( (Map) firedTriggerDto.getPayload().get( "selectedPaymentPlan" ) ).get( "name" ).toString(), "" );

            if ( firedTriggerDto.getPayload().containsKey( "selectedPaymentPlan" ) )
            {
                Integer numberOfInstallments = Integer.parseInt( getValue( () -> ( (Map) firedTriggerDto.getPayload().get( "selectedPaymentPlan" ) ).get( "numberOfInstallments" ).toString(), "" ) );

                addPaymentPlan( addQuoteRequest, planName, numberOfInstallments );
            }

            log.info( objectMapper.writeValueAsString( addQuoteRequest ) );

            AddQuoteResult updQuoteResult = jmQuoteClient.updateQuote( determinedBasePathUri,
                                                                       "Bearer " + jmAuthResult.getAccess_token(),
                                                                       actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                       addQuoteRequest );

            if ( getValue( () -> updQuoteResult.getErrorMessages().size(), 0 ) > 0 )
            {

                String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );

                //TODO DONT THROW EXCEPTION
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


        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getAddQuoteUrl() );

        log.info( objectMapper.writeValueAsString( addQuoteRequest ) );



        AddQuoteResult addQuoteResult = getAddQuoteResult( jmAuthResult, actionJMSQuoteSpecDto, addQuoteRequest, determinedBasePathUri );


        // This block will be hit if there is no coverage and the http response is 200
        if ( addQuoteResult.isCoverageAvailable == false )
        {

            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

            HashMap<String, Object> metaDatamap = new HashMap<>();

            metaDatamap.put( "isUnderwritingNeeded", addQuoteResult.isUnderwritingNeeded() );
            metaDatamap.put( "isCoverageAvailable", addQuoteResult.isCoverageAvailable() );
            metaDatamap.put( "errorMessages", addQuoteResult.getErrorMessages() );
            metaDatamap.put( "messageList", addQuoteResult.getRespMessageList() );


            log.info( "setting request Id to " + requestId );
            triggerResponseDto.setTriggerRequestId( requestId );

            QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, addQuoteResult, metaDatamap );
            triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
            return triggerResponseDto;
        }

        externalQuoteId = addQuoteResult.getQuoteId();

        if ( getValue( () -> addQuoteResult.getErrorMessages().size(), 0 ) > 0 )
        {
            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
            QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, addQuoteResult, Collections.emptyMap() );
            triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
            return triggerResponseDto;
        }

        addQuoteRequest.setQuoteId( externalQuoteId );

        determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getUpdateQuoteUrl() );

        AddQuoteResult updQuoteResult = getQuoteResult( jmAuthResult, actionJMSQuoteSpecDto, addQuoteRequest, determinedBasePathUri );

        if ( getValue( () -> updQuoteResult.getErrorMessages().size(), 0 ) > 0 )
        {
            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
            QuoteDto rejectedQuote = getRejectedQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, addQuoteResult, Collections.emptyMap() );
            triggerResponseDto.getMetadata().put( EXTERNAL_QUOTE_METADATA_KEY, rejectedQuote );
            return triggerResponseDto;
        }


        PubQuoteDetailsDto quoteDetailsForQuoteOption = getQuoteDetailsForQuoteOption( updQuoteResult, addQuoteRequest );
        PubQuoteDetailsDto quoteDetailsForIOI = getQuoteDetailsForIOI( updQuoteResult, addQuoteRequest );

        saveFieldsForPlugin( requestId, addQuoteResult, pluginFields );

        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

        HashMap<String, Object> metaDatamap = new HashMap<>();
        metaDatamap.put( "ratePlans", updQuoteResult.getPaymentPlans() );
        metaDatamap.put( "isUnderwritingNeeded", addQuoteResult.isUnderwritingNeeded() );
        metaDatamap.put( "isCoverageAvailable", addQuoteResult.isCoverageAvailable() );
        metaDatamap.put( "minimumPremium", addQuoteResult.getRatingInfo().getMinimumPremium() );
        metaDatamap.put( "minimumTaxesAndSurcharges", addQuoteResult.getRatingInfo().getMinimumTaxesAndSurcharges() );


        QuoteDto newQuote = getQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, quoteDetailsForIOI, metaDatamap );
        QuoteDto quoteOptions = getQuoteDto( firedTriggerDto, requestId, triggerSpec, effectiveDate, quoteDetailsForQuoteOption, metaDatamap );
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

        return triggerResponseDto;
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


    public void addPaymentPlan( final String externalQuoteId,
                                Map<String, String> agentInfoMap,
                                Map<String, ClientAnswerDto> intake,
                                Map<String, Object> selectedPaymentPlan,
                                JMAuthResult jmAuthResult,
                                ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {
        HashMap<String, String> pluginFields = new HashMap<>();
        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( intake, actionJMSQuoteSpecDto, pluginFields );
        final String effectiveDateAnswer = intake.get( actionJMSQuoteSpecDto.getEffectiveDate() ).getAnswer();
        final LocalDate effectiveDate = OffsetDateTime.parse( effectiveDateAnswer ).toLocalDate();
        addQuoteRequest.setEffectiveDate( effectiveDate.format( EFFECTIVE_DATE_FORMAT ) );
        addUserInfo( addQuoteRequest, agentInfoMap );

        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getUpdateQuoteUrl() );
        addQuoteRequest.setQuoteId( externalQuoteId );

        String planName = getValue( () -> ( (Map) selectedPaymentPlan ).get( "name" ).toString(), "" );

        Integer numberOfInstallments = Integer.parseInt( getValue( () -> ( (Map) selectedPaymentPlan ).get( "numberOfInstallments" ).toString(), "" ) );

        addPaymentPlan( addQuoteRequest, planName, numberOfInstallments );

        log.info( objectMapper.writeValueAsString( addQuoteRequest ) );

        AddQuoteResult updQuoteResult = jmQuoteClient.updateQuote( determinedBasePathUri,
                                                                   "Bearer " + jmAuthResult.getAccess_token(),
                                                                   actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                   addQuoteRequest );

        if ( getValue( () -> updQuoteResult.getErrorMessages().size(), 0 ) > 0 )
        {

            String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
            throw new Exception( errorMessage );
        }
    }


    private AddQuoteResult getQuoteResult( final JMAuthResult jmAuthResult,
                                           final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                           final AddQuoteRequest addQuoteRequest,
                                           final URI determinedBasePathUri )
    {
        try
        {
            return jmQuoteClient.updateQuote( determinedBasePathUri,
                                              "Bearer " + jmAuthResult.getAccess_token(),
                                              actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                              addQuoteRequest );
        }
        catch ( FeignException e )
        {
            log.error( e.getMessage() );
            List<Object> errorMessages = new ArrayList<>();
            errorMessages.add( "An Error Occured when calling JM UpdateQuote." );
            //TODO: Parse out error message to extract cause
            errorMessages.add( e.contentUTF8() );

            List<String> respMessages = new ArrayList<>();
            respMessages.add( "We are unable to provide a quote at this time." );
            return AddQuoteResult.builder().errorMessages( errorMessages ).respMessageList( respMessages ).build();
        }
    }


    private AddQuoteResult getAddQuoteResult( final JMAuthResult jmAuthResult,
                                              final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                              final AddQuoteRequest addQuoteRequest,
                                              final URI determinedBasePathUri )
    {
        try
        {
            AddQuoteResult addQuoteResult = jmQuoteClient.addQuote( determinedBasePathUri,
                                                                    "Bearer " + jmAuthResult.getAccess_token(),
                                                                    actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                    addQuoteRequest );
            return addQuoteResult;
        }
        catch ( FeignException e )
        {
            log.error( e.getMessage() );
            List<Object> errorMessages = new ArrayList<>();
            errorMessages.add( "An Error Occured when calling JM AddQuote." );
            //TODO: Parse out error message to extract cause
            errorMessages.add( e.contentUTF8() );

            List<String> respMessages = new ArrayList<>();
            respMessages.add( "We are unable to provide a quote at this time." );
            return AddQuoteResult.builder().errorMessages( errorMessages ).respMessageList( respMessages ).build();
        }
    }


    private QuoteDto getRejectedQuoteDto( final FiredTriggerDto firedTriggerDto,
                                          final UUID requestId,
                                          final QuoteRequestSpecDto triggerSpec,
                                          final LocalDate effectiveDate,
                                          final AddQuoteResult addQuoteResult,
                                          final Map<String, Object> metaDatamap )
    {
        final List<PubMessageDto> errorMessages = addQuoteResult.getErrorMessages().stream().map( message ->
                                                                                                        PubMessageDto.builder()
                                                                                                                     .type( ContentScopeType.ERROR )
                                                                                                                     .message( message.toString() )
                                                                                                                     .build()
        ).collect( Collectors.toList() );

        final List<PubMessageDto> responseMessages = addQuoteResult.getRespMessageList().stream().map( message -> PubMessageDto.builder()
                                                                                                                               .type( ContentScopeType.CONSUMER )
                                                                                                                               .message( message )
                                                                                                                               .build()
        ).collect( Collectors.toList() );

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



        primaryContact.setResidentialAddress( residentialAddress );

        addQuoteRequest.setPrimaryContact( primaryContact );

        processUnderWriting( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        List<ClientLoopIterationDto> jewerlyWearers = intake.get( "jewelryWearers" ).getIterations();

        processAddQuoteIteration( addQuoteRequest, intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), actionJMSQuoteSpecDto, jewerlyWearers, pluginFields );

        setCanadianParameters( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        return addQuoteRequest;
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

        AddQuoteRequest.UnderwritingQuestion additionalUnderwriting = new AddQuoteRequest.UnderwritingQuestion();
        additionalUnderwriting.setKey( "IsAdditionalUnderwritingNeeded" );
        additionalUnderwriting.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getAdditionalUnderwriting() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( additionalUnderwriting );


        AddQuoteRequest.UnderwritingQuestion alarmId = new AddQuoteRequest.UnderwritingQuestion();
        alarmId.setKey( "AlarmId" );

        String alarmText = getValue( () -> intake.get( actionJMSQuoteSpecDto.getAlarmId() ).getAnswer().toString(), "" );
       /* String alarmIdValue = "";
        if ( alarmText.equalsIgnoreCase( "Monitored Alarm System" )) {
            alarmIdValue = "1";
        }
        else if (alarmText.equalsIgnoreCase( "Local Alarm" )) {
            alarmIdValue = "2";

        }
        else {
            alarmIdValue = "No Alarm";

        }*/

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
                                           Map<String, String> pluginFields )
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
                  Integer.parseInt( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer(), "" ).toString() )
            );

            item.setItemDescription(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemDescription() ).getAnswer(), "" )
            );
          /*  item.setItemDamage(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemDamage() ).getAnswer(), "" ).toString()
            );
            item.setItemPossession(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemPossession() ).getAnswer(), "" ).toString()
            );*/
            // Remove after questions answered
            // item.setItemDamage( "no" );
            //   item.setItemPossession( "yes" );
            //
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

            primaryWearer.setGender(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemGender() ).getAnswer().toString(), "" )
            );

            AddQuoteRequest.DeductibleOption deductibleOption = new AddQuoteRequest.DeductibleOption();

            deductibleOption.setDeductible(
                  Double.parseDouble( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getDeductible() ).getAnswer(), "0" ) )
            );

            deductibleOption.setItemNumber(
                  itemNumber
            );

            deductibleOptions.add( deductibleOption );

            item.setPrimaryWearer( primaryWearer );
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

        primaryWearer.setGender(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getItemGender() ).getAnswer().toString(), "" )

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

        primaryWearer.setGender(
              getValue( () -> wearerDto.getAnswers().get( actionJMSQuoteSpecDto.getItemGender() ).getAnswer().toString(), "" )

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
                                                      final AddQuoteRequest addQuoteRequest )
    {
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
                    List<PubCoverageDto> coverages = getPubCoveragesForDeductibleOption( itemRateDetail, deductibleOption, jeweleryItem.getItemValue() );
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
                                                              final AddQuoteRequest addQuoteRequest )
    {
        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        quoteBuilder.premium( buildPremium( addQuoteResult ) );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        addQuoteResult.getRatingInfo().getItemRateDetails().forEach( itemRateDetail -> {

            addQuoteRequest.getJeweleryItems().forEach( jeweleryItem -> {

                PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

                pubCoveragesBuilder.type( jeweleryItem.getJeweleryType() );

                List<PubCoverageDto> coverages = getPubCoverages( itemRateDetail, jeweleryItem.getItemValue() );
                pubCoveragesBuilder.coverages( coverages );

                pubCoverages.add( pubCoveragesBuilder.build() );
            } );
        } );
        quoteBuilder.coverageTypes( pubCoverages );

        PubExternalDataDto.PubExternalDataDtoBuilder externalDataBuilder = PubExternalDataDto.builder();

        externalDataBuilder.externalQuoteId( addQuoteResult.getQuoteId() );

        quoteBuilder.externalData( externalDataBuilder.build() );

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
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


    private List<PubCoverageDto> getPubCoverages( AddQuoteResult.ItemRateDetail itemRateDetail,
                                                  final int itemValue )
    {
        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            PubCoverageDto pubCoverageDto = getPubCoverageDto( itemRateDetail.getItemNumber(), itemValue, rateOption );
            coverages.add( pubCoverageDto );
        }
        return coverages;
    }


    private List<PubCoverageDto> getPubCoveragesForDeductibleOption( AddQuoteResult.ItemRateDetail itemRateDetail,
                                                                     AddQuoteRequest.DeductibleOption deductibleOption,
                                                                     final int itemValue )
    {
        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            if ( Double.valueOf( rateOption.getDeductible() ).equals( deductibleOption.getDeductible() ) )
            {
                PubCoverageDto pubCoverageDto = getPubCoverageDto( deductibleOption.getItemNumber(), itemValue, rateOption );
                coverages.add( pubCoverageDto );
            }
        }
        return coverages;
    }


    private PubCoverageDto getPubCoverageDto( final int itemNumber,
                                              final int itemValue,
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

        PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemValueBuilder = PubCoverageDetailDto.builder();
        itemValueBuilder.amountType( AmountType.DOLLAR );
        itemValueBuilder.amount( String.valueOf( itemValue ) );
        details.put( "itemValue", Collections.singletonList( itemValueBuilder.build() ) );

        pubCoverageBuilder.details( details );
        PubCoverageDto pubCoverageDto = pubCoverageBuilder.build();
        return pubCoverageDto;
    }


    private void saveFieldsForPlugin( UUID requestId,
                                      AddQuoteResult addQuoteResult,
                                      HashMap<String, String> fieldsForPlugin )
    {

        ExternalQuoteDataDto externalQuoteDataDto = new ExternalQuoteDataDto();

        externalQuoteDataDto.setQuoteId( requestId );

        externalQuoteDataDto.setExternalQuoteId( addQuoteResult.getQuoteId() );

        externalQuoteDataDto.setQuoteData( fieldsForPlugin );

        externalQuoteDataService.saveOrUpdate( externalQuoteDataDto );
    }
}

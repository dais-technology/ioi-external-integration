package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.action.jm.JmIntegrationService;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.ioi.external.util.CompareJsonUtil;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalIntegrationServiceImpl
      implements ExternalIntegrationService
{
    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private JMQuoteServiceImpl jmQuoteService;

    @Autowired
    private JmIntegrationService jmIntegrationService;

    @Autowired
    private JmQuoteOptionsService jmQuoteOptionsService;

    @Autowired
    @Qualifier( "primaryObjectMapper" )
    private ObjectMapper objectMapper;

    private CompareJsonUtil compareJson = new CompareJsonUtil();


    @Override
    public IntegrationDto getById( final UUID integrationId )
    {
        try
        {
            IntegrationEntity integrationEntity = externalIntegrationRepository.getOne( integrationId );
            return objectMapper.convertValue( integrationEntity, IntegrationDto.class );
        }
        catch ( EntityNotFoundException e )
        {
            throw new ResponseStatusException( HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public IntegrationDto create( final IntegrationDto integrationDto )
    {
        IntegrationEntity integrationEntity = objectMapper.convertValue( integrationDto, IntegrationEntity.class );
        externalIntegrationRepository.save( integrationEntity );
        return objectMapper.convertValue( integrationEntity, IntegrationDto.class );
    }


    @Override
    public void deleteById( final UUID integrationId )
    {
        externalIntegrationRepository.deleteById( integrationId );
    }


    @Override
    public IntegrationDto createOrUpdate( final IntegrationDto integrationDto )
    {
        if ( !Objects.isNull( integrationDto.getId() ) )
        {
            final IntegrationEntity original = externalIntegrationRepository.findById( integrationDto.getId() ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
            final IntegrationEntity updated = objectMapper.convertValue( integrationDto, IntegrationEntity.class );
            updated.setId( original.getId() );
            externalIntegrationRepository.save( updated );
            return objectMapper.convertValue( updated, IntegrationDto.class );
        }
        else
        {
            return create( integrationDto );
        }
    }


    @Override
    public TriggerResponseDto process( final FiredTriggerDto firedTriggerDto )
          throws Exception
    {
        return jmQuoteService.fire( firedTriggerDto );
    }


    @Override
    public AddPaymentPlanResponseDto addPaymentPlan( final AddPaymentPlanRequestDto paymentPlan )
          throws Exception
    {
        return jmQuoteService.addPaymentPlan( paymentPlan );
    }



    @Override
    public QuoteDto getQuickQuote( final GetQuoteDto quoteDto )
          throws Exception
    {
        log.info( "Received JM QuickQuote {}", objectMapper.writeValueAsString( quoteDto ) );
        QuoteDto quickQuote = jmQuoteService.getQuickQuote( quoteDto );
        log.info( "JM QuickQuote Response {} ", objectMapper.writeValueAsString( quickQuote ) );
        return quickQuote;
    }


    @Override
    public QuoteDto getCachedQuickQuote( final GetQuoteDto quoteDto )
          throws Exception
    {
        try
        {
            log.info( String.format( "IMPORTANT: Fetching quote option for ClientId: %s LineId: %s ", quoteDto.getClientId().toString(), quoteDto.getLineId().toString() ) );
            JmQuoteOptionDto jmQuoteOption = jmQuoteOptionsService.getByClientIdLineId( quoteDto.getClientId(), quoteDto.getLineId() );
            log.info( "IMPORTANT: Existing quote Option exist for given intake key.  Performing cache hit checks..." );
            OffsetDateTime now = OffsetDateTime.now();
            OffsetDateTime cachedDate = jmQuoteOption.getSubmissionDate();

            log.info( String.format( "IMPORTANT: Performing submission date Check. Cached Submission Date: %s, new Submission Date: %s", cachedDate, now ) );
            long days = Duration.between( cachedDate, now ).toDays();
            log.info( "IMPORTANT: days between quoteOptions: " + days );
            if ( days >= 60 )
            {
                log.info( "IMPORTANT: Cached quote options have expired, fetching new quote options" );
                QuoteDto quickQuote = jmQuoteService.getQuickQuote( quoteDto );

                JmQuoteOptionDto quoteOption = JmQuoteOptionDto.builder()
                                                               .clientId( quoteDto.getClientId() )
                                                               .lineId( quoteDto.getLineId() )
                                                               .quoteOption( quickQuote )
                                                               .submissionDate( OffsetDateTime.now() )
                                                               .intakeKey( objectMapper.writeValueAsString( quoteDto.getIntake() ) )
                                                               .build();

                jmQuoteOptionsService.save( quoteOption );
                return quickQuote;
            }
            else
            {
                log.info( "IMPORTANT: Cached quote is within expiry period.  Continuing with intake key comparison." );
            }
            Boolean intakeEqual = compareJson.isEqual( jmQuoteOption.getIntakeKey(), objectMapper.writeValueAsString( quoteDto.getIntake() ) );
            if ( intakeEqual )
            {
                log.info( "IMPORTANT: intake key for Existing quote Option is unchanged.  Returning cached quote option: " + objectMapper.writeValueAsString( jmQuoteOption.getQuoteOption() ) );
                return jmQuoteOption.getQuoteOption();
            }
            else
            {
                log.info( "IMPORTANT: intake key for Existing quote Option has changed.  Fetching new quote option for getQuickQuote:" + objectMapper.writeValueAsString( quoteDto ) );
                QuoteDto quickQuote = jmQuoteService.getQuickQuote( quoteDto );

                log.info( "IMPORTANT: creating/updating quote option cache entry." );
                JmQuoteOptionDto quoteOption = JmQuoteOptionDto.builder()
                                                               .clientId( quoteDto.getClientId() )
                                                               .lineId( quoteDto.getLineId() )
                                                               .quoteOption( quickQuote )
                                                               .submissionDate( now )
                                                               .intakeKey( objectMapper.writeValueAsString( quoteDto.getIntake() ) )
                                                               .build();

                JmQuoteOptionDto saved = jmQuoteOptionsService.save( quoteOption );
                log.info( "IMPORTANT: New quoteOption is saved to db with id: " + saved.getId() );
                return quickQuote;
            }
        }
        catch ( ResponseStatusException ex )
        {
            log.info( String.format( "IMPORTANT: No quote option found for ClientId: %s LineId: %s ", quoteDto.getClientId().toString(), quoteDto.getLineId().toString() ) );
            log.info( "IMPORTANT: Fetching quote option for getQuickQuote:" + objectMapper.writeValueAsString( quoteDto ) );

            QuoteDto quickQuote = jmQuoteService.getQuickQuote( quoteDto );

            log.info( "IMPORTANT: creating quote option cache entry." );
            JmQuoteOptionDto quoteOption = JmQuoteOptionDto.builder()
                                                           .clientId( quoteDto.getClientId() )
                                                           .lineId( quoteDto.getLineId() )
                                                           .quoteOption( quickQuote )
                                                           .submissionDate( OffsetDateTime.now() )
                                                           .intakeKey( objectMapper.writeValueAsString( quoteDto.getIntake() ) )
                                                           .build();

            JmQuoteOptionDto saved = jmQuoteOptionsService.save( quoteOption );
            log.info( "IMPORTANT: New quoteOption is saved to db with id: " + saved.getId() );

            return quickQuote;
        }
        catch ( ExternalApiException e )
        {
            log.error( "IMPORTANT: An Exception occured when trying to reach the JM api" );
            throw e;
        }
    }


    // TODO Temporarily hardcoded and probably mis-located until we have time to re-architect and refactor
    @Override
    public TriggerResponseDto processSynchronous( final FiredTriggerDto firedTriggerDto )
          throws Exception
    {
        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
        final String externalIntegrationType = (String) firedTriggerDto.getPayload().getOrDefault( "externalIntegrationType", null );
        final IntegrationType integrationType = IntegrationType.valueOf( externalIntegrationType );

        if ( integrationType == IntegrationType.JM_CREATE_ACCOUNT )
        {
            final UUID jmQuoteId = UUID.fromString( (String) firedTriggerDto.getPayload().get( "jmQuoteId" ) );
            final CreateAccountRequest createAccountRequest = new CreateAccountRequest( jmQuoteId );
            final CreateAccountResponse createAccountResponse = jmIntegrationService.createAccount( createAccountRequest, firedTriggerDto.getLineId() );
            triggerResponseDto.setMetadata( new ObjectMapper().convertValue( createAccountResponse, Map.class ) );
        }
        else if ( integrationType == IntegrationType.JM_SUBMIT_APPLICATION )
        {
            final UUID jmQuoteId = UUID.fromString( (String) firedTriggerDto.getPayload().get( "jmQuoteId" ) );
            final BigDecimal totalAmount = BigDecimal.valueOf( (Double) firedTriggerDto.getPayload().get( "totalAmount" ) );
            final SubmitApplicationRequest submitApplicationRequest = new SubmitApplicationRequest( jmQuoteId, totalAmount );
            final SubmitApplicationResponse submitApplicationResponse = jmIntegrationService.submitApplication( submitApplicationRequest, firedTriggerDto.getLineId() );
            triggerResponseDto.setMetadata( new ObjectMapper().convertValue( submitApplicationResponse, Map.class ) );
        }

        return triggerResponseDto;
    }


    @SneakyThrows
    @Override
    public SubmitApplicationResponse submitApplication( final SubmitApplicationRequest submitApplicationRequest,
                                                        final UUID orgId )
    {
        log.info( String.format( "submitApplication: %s -> %s", orgId.toString(), new ObjectMapper().writeValueAsString( submitApplicationRequest ) ) );
        return jmIntegrationService.submitApplication( submitApplicationRequest, orgId );
    }


    @SneakyThrows
    @Override
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest,
                                                final UUID orgId )
    {
        log.info( String.format( "createAccount: %s -> %s", orgId.toString(), new ObjectMapper().writeValueAsString( createAccountRequest ) ) );
        return jmIntegrationService.createAccount( createAccountRequest, orgId );
    }


    @SneakyThrows
    @Override
    public ResponseEntity<Resource> downloadApplication( final DownloadApplicationRequest downloadApplicationRequest,
                                                         final UUID lineId )
    {
        log.info( String.format( "downloadApplication: %s -> %s", lineId.toString(), new ObjectMapper().writeValueAsString( downloadApplicationRequest ) ) );
        return jmIntegrationService.downloadApplication( downloadApplicationRequest, lineId );
    }


    @SneakyThrows
    @Override
    public GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                    final UUID lineId )
    {
        log.info( String.format( "getPolicyNumber: %s -> %s", lineId.toString(), accountNumber ) );
        return jmIntegrationService.getPolicyNumber( accountNumber, lineId );
    }


    @SneakyThrows
    @Override
    public UploadAppraisalResponse uploadAppraisal( final String accountNumber,
                                                    final String policyNumber,
                                                    final MultipartFile appraisalDocument,
                                                    final UUID lineId )
    {
        log.info( String.format( "uploadAppraisal: %s -> accountNumber: %s, policyNumber: %s", lineId.toString(), accountNumber, policyNumber) );
        return jmIntegrationService.uploadAppraisal( accountNumber, policyNumber, appraisalDocument, lineId );
    }
}

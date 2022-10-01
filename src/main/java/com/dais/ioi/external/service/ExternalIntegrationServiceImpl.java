package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMCreateAccountServiceImpl;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.action.jm.JMSubmitApplicationServiceImpl;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
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
    private JMQuoteServiceImpl jmsQuoteService;

    @Autowired
    private JMSubmitApplicationServiceImpl jmSubmitApplication;

    @Autowired
    private JMCreateAccountServiceImpl createAccountService;

    @Autowired
    @Qualifier( "primaryObjectMapper" )
    private ObjectMapper objectMapper;


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
        return jmsQuoteService.fire( firedTriggerDto );
    }


    @Override
    public QuoteDto getQuickQuote( final GetQuoteDto firedTriggerDto )
          throws Exception
    {
        return jmsQuoteService.getQuickQuote( firedTriggerDto );
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
            final CreateAccountResponse createAccountResponse = createAccountService.createAccount( createAccountRequest, firedTriggerDto.getLineId() );
            triggerResponseDto.setMetadata( new ObjectMapper().convertValue( createAccountResponse, Map.class ) );
        }
        else if ( integrationType == IntegrationType.JM_SUBMIT_APPLICATION )
        {
            final UUID jmQuoteId = UUID.fromString( (String) firedTriggerDto.getPayload().get( "jmQuoteId" ) );
            final BigDecimal totalAmount = BigDecimal.valueOf( (Double) firedTriggerDto.getPayload().get( "totalAmount" ) );
            final SubmitApplicationRequest submitApplicationRequest = new SubmitApplicationRequest( jmQuoteId, totalAmount );
            final SubmitApplicationResponse submitApplicationResponse = jmSubmitApplication.submit( submitApplicationRequest, firedTriggerDto.getLineId() );
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
        return jmSubmitApplication.submit( submitApplicationRequest, orgId );
    }


    @SneakyThrows
    @Override
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest,
                                                final UUID orgId )
    {
        log.info( String.format( "createAccount: %s -> %s", orgId.toString(), new ObjectMapper().writeValueAsString( createAccountRequest ) ) );
        return createAccountService.createAccount( createAccountRequest, orgId );
    }
}

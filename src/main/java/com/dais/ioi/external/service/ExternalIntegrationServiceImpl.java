package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMCreateAccountServiceImpl;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.hubspot.HubSpotService;
import com.dais.ioi.external.service.action.jm.JMSubmitApplicationServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalIntegrationServiceImpl
      implements ExternalIntegrationService
{
    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Qualifier( "mapperFacade" )
    private final MapperFacade mapperFacade;


    @Autowired
    private JMQuoteServiceImpl jmsQuoteService;

    @Autowired
    private HubSpotService hubSpotService;

    @Autowired
    private JMSubmitApplicationServiceImpl jmSubmitApplication;

    @Autowired
    private JMCreateAccountServiceImpl createAccountService;

    @Override
    public IntegrationDto create( final IntegrationDto integrationDto )
    {
        IntegrationEntity integrationEntity = mapperFacade.map( integrationDto, IntegrationEntity.class );
        externalIntegrationRepository.save( integrationEntity );
        return mapperFacade.map( integrationEntity, IntegrationDto.class );
    }


    @Override
    public TriggerResponseDto process( final FiredTriggerDto firedTriggerDto )
          throws Exception
    {
        return jmsQuoteService.fire( firedTriggerDto );
    }


    // TODO Temporarily hardcoded and probably mis-located until we have time to re-architect and refactor
    @Override
    public TriggerResponseDto processSynchronous( final FiredTriggerDto firedTriggerDto )
          throws Exception
    {
        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
        final String externalIntegrationType = (String) firedTriggerDto.getPayload().getOrDefault( "externalIntegrationType", null );
        final IntegrationType integrationType = IntegrationType.valueOf( externalIntegrationType );

        if (integrationType == IntegrationType.JM_CREATE_ACCOUNT)
        {
            final UUID jmQuoteId = UUID.fromString( (String) firedTriggerDto.getPayload().get( "jmQuoteId" ) );
            final CreateAccountRequest createAccountRequest = new CreateAccountRequest( jmQuoteId );
            final CreateAccountResponse createAccountResponse = createAccountService.createAccount( createAccountRequest, firedTriggerDto.getLineId() );
            triggerResponseDto.setMetadata( new ObjectMapper().convertValue( createAccountResponse, Map.class ) );
        }
        else if (integrationType == IntegrationType.JM_SUBMIT_APPLICATION)
        {
            final UUID jmQuoteId = UUID.fromString( (String) firedTriggerDto.getPayload().get( "jmQuoteId" ) );
            final BigDecimal totalAmount = BigDecimal.valueOf((Double) firedTriggerDto.getPayload().get( "totalAmount" ));
            final SubmitApplicationRequest submitApplicationRequest = new SubmitApplicationRequest( jmQuoteId, totalAmount );
            final SubmitApplicationResponse submitApplicationResponse = jmSubmitApplication.submit( submitApplicationRequest, firedTriggerDto.getLineId() );
            triggerResponseDto.setMetadata( new ObjectMapper().convertValue( submitApplicationResponse, Map.class ) );
        }

        return triggerResponseDto;
    }


    @Override
    public void hubspotTrack( final HubspotTrackRequest request )
    {
        hubSpotService.trackEvent( request );
    }


    @Override
    public SubmitApplicationResponse submitApplication(final SubmitApplicationRequest submitApplicationRequest, final UUID orgId ) {
        return jmSubmitApplication.submit( submitApplicationRequest, orgId );
    }

    @Override
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest, final UUID orgId ) {
        return createAccountService.createAccount(createAccountRequest, orgId );
    }
}

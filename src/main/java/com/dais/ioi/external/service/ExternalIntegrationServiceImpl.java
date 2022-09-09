package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMCreateAccountServiceImpl;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.hubspot.HubSpotService;
import com.dais.ioi.external.service.action.jm.JMSubmitApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


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


    @Override
    public void hubspotTrack( final HubspotTrackRequest request )
    {
        hubSpotService.trackEvent( request );
    }

    @Override
    public TriggerResponseDto submitApplication(FiredTriggerDto firedTriggerDto) {
        return jmSubmitApplication.submit(firedTriggerDto);
    }

    @Override
    public CreateAccountResponse createAccount(FiredTriggerDto firedTriggerDto) {
        return createAccountService.createAccount(firedTriggerDto);
    }
}

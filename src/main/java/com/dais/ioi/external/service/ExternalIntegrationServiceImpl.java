package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMCreateAccountServiceImpl;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.action.jm.JMSubmitApplicationServiceImpl;
import com.dais.ioi.external.service.hubspot.HubSpotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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
    public IntegrationDto createOrUpdate( final IntegrationDto integrationDto )
    {
        if ( !Objects.isNull( integrationDto.getId() ) )
        {
            final IntegrationEntity entity = externalIntegrationRepository.findById( integrationDto.getId() ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
            mapperFacade.map( integrationDto, entity );
            externalIntegrationRepository.save( entity );
            return mapperFacade.map( entity, IntegrationDto.class );
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
    public void hubspotTrack( final HubspotTrackRequest request )
    {
        hubSpotService.trackEvent( request );
    }


    @Override
    public SubmitApplicationResponse submitApplication( final SubmitApplicationRequest submitApplicationRequest,
                                                        final UUID orgId )
    {
        return jmSubmitApplication.submit( submitApplicationRequest, orgId );
    }


    @Override
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest,
                                                final UUID orgId )
    {
        return createAccountService.createAccount( createAccountRequest, orgId );
    }
}

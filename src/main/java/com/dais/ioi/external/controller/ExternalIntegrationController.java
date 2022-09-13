package com.dais.ioi.external.controller;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.api.ExternalIntegrationApi;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.service.ExternalIntegrationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping( "/external" )
@AllArgsConstructor
public class ExternalIntegrationController
      implements ExternalIntegrationApi
{
    private final ExternalIntegrationService externalIntegrationService;

    private final ObjectMapper objectMapper;


    public IntegrationDto save( final IntegrationDto integrationDto )
    {
        return externalIntegrationService.create( integrationDto );
    }


    @Override
    public void trackEvent( final HubspotTrackRequest request )
    {
        externalIntegrationService.hubspotTrack( request );
    }


    @Override
    public TriggerResponseDto fire( @Valid final FiredTriggerDto firedTriggerDto )
    {
        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
        try
        {
            log.info( "Received {}", objectMapper.writeValueAsString( firedTriggerDto ) );

            triggerResponseDto = externalIntegrationService.process( firedTriggerDto );

            log.info( "Responded with {} ", objectMapper.writeValueAsString( triggerResponseDto ) );
        }

        catch ( FeignException e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, new String(e.content()) );
        }

        catch ( Exception e )
        {
            e.printStackTrace();
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }

        return triggerResponseDto;
    }


    @Override
    public TriggerResponseDto fireSynchronous( @Valid final FiredTriggerDto firedTriggerDto )
    {
        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

        try
        {
            log.info( "Received {}", objectMapper.writeValueAsString( firedTriggerDto ) ); // TODO should be removed or set to not log in prod

            triggerResponseDto = externalIntegrationService.processSynchronous( firedTriggerDto );

            log.info( "Responded with {} ", objectMapper.writeValueAsString( triggerResponseDto ) ); // TODO should be removed or set to not log in prod
        }

        catch ( final FeignException e) {
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, new String(e.content()) );
        }

        catch ( final Exception e )
        {
            e.printStackTrace();
            throw new ResponseStatusException( HttpStatus.BAD_REQUEST, e.getMessage() );
        }

        return triggerResponseDto;
    }

    @Override
    public SubmitApplicationResponse submit(final SubmitApplicationRequest submitApplicationRequest, final UUID orgId )
    {
        return externalIntegrationService.submitApplication( submitApplicationRequest, orgId );
    }

    @Override
    public CreateAccountResponse create( final CreateAccountRequest createAccountRequest, final UUID orgId)  throws IllegalAccessException
    {
        return externalIntegrationService.createAccount( createAccountRequest, orgId );
    }
}

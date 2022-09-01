package com.dais.ioi.external.controller;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.api.ExternalIntegrationApi;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.service.ExternalIntegrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping( "/external" )
@AllArgsConstructor
public class ExternalIntegrationController
      implements ExternalIntegrationApi
{
    private final ExternalIntegrationService externalIntegrationService;


    public IntegrationDto save( final IntegrationDto integrationDto )
    {
        return externalIntegrationService.create( integrationDto );
    }


   public TriggerResponseDto fire( @Valid final FiredTriggerDto firedTriggerDto )
    {
       return externalIntegrationService.process( firedTriggerDto );

    }

    //TODO: figure out the submit and create input output
    @Override
    public TriggerResponseDto submit(FiredTriggerDto firedTriggerDto)
    {
        return externalIntegrationService.submitApplication(firedTriggerDto);
    }

    @Override
    public TriggerResponseDto create(FiredTriggerDto firedTriggerDto) throws IllegalAccessException
    {
        return externalIntegrationService.createAccount(firedTriggerDto);
    }
}

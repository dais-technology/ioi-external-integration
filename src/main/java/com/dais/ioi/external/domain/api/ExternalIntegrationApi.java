package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;


public interface ExternalIntegrationApi
{

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/process",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Process external data request" )
    TriggerResponseDto fire( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/submit/application",
            method = RequestMethod.POST )
    @ApiOperation( value = "Submit application" )
    TriggerResponseDto submit( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
            throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/create/account",
            method = RequestMethod.POST )
    @ApiOperation( value = "create account" )
    TriggerResponseDto create( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
            throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create an Integration Record" )
    IntegrationDto save( @RequestBody @Valid final IntegrationDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/hubspot",
                     method = RequestMethod.POST )
    @ApiOperation( value = "make a track call to hubspot" )
    void trackEvent( @RequestBody @Valid final
                     HubspotTrackRequest request );
}

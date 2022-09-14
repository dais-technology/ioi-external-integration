package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.UUID;


public interface ExternalIntegrationApi
{

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/process",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Process external data request" )
    TriggerResponseDto fire( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/process-synchronous",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Process external data request" )
    TriggerResponseDto fireSynchronous( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/submit/application/{orgId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Submit application" )
    SubmitApplicationResponse submit( @RequestBody @Valid final SubmitApplicationRequest submitApplicationRequest,
                                      @PathVariable final UUID orgId )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/create/account/{orgId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create account" )
    CreateAccountResponse create( @RequestBody @Valid final CreateAccountRequest createAccountRequest,
                                  @PathVariable final UUID orgId )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create an Integration Record" )
    IntegrationDto save( @RequestBody @Valid final IntegrationDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.PUT )
    @ApiOperation( value = "create an Integration Record" )
    IntegrationDto saveOrUpdate( @RequestBody @Valid final IntegrationDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/hubspot",
                     method = RequestMethod.POST )
    @ApiOperation( value = "make a track call to hubspot" )
    void trackEvent( @RequestBody @Valid final
                     HubspotTrackRequest request );
}

package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
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
    @RequestMapping( value = "/process-synchronous",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Process external data request" )
    TriggerResponseDto fireSynchronous( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{integrationId}",
                     method = RequestMethod.GET )
    @ApiOperation( value = "Get Integration Record by Id" )
    IntegrationDto getById( @PathVariable final UUID integrationId );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create an Integration Record" )
    IntegrationDto save( @RequestBody @Valid final IntegrationDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.PUT )
    @ApiOperation( value = "create or update an Integration Record" )
    IntegrationDto saveOrUpdate( @RequestBody @Valid final IntegrationDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{integrationId}",
                     method = RequestMethod.DELETE )
    @ApiOperation( value = "Delete Integration Record by Id" )
    void deleteById( @PathVariable final UUID integrationId );
}

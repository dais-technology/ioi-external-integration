package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.ExternalInputDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;


public interface ExternalIntegrationAPi
{

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/process",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Process external data request" )
    TriggerResponseDto fire( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;
}

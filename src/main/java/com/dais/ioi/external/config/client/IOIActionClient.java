package com.dais.ioi.external.config.client;

import com.dais.ioi.action.domain.dto.internal.InboundResponseDataDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;


@Deprecated
@FeignClient( "ioi-action-service" )
public interface IOIActionClient
{
    @ResponseStatus( HttpStatus.NO_CONTENT )
    @RequestMapping( value = "/pub/v1/inbound",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Inbound API" )
    void processInboundData( final @Valid InboundResponseDataDto inboundPublicData );
}

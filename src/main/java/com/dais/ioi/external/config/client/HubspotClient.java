package com.dais.ioi.external.config.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.Map;


@FeignClient( "track-hubspot" )
public interface HubspotClient
{
    @ResponseStatus( HttpStatus.NO_CONTENT )
    @RequestMapping( value = "/v1/event",
                     method = RequestMethod.GET )
    @ApiOperation( value = "Hubspot Track Event" )
    void trackEvent( final @Valid @SpringQueryMap Map<String, String> queryParameters );
}

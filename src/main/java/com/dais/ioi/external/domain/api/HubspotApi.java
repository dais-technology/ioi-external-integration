package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


public interface HubspotApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/hubspot",
                     method = RequestMethod.POST )
    @ApiOperation( value = "make a track call to hubspot" )
    void trackEvent( HubspotTrackRequest request );
}

package com.dais.ioi.external.config.client;

import com.dais.ioi.external.config.HttpHeader;
import com.dais.ioi.log.domain.dto.LogDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@FeignClient(
      name = "ioi-log-service",
      contextId = "logServiceClient"
)
public interface ActivityLogClient
{
    @RequestMapping( value = "/log",
                     method = RequestMethod.POST )
    @ResponseStatus( HttpStatus.NO_CONTENT )
    void storeLog( @RequestHeader( HttpHeader.JWT_ASSERTION ) String jwtToken,
                   @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                   @RequestBody LogDto logDto );

}

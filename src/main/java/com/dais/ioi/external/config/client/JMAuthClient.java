package com.dais.ioi.external.config.client;

import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;


@FeignClient(
      name = "jm-auth",
      url = "jm-auth-url"
)
public interface JMAuthClient
{

    @RequestMapping(
                     method = RequestMethod.POST,
                     headers = { "Content-Type=application/x-www-form-urlencoded" } )
    @ResponseStatus( HttpStatus.OK )
    JMAuthResult getToken( URI baseUrl,
                           @RequestBody final String params );
}

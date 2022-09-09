package com.dais.ioi.external.config.client;

import com.dais.ioi.external.config.HttpHeader;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.URI;

@FeignClient(
        name = "jm-application",
        url = "jm-api-url"
)
@Service
public interface JMApplicationClient
{
    @RequestMapping(
//            value = "/submit/application",
            method = RequestMethod.POST,
            headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    SubmitApplicationResponse submitApplication(URI baseUrl,
                                                @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                                @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
                                                @RequestBody final SubmitApplicationRequest submitApplicationRequest );

    @RequestMapping(
//            value = "/create/account",
            method = RequestMethod.POST,
            headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    CreateAccountResponse createAccount(URI baseUrl,
                                        @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                        @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
                                        @RequestBody final CreateAccountRequest createAccountRequest );
}

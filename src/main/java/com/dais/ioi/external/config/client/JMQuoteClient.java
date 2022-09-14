package com.dais.ioi.external.config.client;


import com.dais.ioi.external.config.HttpHeader;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteResult;
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
      name = "jm-quote",
      url = "jm-api-url"
)
@Service
public interface JMQuoteClient
{
    @RequestMapping(
                     method = RequestMethod.POST,
                     headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    QuickQuoteResult getQuickQuote( URI baseUrl,
                                    @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                    @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
                                    @RequestBody final QuickQuoteRequest quickQuoteRequest );

    @RequestMapping(
                     method = RequestMethod.POST,
                     headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    AddQuoteResult addQuote(URI baseUrl,
          @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
          @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
          @RequestBody final AddQuoteRequest quickQuoteRequest );

    @RequestMapping(
          method = RequestMethod.POST,
          headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    AddQuoteResult updateQuote(URI baseUrl,
                            @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                            @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
                            @RequestBody final AddQuoteRequest updateQuoteRequest );

}
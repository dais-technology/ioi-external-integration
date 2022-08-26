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


@FeignClient(
      name = "jm-quote",
      url = "${jm.api.url}"
)
@Service
public interface JMQuoteClient
{
  /*  @RequestMapping( value = "${jm.api.quickquote.uri}",
                     method = RequestMethod.POST,
                     headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    QuickQuoteResult getQuickQuote(
          @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
          @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
          @RequestBody final QuickQuoteRequest quickQuoteRequest );

    @RequestMapping( value = "${jm.api.addquote.uri}",
                     method = RequestMethod.POST,
                     headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    AddQuoteResult addQuote(
          @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
          @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscripionKey,
          @RequestBody final AddQuoteRequest quickQuoteRequest );*/
}
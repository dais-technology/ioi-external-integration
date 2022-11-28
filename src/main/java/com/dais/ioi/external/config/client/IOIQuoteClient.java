package com.dais.ioi.external.config.client;

import com.dais.ioi.quote.domain.dto.QuoteDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@FeignClient( "ioi-quote-service" )
public interface IOIQuoteClient
{
    //NOTE: This can be deleted when client_id migration is applied to all env
    @RequestMapping( value = "/pub/v1/quotes",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Inbound API" )
    List<QuoteDto> getQuotesByRequestIds( @RequestBody @Valid List<UUID> requestIds);
}

package com.dais.ioi.external.config.client;

import com.dais.ioi.quote.domain.dto.ProductQuoteDto;
import com.dais.ioi.quote.domain.dto.QuoteSearchDto;
import com.dais.ioi.quote.domain.dto.TriggerQuotesDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@FeignClient("ioi-quote-service")
public interface IOIQuoteClient {

    @RequestMapping(value = "/pub/v1/quotes/triggerRequestId/{triggerRequestId}",
        method = RequestMethod.GET)
    @ApiOperation(value = "Get quotes")
    TriggerQuotesDto getQuotes(@PathVariable final UUID triggerRequestId,
                               @RequestParam(name = "includeRawData",
                                   defaultValue = "false") boolean includeRawData);

    @RequestMapping( value = "/client/{clientId}",
        method = RequestMethod.POST )
    @ApiOperation( value = "Get client quotes. It returns quotes for multiple lines, if request line is bundle. " )
    List<ProductQuoteDto> getProductQuotes(@PathVariable final UUID clientId,
                                           @RequestBody @Valid QuoteSearchDto quoteSearchDto );
}

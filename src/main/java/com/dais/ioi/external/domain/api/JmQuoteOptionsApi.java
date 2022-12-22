package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.UUID;


public interface JmQuoteOptionsApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create JmQuoteOption Record" )
    JmQuoteOptionDto save( @RequestBody @Valid final JmQuoteOptionDto quoteOption );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{id}",
                     method = RequestMethod.GET )
    JmQuoteOptionDto getById( @PathVariable @Valid final UUID id );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/client/{clientId}/line/{lineId}",
                     method = RequestMethod.GET )
    JmQuoteOptionDto getByClientIdLineId( @PathVariable final UUID clientId,
                                          @PathVariable final UUID lineId );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{id}",
                     method = RequestMethod.DELETE )
    @ApiOperation( value = "Remove JmQuoteOption Record by Id" )
    void deleteById( @PathVariable @Valid final UUID id );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/client/{clientId}/line/{lineId}",
                     method = RequestMethod.DELETE )
    void deleteByClientIdLineId( @PathVariable final UUID clientId,
                                 @PathVariable final UUID lineId );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/latest/{clientId}",
                     method = RequestMethod.GET )
    QuoteDto getMostRecentQuoteOptions( @PathVariable final UUID clientId );

}

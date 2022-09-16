package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.UUID;


public interface ExternalQuoteDataControllerApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create an ExternalQuoteData Record" )
    ExternalQuoteDataDto save( @RequestBody @Valid final ExternalQuoteDataDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save",
                     method = RequestMethod.PUT )
    @ApiOperation( value = "create or update an ExternalQuoteData Record" )
    ExternalQuoteDataDto saveOrUpdate( @RequestBody @Valid final ExternalQuoteDataDto integrationDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{externalQuoteDataId}",
                     method = RequestMethod.DELETE )
    @ApiOperation( value = "create or update an ExternalQuoteData Record" )
    void delete( @PathVariable final UUID externalQuoteDataId );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/{externalQuoteDataId}",
                     method = RequestMethod.GET )
    @ApiOperation( value = "create or update an ExternalQuoteData Record" )
    ExternalQuoteDataDto findByExternalQuoteId( @PathVariable final String externalQuoteDataId );
}

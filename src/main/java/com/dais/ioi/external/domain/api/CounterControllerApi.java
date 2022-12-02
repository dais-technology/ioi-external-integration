package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.count.CountDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.Map;


public interface CounterControllerApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( method = RequestMethod.POST )
    @ApiOperation( value = "Increment/Decrement a counter" )
    void count( @RequestBody @Valid final CountDto count );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/aggregate",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Increment/Decrement a counter" )
    void aggregate();

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( method = RequestMethod.GET )
    @ApiOperation( value = "Increment/Decrement a counter" )
    int getCount( @RequestBody @Valid final Map<String, ?> key );
}

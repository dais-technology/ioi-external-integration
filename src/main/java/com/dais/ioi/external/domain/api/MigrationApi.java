package com.dais.ioi.external.domain.api;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;


public interface MigrationApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/populateClientId",
                     method = RequestMethod.POST )
    @ApiOperation( value = "PopulateClientId" )
    void populateClientId();
}

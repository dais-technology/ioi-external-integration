package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckInput;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckResponse;
import com.dais.ioi.external.domain.dto.transunion.TransUnionCreditVisionAuth;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;


public interface TransunionApi
{
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/check",
                     method = RequestMethod.POST )
    @ApiOperation( value = "check credit score" )
    CreditCheckResponse check( @RequestBody @Valid final CreditCheckInput input )
          throws Exception;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/save/auth",
                     method = RequestMethod.POST )
    @ApiOperation( value = "save transunion auth" )
    void saveAuth( final TransUnionCreditVisionAuth creditVisionAuth,
                   @RequestParam( "p12certFile" ) final MultipartFile p12certFile )
          throws IOException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/get/auth/{type}",
                     method = RequestMethod.GET )
    @ApiOperation( value = "get transunion auth" )
    TransUnionCreditVisionAuth getAuth( @PathVariable final IntegrationType type );
}

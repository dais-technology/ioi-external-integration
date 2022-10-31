package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.UUID;


public interface JmIntegrationApi
{

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/process",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Get JM Quote" )
    TriggerResponseDto getQuote( @RequestBody @Valid final FiredTriggerDto firedTriggerDto )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/quote/jm/quickquote",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Get JM quickQuote" )
    QuoteDto getQuickQuote( @RequestBody @Valid GetQuoteDto firedTriggerDto );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/quote/jm/paymentplan",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Get JM quickQuote" )
    AddPaymentPlanResponseDto addPaymentPlan( @RequestBody @Valid final AddPaymentPlanRequestDto addPaymentPlanRequest );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/submit/application/{lineId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Submit application" )
    SubmitApplicationResponse submit( @RequestBody @Valid final SubmitApplicationRequest submitApplicationRequest,
                                      @PathVariable final UUID lineId )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/create/account/{lineId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create account" )
    CreateAccountResponse create( @RequestBody @Valid final CreateAccountRequest createAccountRequest,
                                  @PathVariable final UUID lineId )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/download/application/{lineId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Download Application PDF" )
    ResponseEntity<Resource> downloadApplication( @RequestBody @Valid final DownloadApplicationRequest downloadApplicationRequest,
                                                  @PathVariable final UUID lineId );
    
    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/register/user/{lineId}",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Register Portal User" )
    RegisterUserResponse registerPortalUser( @RequestBody @Valid final RegisterUserRequest registerUserRequest,
                                             @PathVariable final UUID lineId );
}

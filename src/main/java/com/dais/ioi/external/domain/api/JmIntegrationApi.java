package com.dais.ioi.external.domain.api;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetEmbeddedQuoteResponse;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.GetQuoteDto;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalRequestDto;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;
import java.util.List;
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
    QuoteDto getQuickQuote( @RequestBody @Valid GetQuoteDto firedTriggerDto )
          throws Exception;


    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/quote/jm/paymentplan",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Get JM quickQuote" )
    AddPaymentPlanResponseDto addPaymentPlan( @RequestBody @Valid final AddPaymentPlanRequestDto addPaymentPlanRequest )
          throws Exception;


    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/submit/application",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Submit application" )
    SubmitApplicationResponse submit( @RequestBody @Valid final SubmitApplicationRequest submitApplicationRequest )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/create/account",
                     method = RequestMethod.POST )
    @ApiOperation( value = "create account" )
    CreateAccountResponse create( @RequestBody @Valid final CreateAccountRequest createAccountRequest )
          throws IllegalAccessException;

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/download/application",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Download Application PDF" )
    ResponseEntity<Resource> downloadApplication( @RequestBody @Valid final DownloadApplicationRequest downloadApplicationRequest );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/getpolicynumber",
                     method = RequestMethod.GET )
    @ApiOperation( value = "Get Policy Number" )
    GetPolicyNumberResponse getPolicyNumber( @RequestParam( value = "accountNumber" ) final String accountNumber,
                                             @RequestParam( value = "jmSource" ) final JmSource jmSource );


    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/upload/appraisal",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Upload Appraisal Doc" )
    List<UploadAppraisalResponse> uploadAppraisal( @RequestBody @Valid final UploadAppraisalRequestDto request );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/register/user",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Register Portal User" )
    RegisterUserResponse registerPortalUser( @RequestBody @Valid final RegisterUserRequest registerUserRequest );

    @ResponseStatus( HttpStatus.OK )
    @RequestMapping( value = "/embeddedquote",
                     method = RequestMethod.GET )
    @ApiOperation( value = "Get Embedded quote" )
    GetEmbeddedQuoteResponse getEmbeddedQuote( @RequestParam( value = "quoteId" ) final UUID quoteId,
                                               @RequestParam( value = "jmSource" ) final JmSource jmSource );
}

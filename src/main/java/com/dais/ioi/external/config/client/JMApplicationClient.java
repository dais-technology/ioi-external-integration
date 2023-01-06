package com.dais.ioi.external.config.client;

import com.dais.ioi.external.config.HttpHeader;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetEmbeddedQuoteResponse;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.net.URI;
import java.util.UUID;


@FeignClient(
      name = "jm-application",
      url = "jm-api-url"
)
public interface JMApplicationClient
{
    @RequestMapping(
          value = "/application/submit",
          method = RequestMethod.POST,
          headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    SubmitApplicationResponse submitApplication( URI baseUrl,
                                                 @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                                 @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                                 @RequestBody final SubmitApplicationRequest submitApplicationRequest );

    @RequestMapping(
          value = "/account/create",
          method = RequestMethod.POST,
          headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    CreateAccountResponse createAccount( URI baseUrl,
                                         @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                         @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                         @RequestBody final CreateAccountRequest createAccountRequest );

    @RequestMapping(
          value = "/application/application-page",
          method = RequestMethod.POST,
          headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    ByteArrayResource downloadApplication( URI baseUrl,
                                           @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                           @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                           @RequestBody final DownloadApplicationRequest downloadApplicationRequest );


    @RequestMapping(
          value = "/account/getpolicynumber/{accountNumber}",
          method = RequestMethod.GET )
    @ResponseStatus( HttpStatus.OK )
    GetPolicyNumberResponse getPolicyNumber( URI baseUrl,
                                             @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                             @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                             @PathVariable( value = "accountNumber" ) String accountNumber );

    @RequestMapping(
          value = "/account/uploadAppraisal/{accountNumber}",
          method = RequestMethod.POST,
          consumes = MediaType.MULTIPART_FORM_DATA_VALUE )
    @ResponseStatus( HttpStatus.OK )
    UploadAppraisalResponse uploadAppraisal( URI baseUrl,
                                             @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                             @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                             @PathVariable( value = "accountNumber" ) String accountNumber,
                                             @Param( "file" ) MultipartFile file );

    @RequestMapping(
          value = "/account/RegisterPortalUser",
          method = RequestMethod.POST,
          headers = { "Content-Type=application/json" } )
    @ResponseStatus( HttpStatus.OK )
    RegisterUserResponse registerPortalUser( URI baseUrl,
                                             @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                             @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                             @RequestBody @Valid final RegisterUserRequest registerUserRequest );


    @RequestMapping(
          value = "/quote/{quoteId}",
          method = RequestMethod.GET )
    @ResponseStatus( HttpStatus.OK )
    GetEmbeddedQuoteResponse getEmbeddedQuote( URI baseUrl,
                                               @RequestHeader( HttpHeader.AUTHORIZATION ) String bearer,
                                               @RequestHeader( "Ocp-Apim-Subscription-Key" ) String subscriptionKey,
                                               @PathVariable( value = "quoteId" ) UUID quoteId );
}

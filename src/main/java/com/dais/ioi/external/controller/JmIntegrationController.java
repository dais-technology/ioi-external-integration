package com.dais.ioi.external.controller;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.api.JmIntegrationApi;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalRequestDto;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.service.ExternalIntegrationService;
import com.dais.ioi.external.service.action.jm.JmIntegrationServiceImpl;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping( "/external" )
@AllArgsConstructor
public class JmIntegrationController
      implements JmIntegrationApi
{
    private final ExternalIntegrationService externalIntegrationService;

    private final JmIntegrationServiceImpl jmIntegrationService;

    private final ObjectMapper objectMapper;


    @Override
    public TriggerResponseDto getQuote( @Valid final FiredTriggerDto firedTriggerDto )
    {
        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();
        try
        {
            log.info( "Received {}", objectMapper.writeValueAsString( firedTriggerDto ) );

            triggerResponseDto = externalIntegrationService.process( firedTriggerDto );

            log.info( "Responded with {} ", objectMapper.writeValueAsString( triggerResponseDto ) );
        }

        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, new String( e.content() ) );
        }

        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }

        return triggerResponseDto;
    }


    @Override
    public QuoteDto getQuickQuote( @Valid final GetQuoteDto getQuoteDto )
    {
        try
        {

            QuoteDto quoteDto = externalIntegrationService.getCachedQuickQuote( getQuoteDto );
            return quoteDto;
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public AddPaymentPlanResponseDto addPaymentPlan( @Valid final AddPaymentPlanRequestDto addPaymentPlanRequest )
    {
        try
        {
            return externalIntegrationService.addPaymentPlan( addPaymentPlanRequest );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public CreateAccountResponse create( final CreateAccountRequest createAccountRequest,
                                         final UUID lineId )
          throws IllegalAccessException
    {
        try
        {
            return externalIntegrationService.createAccount( createAccountRequest, lineId );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public SubmitApplicationResponse submit( final SubmitApplicationRequest submitApplicationRequest,
                                             final UUID lineId )
    {
        try
        {
            return externalIntegrationService.submitApplication( submitApplicationRequest, lineId );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public ResponseEntity<Resource> downloadApplication( final DownloadApplicationRequest downloadApplicationRequest,
                                                         final UUID lineId )
    {
        try
        {
            return externalIntegrationService.downloadApplication( downloadApplicationRequest, lineId );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                    final UUID lineId )
    {
        try
        {
            return externalIntegrationService.getPolicyNumber( accountNumber, lineId );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }


    @Override
    public List<UploadAppraisalResponse> uploadAppraisal( final UploadAppraisalRequestDto request )
    {
        return jmIntegrationService.uploadAppraisal( request );
    }


    @Override
    public RegisterUserResponse registerPortalUser( final RegisterUserRequest registerUserRequest,
                                                    final UUID lineId )
    {
        try
        {
            return externalIntegrationService.registerPortalUser( registerUserRequest, lineId );
        }
        catch ( FeignException e )
        {
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.contentUTF8() );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage(), e );
            throw new ResponseStatusException( HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage() );
        }
    }
}

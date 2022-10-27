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
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.service.ExternalIntegrationService;
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
import java.util.UUID;


@Slf4j
@RestController
@RequestMapping( "/external" )
@AllArgsConstructor
public class JmIntegrationController
      implements JmIntegrationApi
{
    private final ExternalIntegrationService externalIntegrationService;

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
                                         final UUID orgId )
          throws IllegalAccessException
    {
        try
        {
            return externalIntegrationService.createAccount( createAccountRequest, orgId );
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
                                             final UUID orgId )
    {
        try
        {
            return externalIntegrationService.submitApplication( submitApplicationRequest, orgId );
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
                                                         final UUID orgId )
    {
        try
        {
            return externalIntegrationService.downloadApplication( downloadApplicationRequest, orgId );
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

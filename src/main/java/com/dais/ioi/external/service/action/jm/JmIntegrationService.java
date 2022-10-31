package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;


@Service
@Slf4j
@RequiredArgsConstructor
public class JmIntegrationService
{
    @Autowired
    JMAuthClient jmAuthClient;

    @Autowired
    JMApplicationClient jmApplicationClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private ExternalQuoteDataService externalQuoteDataService;


    @SneakyThrows
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest,
                                                final UUID orgId )
    {

        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM crateAccount" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( orgId, IntegrationType.JM_CREATE_ACCOUNT );
        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );
        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final URI uri = URI.create( actionJMSQuoteSpecDto.getCreateAccountUrl() );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount request: " + objectMapper.writeValueAsString( createAccountRequest ) );
        CreateAccountResponse createAccountResponse = getCreateAccountResponse( createAccountRequest, actionJMSQuoteSpecDto, jmAuthResult, uri );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount response: " + objectMapper.writeValueAsString( createAccountResponse ) );
        log.info( "(" + trace + ") IMPORTANT: End JM crateAccount" );
        return createAccountResponse;
    }



    @SneakyThrows
    public SubmitApplicationResponse submitApplication( final SubmitApplicationRequest submitApplicationRequest,
                                                        final UUID orgId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM SubmitApplication" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( orgId, IntegrationType.JM_SUBMIT_APPLICATION ); // TODO check should tis be lineId or orgId

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );
        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );
        final URI uri = URI.create( actionJMSQuoteSpecDto.getSubmitApplicationUrl() );

        log.info( "(" + trace + ") IMPORTANT: JM crateAccount URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount request: " + objectMapper.writeValueAsString( submitApplicationRequest ) );

        final SubmitApplicationResponse response = getSubmitApplicationResponse( submitApplicationRequest, actionJMSQuoteSpecDto, jmAuthResult, uri );
        log.info( "(" + trace + ") IMPORTANT: JM submitApplication response: " + objectMapper.writeValueAsString( response ) );
        persistExternalQuoteData( response, submitApplicationRequest.getQuoteId() );
        log.info( "(" + trace + ") IMPORTANT: End JM submitApplication" );

        return response;
    }



    public ResponseEntity<Resource> downloadApplication( DownloadApplicationRequest downloadApplicationRequest,
                                                         UUID orgId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM DowloadApplication" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( orgId, IntegrationType.JM_DOWNLOAD_APPLICATION );

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final URI uri = URI.create( actionJMSQuoteSpecDto.getDownloadApplicationUrl() );

        final ByteArrayResource byteArrayResource = downloadApplication( downloadApplicationRequest, actionJMSQuoteSpecDto, jmAuthResult, uri );

        ResponseEntity<Resource> response = ResponseEntity.ok()
                                                          .contentLength( byteArrayResource.contentLength() )
                                                          .contentType( MediaType.APPLICATION_OCTET_STREAM )
                                                          .body( byteArrayResource );
        log.info( "(" + trace + ") IMPORTANT: JM DowloadApplication call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM DowloadApplication" );
        return response;
    }


    private ByteArrayResource downloadApplication( final DownloadApplicationRequest downloadApplicationRequest,
                                                   final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                   final JMAuthResult jmAuthResult,
                                                   final URI uri )
    {
        try
        {
            final ByteArrayResource byteArrayResource = jmApplicationClient.downloadApplication( uri,
                                                                                                 "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                 actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                                 downloadApplicationRequest );
            return byteArrayResource;
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a downloadApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    public RegisterUserResponse registerPortalUser( RegisterUserRequest registerUserRequest,
                                                    UUID lineId )
          throws JsonProcessingException
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM RegisterPortalUser" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_REGISTER_PORTAL_USER );

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final URI uri = URI.create( actionJMSQuoteSpecDto.getRegisterPortalUserUrl() );

        log.info( "(" + trace + ") IMPORTANT: Sending JM RegisterPortalUser request -> {}", objectMapper.writeValueAsString( registerUserRequest ) );
        final RegisterUserResponse registerPortalUserResponse = processRegisterPortalUser( registerUserRequest, actionJMSQuoteSpecDto, jmAuthResult, uri );

        log.info( "(" + trace + ") IMPORTANT: JM RegisterPortalUser call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM RegisterPortalUser" );
        return registerPortalUserResponse;
    }


    private RegisterUserResponse processRegisterPortalUser( final RegisterUserRequest registerUserRequest,
                                                            final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                            final JMAuthResult jmAuthResult,
                                                            final URI uri )
    {
        try
        {
            final RegisterUserResponse registerPortalUserResponse = jmApplicationClient.registerPortalUser( uri,
                                                                                                            "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                            actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                                            registerUserRequest );
            return registerPortalUserResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a registerPortalUser response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a registerPortalUser response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    @SneakyThrows
    private void persistExternalQuoteData( final SubmitApplicationResponse response,
                                           final UUID externalQuoteId )
    {
        ExternalQuoteDataDto externalQuoteData = new ExternalQuoteDataDto();

        Map<String, String> quoteData = new HashMap<String, String>();


        try
        {
            externalQuoteData = externalQuoteDataService.getByExternalQuoteId( externalQuoteId.toString() );
            quoteData = (Map<String, String>) externalQuoteData.getQuoteData();
        }
        catch ( org.springframework.web.server.ResponseStatusException e )
        {
            externalQuoteData.setExternalQuoteId( externalQuoteId.toString() );
            externalQuoteData.setQuoteData( quoteData );
            log.info( "IMPORTANT: Could not get the external quote data for " + externalQuoteId + " created a new record" );
        }


        quoteData.put( "accountNumber", response.getAccountNumber() );
        quoteData.put( "policyNumber", response.getPolicyNumber() );

        log.info( "IMPORTATN: Persisting external quote data: " + objectMapper.writeValueAsString( externalQuoteData ) );
        externalQuoteDataService.saveOrUpdate( externalQuoteData );
    }


    private CreateAccountResponse getCreateAccountResponse( final CreateAccountRequest createAccountRequest,
                                                            final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                            final JMAuthResult jmAuthResult,
                                                            final URI uri )
    {
        try
        {
            CreateAccountResponse createAccountResponse = jmApplicationClient.createAccount( uri,
                                                                                             "Bearer " + jmAuthResult.getAccess_token(),
                                                                                             actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                             createAccountRequest );
            return createAccountResponse;
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a createAccount response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    private SubmitApplicationResponse getSubmitApplicationResponse( final SubmitApplicationRequest submitApplicationRequest,
                                                                    final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                                                    final JMAuthResult jmAuthResult,
                                                                    final URI uri )
    {
        try
        {
            final SubmitApplicationResponse response = jmApplicationClient.submitApplication( uri,
                                                                                              "Bearer " + jmAuthResult.getAccess_token(),
                                                                                              actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                              submitApplicationRequest );
            return response;
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a submitApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }
}

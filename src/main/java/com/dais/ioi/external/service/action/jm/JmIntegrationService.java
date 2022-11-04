package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.domain.dto.spec.JmApiSpec;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
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
import org.springframework.web.multipart.MultipartFile;

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
        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );
        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount request: " + objectMapper.writeValueAsString( createAccountRequest ) );
        CreateAccountResponse createAccountResponse = getCreateAccountResponse( createAccountRequest, jmApiSpec, jmAuthResult, uri );
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

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );
        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );
        final URI uri = URI.create( jmApiSpec.getBaseUrl() );

        log.info( "(" + trace + ") IMPORTANT: JM crateAccount URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM crateAccount request: " + objectMapper.writeValueAsString( submitApplicationRequest ) );

        final SubmitApplicationResponse response = getSubmitApplicationResponse( submitApplicationRequest, jmApiSpec, jmAuthResult, uri );
        log.info( "(" + trace + ") IMPORTANT: JM submitApplication response: " + objectMapper.writeValueAsString( response ) );
        persistExternalQuoteData( response, submitApplicationRequest.getQuoteId() );
        log.info( "(" + trace + ") IMPORTANT: End JM submitApplication" );

        return response;
    }


    @SneakyThrows
    public ResponseEntity<Resource> downloadApplication( DownloadApplicationRequest downloadApplicationRequest,
                                                         UUID lineId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM DownloadApplication" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_DOWNLOAD_APPLICATION );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: Base URI: {}", uri );
        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication REQUEST: {}.", objectMapper.writeValueAsString( downloadApplicationRequest ) );

        final ByteArrayResource byteArrayResource = downloadApplication( downloadApplicationRequest, jmApiSpec, jmAuthResult, uri );

        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication RESPONSE file name: {}.", byteArrayResource.getFilename() );
        ResponseEntity<Resource> response = ResponseEntity.ok()
                                                          .contentLength( byteArrayResource.contentLength() )
                                                          .contentType( MediaType.APPLICATION_OCTET_STREAM )
                                                          .body( byteArrayResource );
        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM DownloadApplication" );
        return response;
    }


    @SneakyThrows
    public GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                    final UUID lineId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM GetPolicyNumber" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_GET_POLICY_NUMBER );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: Base URI: {}, accountNumber: {}", uri, accountNumber );

        final GetPolicyNumberResponse getPolicyNumberResponse = getPolicyNumber( accountNumber, jmApiSpec, jmAuthResult, uri );

        log.info( "(" + trace + ") IMPORTANT: JM GetPolicyNumber RESPONSE: {}.", objectMapper.writeValueAsString( getPolicyNumberResponse ) );
        log.info( "(" + trace + ") IMPORTANT: JM GetPolicyNumber call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM GetPolicyNumber" );
        return getPolicyNumberResponse;
    }


    @SneakyThrows
    public UploadAppraisalResponse uploadAppraisal( final String accountNumber,
                                                    final String policyNumber,
                                                    final MultipartFile appraisalDocument,
                                                    final UUID lineId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM UploadAppraisal" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_UPLOAD_APPRAISAL );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: Base URI: {}, accountNumber: {}, policyNumber: {}", uri, accountNumber, policyNumber );

        final UploadAppraisalResponse uploadAppraisalResponse = uploadAppraisal( accountNumber, policyNumber, appraisalDocument, jmApiSpec, jmAuthResult, uri );

        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal RESPONSE: {}.", objectMapper.writeValueAsString( uploadAppraisalResponse ) );
        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM UploadAppraisal" );
        return uploadAppraisalResponse;
    }


    private ByteArrayResource downloadApplication( final DownloadApplicationRequest downloadApplicationRequest,
                                                   final JmApiSpec jmApiSpec,
                                                   final JMAuthResult jmAuthResult,
                                                   final URI uri )
    {
        try
        {
            final ByteArrayResource byteArrayResource = jmApplicationClient.downloadApplication( uri,
                                                                                                 "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                 jmApiSpec.getApiSubscriptionkey(),
                                                                                                 downloadApplicationRequest );
            return byteArrayResource;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a downloadApplication response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a downloadApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    private GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                     final JmApiSpec jmApiSpec,
                                                     final JMAuthResult jmAuthResult,
                                                     final URI uri )
    {
        try
        {
            final GetPolicyNumberResponse getPolicyNumberResponse = jmApplicationClient.getPolicyNumber( uri,
                                                                                                         "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                         jmApiSpec.getApiSubscriptionkey(),
                                                                                                         accountNumber );
            return getPolicyNumberResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a policy number response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a policy number response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    private UploadAppraisalResponse uploadAppraisal( final String accountNumber,
                                                     final String policyNumber,
                                                     final MultipartFile appraisalDocument,
                                                     final JmApiSpec jmApiSpec,
                                                     final JMAuthResult jmAuthResult,
                                                     final URI uri )
    {
        try
        {
            final UploadAppraisalResponse uploadAppraisalResponse = jmApplicationClient.uploadAppraisal( uri,
                                                                                                         "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                         jmApiSpec.getApiSubscriptionkey(),
                                                                                                         accountNumber,
                                                                                                         policyNumber,
                                                                                                         appraisalDocument );
            return uploadAppraisalResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UploadAppraisal response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UploadAppraisal response from JM: " + e.getMessage(), e );
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
                                                            final JmApiSpec jmApiSpec,
                                                            final JMAuthResult jmAuthResult,
                                                            final URI uri )
    {
        try
        {
            CreateAccountResponse createAccountResponse = jmApplicationClient.createAccount( uri,
                                                                                             "Bearer " + jmAuthResult.getAccess_token(),
                                                                                             jmApiSpec.getApiSubscriptionkey(),
                                                                                             createAccountRequest );
            return createAccountResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a createAccount response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a createAccount response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }


    private SubmitApplicationResponse getSubmitApplicationResponse( final SubmitApplicationRequest submitApplicationRequest,
                                                                    final JmApiSpec jmApiSpec,
                                                                    final JMAuthResult jmAuthResult,
                                                                    final URI uri )
    {
        try
        {
            final SubmitApplicationResponse response = jmApplicationClient.submitApplication( uri,
                                                                                              "Bearer " + jmAuthResult.getAccess_token(),
                                                                                              jmApiSpec.getApiSubscriptionkey(),
                                                                                              submitApplicationRequest );
            return response;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a submitApplication response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a submitApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + uri + " Message: " + e.getMessage(), e );
        }
    }
}

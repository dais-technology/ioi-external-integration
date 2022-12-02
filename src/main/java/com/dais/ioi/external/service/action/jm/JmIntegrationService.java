package com.dais.ioi.external.service.action.jm;

import com.dais.authorization.ForwardingAuthorization;
import com.dais.file.storage.FileReference;
import com.dais.file.storage.cms.CmsFiles;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.client.domain.dto.client.ClientDto;
import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.domain.dto.spec.JmApiSpec;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;
import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;


@Service
@Slf4j
@RequiredArgsConstructor
public class JmIntegrationService
{
    private static Pattern PASSWORD_VALIDATION_REGEX = Pattern.compile( "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" );

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

    @Autowired
    private CmsFiles cmsFiles;


    @SneakyThrows
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest,
                                                final UUID lineId )
    {

        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM createAccount" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_CREATE_ACCOUNT );
        log.info( "(" + trace + ") IMPORTANT: integrationEntity fetched" );
        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );
        log.info( "(" + trace + ") IMPORTANT: JmApiSpec parsed from Integration" );
        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );
        log.info( "(" + trace + ") IMPORTANT: Jm Api authentication complete" );
        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: JM createAccount URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM createAccount request: " + objectMapper.writeValueAsString( createAccountRequest ) );
        CreateAccountResponse createAccountResponse = getCreateAccountResponse( createAccountRequest, jmApiSpec, jmAuthResult, uri );
        log.info( "(" + trace + ") IMPORTANT: JM createAccount response: " + objectMapper.writeValueAsString( createAccountResponse ) );
        log.info( "(" + trace + ") IMPORTANT: End JM createAccount" );
        return createAccountResponse;
    }



    @SneakyThrows
    public SubmitApplicationResponse submitApplication( final SubmitApplicationRequest submitApplicationRequest,
                                                        final UUID lineId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM SubmitApplication" );
        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_SUBMIT_APPLICATION );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );
        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );
        final URI uri = URI.create( jmApiSpec.getBaseUrl() );

        log.info( "(" + trace + ") IMPORTANT: JM submitApplication URI: " + uri );
        log.info( "(" + trace + ") IMPORTANT: JM submitApplication request: " + objectMapper.writeValueAsString( submitApplicationRequest ) );

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
    public List<UploadAppraisalResponse> uploadAppraisal( final String accountNumber,
                                                          final FiredTriggerDto firedTriggerDto,
                                                          final UUID lineId )
    {
        UUID trace = UUID.randomUUID();

        log.info( "(" + trace + ") IMPORTANT: Begin JM UploadAppraisal" );

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_UPLOAD_APPRAISAL );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: Base URI: {}, accountNumber: {}", uri, accountNumber );

        final ForwardingAuthorization cmsAuthorization = new ForwardingAuthorization();

        final ClientDto clientDto = objectMapper.convertValue( firedTriggerDto.getPayload(), ClientDto.class );

        //List<LinkedHashMap<String, String>> files = clientDto.getClientIntake().getClientAnswers().get( "fileQuestion1" ).getFiles();
        List<LinkedHashMap<String, String>> filesInfo = objectMapper.readValue( clientDto.getClientIntake().getClientAnswers().get( "fileQuestion1" ).getAnswer(), new TypeReference<List<LinkedHashMap<String, String>>>() {} );

        final List<UploadAppraisalResponse> responses = new ArrayList<>();

        for ( LinkedHashMap<String, String> fileInfo : filesInfo )
        {
            final String contentId = getValue( () -> fileInfo.get( jmApiSpec.getContentId() ), "" );
            final String fileType = getValue( () -> fileInfo.get( jmApiSpec.getFileType() ), "" );
            final String fileName = getValue( () -> fileInfo.get( jmApiSpec.getFileName() ), "" );
            final Integer fileSizeKb = Integer.valueOf( getValue( () -> fileInfo.get( jmApiSpec.getFileSizeKb() ), "0" ) );

            Optional<FileReference> fileReference = cmsFiles.findById( UUID.fromString( contentId ), cmsAuthorization );

            if ( fileReference.isPresent() )
            {
                log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal: file with contentId {} is found on s3.", objectMapper.writeValueAsString( responses ) );
                final FileItem fileItem = new DiskFileItem( "mainFile", fileType, false, fileName, fileSizeKb, null );

                IOUtils.copy( fileReference.get().get(), fileItem.getOutputStream() );
                MultipartFile multipartFile = new CommonsMultipartFile( fileItem );

                final UploadAppraisalResponse uploadAppraisalResponse = uploadAppraisal( accountNumber, multipartFile, jmApiSpec, jmAuthResult, uri );

                responses.add( uploadAppraisalResponse );
            }
            else
            {
                log.error( "(" + trace + ") IMPORTANT: File with contentId: {} and fileName: {} is NOT FOUND on s3!", contentId, fileName );
            }
        }

        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal RESPONSE: {}.", objectMapper.writeValueAsString( responses ) );
        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM UploadAppraisal" );

        return responses;
    }


    @SneakyThrows
    public RegisterUserResponse registerPortalUser( RegisterUserRequest registerUserRequest,
                                                    UUID lineId )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM RegisterPortalUser" );

        //validate password
        if ( !PASSWORD_VALIDATION_REGEX.matcher( registerUserRequest.getApplicant().getPortalPassword() ).matches() )
        {
            log.info( "(" + trace + ") IMPORTANT: Password validation Failed." );
            throw new RuntimeException( "Password validation Failed. Your password must be at least 8 characters long and must contain at least one of each of the following:\n" +
                                        "• lower case letter\n" +
                                        "• UPPER case letter\n" +
                                        "• Number (1, 2, 3, etc.) or special character (#, $, ?, etc.)" );
        }

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_REGISTER_PORTAL_USER );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmApiSpec.class );

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );

        log.info( "(" + trace + ") IMPORTANT: Sending JM RegisterPortalUser request -> Base URI: {}, body: {}", uri, objectMapper.writeValueAsString( registerUserRequest ) );
        final RegisterUserResponse registerPortalUserResponse = processRegisterPortalUser( registerUserRequest, jmApiSpec, jmAuthResult, uri );

        log.info( "(" + trace + ") IMPORTANT: JM RegisterPortalUser call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM RegisterPortalUser" );
        return registerPortalUserResponse;
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


    private RegisterUserResponse processRegisterPortalUser( final RegisterUserRequest registerUserRequest,
                                                            final JmApiSpec jmApiSpec,
                                                            final JMAuthResult jmAuthResult,
                                                            final URI uri )
    {
        try
        {
            final RegisterUserResponse registerPortalUserResponse = jmApplicationClient.registerPortalUser( uri,
                                                                                                            "Bearer " + jmAuthResult.getAccess_token(),
                                                                                                            jmApiSpec.getApiSubscriptionkey(),
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

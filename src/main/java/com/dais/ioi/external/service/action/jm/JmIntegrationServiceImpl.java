package com.dais.ioi.external.service.action.jm;

import com.dais.authorization.ForwardingAuthorization;
import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.FileReferenceDto;
import com.dais.file.storage.FileReference;
import com.dais.file.storage.cms.CmsFiles;
import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.GetPolicyNumberResponse;
import com.dais.ioi.external.domain.dto.jm.JMAuthData;
import com.dais.ioi.external.domain.dto.jm.RegisterUserRequest;
import com.dais.ioi.external.domain.dto.jm.RegisterUserResponse;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalRequestDto;
import com.dais.ioi.external.domain.dto.jm.UploadAppraisalResponse;
import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import com.dais.ioi.external.domain.dto.spec.JmUploadAppraisalSpec;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.ioi.external.util.JsonPathPropertiesMapperUtil;
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
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class JmIntegrationServiceImpl
{
    private static Pattern PASSWORD_VALIDATION_REGEX = Pattern.compile( "^(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$" );

    private static final String ACCOUNT_NUMBER = "accountNumber";

    @Autowired
    JMApplicationClient jmApplicationClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private ExternalQuoteDataService externalQuoteDataService;

    @Autowired
    private JmQuoteOptionsService jmQuoteOptionsService;

    @Autowired
    private CmsFiles cmsFiles;

    @Autowired
    private JMAuthService jmAuthService;

    private JsonPathPropertiesMapperUtil jsonPathMapper = new JsonPathPropertiesMapperUtil();


    @SneakyThrows
    public CreateAccountResponse createAccount( final CreateAccountRequest createAccountRequest )
    {

        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM createAccount" );
        log.info( "(" + trace + ") IMPORTANT: JmApiSpec parsed from Integration" );
        final JMAuthData jmAuthData = jmAuthService.getAuthData( createAccountRequest.getJmSource() );
        log.info( "(" + trace + ") IMPORTANT: Jm Api authentication complete" );
        log.info( "(" + trace + ") IMPORTANT: JM createAccount request: " + objectMapper.writeValueAsString( createAccountRequest ) );
        CreateAccountResponse createAccountResponse = getCreateAccountResponse( createAccountRequest, jmAuthData );
        log.info( "(" + trace + ") IMPORTANT: JM createAccount response: " + objectMapper.writeValueAsString( createAccountResponse ) );
        log.info( "(" + trace + ") IMPORTANT: End JM createAccount" );
        return createAccountResponse;
    }



    @SneakyThrows
    public SubmitApplicationResponse submitApplication( final SubmitApplicationRequest submitApplicationRequest )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM SubmitApplication" );
        final JMAuthData jmAuthData = jmAuthService.getAuthData( submitApplicationRequest.getJmSource() );
        log.info( "(" + trace + ") IMPORTANT: JM submitApplication request: " + objectMapper.writeValueAsString( submitApplicationRequest ) );

        final SubmitApplicationResponse response = getSubmitApplicationResponse( submitApplicationRequest, jmAuthData );
        log.info( "(" + trace + ") IMPORTANT: JM submitApplication response: " + objectMapper.writeValueAsString( response ) );
        persistExternalQuoteData( response, submitApplicationRequest.getQuoteId() );
        log.info( "(" + trace + ") IMPORTANT: End JM submitApplication" );

        return response;
    }


    @SneakyThrows
    public ResponseEntity<Resource> downloadApplication( DownloadApplicationRequest downloadApplicationRequest )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM DownloadApplication" );

        final JMAuthData jmAuthData = jmAuthService.getAuthData( downloadApplicationRequest.getJmSource() );

        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication REQUEST: {}.", objectMapper.writeValueAsString( downloadApplicationRequest ) );

        final ResponseEntity<Resource> response = downloadApplication( downloadApplicationRequest, jmAuthData );

        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication RESPONSE file name: {}.", response.getBody().getFilename() );
        log.info( "(" + trace + ") IMPORTANT: JM DownloadApplication call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM DownloadApplication" );

        return response;
    }


    @SneakyThrows
    public GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                    final JmSource jmSource )
    {
        UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") IMPORTANT: Begin JM GetPolicyNumber" );

        final JMAuthData jmAuthData = jmAuthService.getAuthData( jmSource );

        final GetPolicyNumberResponse getPolicyNumberResponse = getPolicyNumber( accountNumber, jmAuthData );

        log.info( "(" + trace + ") IMPORTANT: JM GetPolicyNumber RESPONSE: {}.", objectMapper.writeValueAsString( getPolicyNumberResponse ) );
        log.info( "(" + trace + ") IMPORTANT: JM GetPolicyNumber call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM GetPolicyNumber" );
        return getPolicyNumberResponse;
    }


    @SneakyThrows
    public List<UploadAppraisalResponse> uploadAppraisal( final UploadAppraisalRequestDto requestDto )
    {
        UUID trace = UUID.randomUUID();

        log.info( "(" + trace + ") IMPORTANT: Begin JM UploadAppraisal for ClientId: " + requestDto.getClientId() );

        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal request body: " + objectMapper.writeValueAsString( requestDto ) );

        final JmUploadAppraisalSpec jmUploadAppraisalSpec = getJmUploadAppraisalSpec();

        final String accountNumber = requestDto.getAccountNumber();

        final JMAuthData jmAuthData = jmAuthService.getAuthData( requestDto.getJmSource() );

        final ForwardingAuthorization cmsAuthorization = new ForwardingAuthorization();

        final List<FileReferenceDto> fileReferences = getFileReferences( requestDto.getIntake(), jmUploadAppraisalSpec );

        final List<UploadAppraisalResponse> responses = new ArrayList<>();

        for ( final FileReferenceDto fileReference : fileReferences )
        {
            Optional<FileReference> cmsFileReference = cmsFiles.findById( fileReference.getContentId(), cmsAuthorization );

            if ( cmsFileReference.isPresent() )
            {
                log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal: file with contentId {} is found on s3.", fileReference.getContentId() );

                final FileItem fileItem = new DiskFileItem( "mainFile", fileReference.getFileType(), false,
                                                            fileReference.getFileName(), fileReference.getFileSizeKb().intValue(), null );

                IOUtils.copy( cmsFileReference.get().get(), fileItem.getOutputStream() );

                final MultipartFile multipartFile = new CommonsMultipartFile( fileItem );

                final UploadAppraisalResponse uploadAppraisalResponse = uploadAppraisal( accountNumber, multipartFile, jmAuthData );

                responses.add( uploadAppraisalResponse );
            }
            else
            {
                throw new RuntimeException( String.format( "(" + trace + ") IMPORTANT: File with contentId: %s and fileName: %s is NOT FOUND on s3!",
                                                           fileReference.getContentId().toString(), fileReference.getFileName() ) );
            }
        }

        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal RESPONSE: {}.", objectMapper.writeValueAsString( responses ) );
        log.info( "(" + trace + ") IMPORTANT: JM UploadAppraisal call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM UploadAppraisal" );

        return responses;
    }


    private List<FileReferenceDto> getFileReferences( final Map<String, ClientAnswerDto> intake,
                                                      final JmUploadAppraisalSpec jmUploadAppraisalSpec )
          throws IOException
    {
        final String intakeString = objectMapper.writeValueAsString( intake );
        final Map intakeMap = objectMapper.readValue( intakeString, Map.class );
        final Optional<Object> fileAnswers = jsonPathMapper.queryJson( intakeMap, jmUploadAppraisalSpec.getFileQuestion() );
        if ( fileAnswers.isPresent() )
        {
            if ( fileAnswers.get() instanceof Collection )
            {
                List<Map> answers = new ArrayList();
                final Collection answerLists = (Collection) fileAnswers.get();
                answerLists.forEach( answerIteration -> {
                    answers.addAll( (Collection) answerIteration );
                } );
                return answers.stream().map( fileRefMap -> {
                                  FileReferenceDto fileReferenceDto = objectMapper.convertValue( fileRefMap, FileReferenceDto.class );
                                  return fileReferenceDto;
                              } )
                              .collect( Collectors.toList() );
            }
        }
        return Collections.EMPTY_LIST;
    }


    private JmUploadAppraisalSpec getJmUploadAppraisalSpec()
    {
        List<IntegrationEntity> integrationEntities = externalIntegrationRepository.getIntegrationEntityByType( IntegrationType.JM_UPLOAD_APPRAISAL );
        if ( integrationEntities.size() > 1 )
        {
            throw new InvalidParameterException( "Important: More than one JM_UPLOAD_APPRAISAL found.  Only one expected." );
        }
        IntegrationEntity integrationEntity = integrationEntities.get( 0 );
        return objectMapper.convertValue( integrationEntity.getSpec(), JmUploadAppraisalSpec.class );
    }


    @SneakyThrows
    public RegisterUserResponse registerPortalUser( final RegisterUserRequest registerUserRequest )
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

        final JMAuthData jmAuthData = jmAuthService.getAuthData( registerUserRequest.getJmSource() );

        log.info( "(" + trace + ") IMPORTANT: Sending JM RegisterPortalUser request -> body: {}", objectMapper.writeValueAsString( registerUserRequest ) );
        final RegisterUserResponse registerPortalUserResponse = processRegisterPortalUser( registerUserRequest, jmAuthData );

        log.info( "(" + trace + ") IMPORTANT: JM RegisterPortalUser call Successful." );
        log.info( "(" + trace + ") IMPORTANT: End JM RegisterPortalUser" );
        return registerPortalUserResponse;
    }


    private ResponseEntity<Resource> downloadApplication( final DownloadApplicationRequest downloadApplicationRequest,
                                                          final JMAuthData jmAuthData )
    {
        try
        {
            final ByteArrayResource byteArrayResource = jmApplicationClient.downloadApplication( jmAuthData.getBaseUri(),
                                                                                                 "Bearer " + jmAuthData.getAccessToken(),
                                                                                                 jmAuthData.getApiSubscriptionKey(),
                                                                                                 downloadApplicationRequest );
            return ResponseEntity.ok()
                                 .contentLength( byteArrayResource.contentLength() )
                                 .contentType( MediaType.APPLICATION_OCTET_STREAM )
                                 .body( byteArrayResource );
        }
        catch ( FeignException e )
        {
            if ( e.status() == 404 && e.contentUTF8().contains( "Unable to find any document for the given account number" ) )
            {
                log.info( "IMPORTANT: JM returned 404 with message: {} , so we are returning 204 to the FE", e.contentUTF8() );
                return ResponseEntity.status( HttpStatus.NO_CONTENT ).body( new ByteArrayResource( e.content() ) );
            }
            log.error( "IMPORTANT: An exception occurred when attempting to get a downloadApplication response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a downloadApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
    }


    private GetPolicyNumberResponse getPolicyNumber( final String accountNumber,
                                                     final JMAuthData jmAuthData )
    {
        try
        {
            final GetPolicyNumberResponse getPolicyNumberResponse = jmApplicationClient.getPolicyNumber( jmAuthData.getBaseUri(),
                                                                                                         "Bearer " + jmAuthData.getAccessToken(),
                                                                                                         jmAuthData.getApiSubscriptionKey(),
                                                                                                         accountNumber );
            return getPolicyNumberResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a policy number response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a policy number response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
    }



    private UploadAppraisalResponse uploadAppraisal( final String accountNumber,
                                                     final MultipartFile appraisalDocument,
                                                     final JMAuthData jmAuthData )
    {
        try
        {
            final UploadAppraisalResponse uploadAppraisalResponse = jmApplicationClient.uploadAppraisal( jmAuthData.getBaseUri(),
                                                                                                         "Bearer " + jmAuthData.getAccessToken(),
                                                                                                         jmAuthData.getApiSubscriptionKey(),
                                                                                                         accountNumber,
                                                                                                         appraisalDocument );
            return uploadAppraisalResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UploadAppraisal response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a UploadAppraisal response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
    }


    private RegisterUserResponse processRegisterPortalUser( final RegisterUserRequest registerUserRequest,
                                                            final JMAuthData jmAuthData )
    {
        try
        {
            final RegisterUserResponse registerPortalUserResponse = jmApplicationClient.registerPortalUser( jmAuthData.getBaseUri(),
                                                                                                            "Bearer " + jmAuthData.getAccessToken(),
                                                                                                            jmAuthData.getApiSubscriptionKey(),
                                                                                                            registerUserRequest );
            return registerPortalUserResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a registerPortalUser response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a registerPortalUser response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
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

        log.info( "IMPORTANT: Persisting external quote data: " + objectMapper.writeValueAsString( externalQuoteData ) );
        externalQuoteDataService.saveOrUpdate( externalQuoteData );
    }


    private CreateAccountResponse getCreateAccountResponse( final CreateAccountRequest createAccountRequest,
                                                            final JMAuthData jmAuthData )
    {
        try
        {
            CreateAccountResponse createAccountResponse = jmApplicationClient.createAccount( jmAuthData.getBaseUri(),
                                                                                             "Bearer " + jmAuthData.getAccessToken(),
                                                                                             jmAuthData.getApiSubscriptionKey(),
                                                                                             createAccountRequest );
            return createAccountResponse;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a createAccount response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a createAccount response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
    }


    private SubmitApplicationResponse getSubmitApplicationResponse( final SubmitApplicationRequest submitApplicationRequest,
                                                                    final JMAuthData jmAuthData )
    {
        try
        {
            final SubmitApplicationResponse response = jmApplicationClient.submitApplication( jmAuthData.getBaseUri(),
                                                                                              "Bearer " + jmAuthData.getAccessToken(),
                                                                                              jmAuthData.getApiSubscriptionKey(),
                                                                                              submitApplicationRequest );
            return response;
        }
        catch ( FeignException e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a submitApplication response from JM. Message: {}. Content: {}", e.getMessage(), e.contentUTF8(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
        catch ( Exception e )
        {
            log.error( "IMPORTANT: An exception occurred when attempting to get a submitApplication response from JM: " + e.getMessage(), e );
            throw new ExternalApiException( "Unable to get response from URi: " + jmAuthData.getBaseUri() + " Message: " + e.getMessage(), e );
        }
    }
}

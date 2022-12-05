package com.dais.ioi.external.service.action.jm;

import com.dais.authorization.ForwardingAuthorization;
import com.dais.common.ioi.dto.answer.FileReferenceDto;
import com.dais.file.storage.FileReference;
import com.dais.file.storage.cms.CmsFiles;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.client.domain.dto.client.ClientDto;
import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.count.CountDto;
import com.dais.ioi.external.domain.dto.count.CountForClient;
import com.dais.ioi.external.domain.dto.internal.enums.CounterType;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.internal.enums.JmMixpanelLabel;
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
import com.dais.ioi.external.domain.dto.spec.JmUploadAppraisalSpec;
import com.dais.ioi.external.domain.exception.ExternalApiException;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.CounterService;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
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
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.regex.Pattern;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;


@Service
@Slf4j
@RequiredArgsConstructor
public class JmIntegrationServiceImpl
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
    private CounterService counterService;

    @Autowired
    private JmQuoteOptionsService jmQuoteOptionsService;

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
        countSubmitApplication( submitApplicationRequest.getQuoteId() );
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

        final JmUploadAppraisalSpec jmUploadAppraisalSpec = objectMapper.convertValue( integrationEntity.getSpec(), JmUploadAppraisalSpec.class );

        final JmApiSpec jmApiSpec = getApiSpec();

        final JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        final URI uri = URI.create( jmApiSpec.getBaseUrl() );
        log.info( "(" + trace + ") IMPORTANT: Base URI: {}, accountNumber: {}", uri, accountNumber );

        final ForwardingAuthorization cmsAuthorization = new ForwardingAuthorization();

        final ClientDto clientDto = objectMapper.convertValue( firedTriggerDto.getPayload(), ClientDto.class );

        final List<FileReferenceDto> fileReferences = clientDto.getClientIntake().getClientAnswers().get( jmUploadAppraisalSpec.getFileQuestion() ).getFiles();

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

                final UploadAppraisalResponse uploadAppraisalResponse = uploadAppraisal( accountNumber, multipartFile, jmApiSpec, jmAuthResult, uri );

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


    @SneakyThrows
    public RegisterUserResponse registerPortalUser( final RegisterUserRequest registerUserRequest,
                                                    final UUID lineId )
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


    public Map<String, Object> getMixpanelValues( final UUID clientId )
    {
        Map<String, Object> mixPanelValues = new HashMap<>();
        Map<String, Integer> mixpanelCounts = getMixpanelCounts( clientId );
        mixPanelValues.putAll( mixpanelCounts );
        jmQuoteOptionsService.getFirstCompletedQuote( clientId )
                             .ifPresent( jmQuoteOptionEntity ->
                                               mixPanelValues.put( JmMixpanelLabel.FIRST_COMPLETED_QUOTE_DATE.label, jmQuoteOptionEntity.getCreatedTimestamp() ) );
        jmQuoteOptionsService.getMostRecentCompletedQuote( clientId )
                             .ifPresent( jmQuoteOptionEntity ->
                                               mixPanelValues.put( JmMixpanelLabel.LAST_COMPLETED_QUOTE_DATE.label, jmQuoteOptionEntity.getUpdatedTimestamp() ) );
        return mixPanelValues;
    }


    private Map<String, Integer> getMixpanelCounts( final UUID clientId )
    {
        final UUID trace = UUID.randomUUID();
        log.info( "(" + trace + ") Important: Begin Mixpanel values call." );
        final List<Map<String, ?>> countKeys = counterService.getByKeyValue( "clientId", clientId.toString() );
        final Map<String, Integer> countValues = new HashMap<>();
        countKeys.forEach( countKey -> {
            int count = counterService.getCount( countKey );
            CountForClient countForClient = objectMapper.convertValue( countKey, CountForClient.class );
            countValues.put( countForClient.getKey(), count );
        } );
        return countValues;
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


    private void countSubmitApplication( final UUID externalQuoteId )
    {
        log.info( "IMPORTANT: Counting Submit Application for externalQuoteId" + externalQuoteId );
        try
        {
            final ExternalQuoteDataDto externalQuoteData = externalQuoteDataService.getByExternalQuoteId( externalQuoteId.toString() );
            final UUID clientId = externalQuoteData.getClientId();
            if ( clientId != null )
            {
                final CountForClient submitApplicationCount = CountForClient.builder().clientId( clientId ).key( JmMixpanelLabel.NUM_SUBMITTED_APPLICATIONS.label ).build();
                CountDto incrementSubmitApplication = CountDto.builder().type( CounterType.INCREMENT ).key( submitApplicationCount ).build();
                counterService.count( incrementSubmitApplication );
                log.info( "IMPORTANT: count incremented for Submitted Applications for clientId: " + clientId );
            }
            else
            {
                log.info( "IMPORTANT: No clientId assigned for externalQuoteId: " + externalQuoteId );
            }
        }
        catch ( ResponseStatusException e )
        {
            log.info( "IMPORTANT: Counting Submit Application failed.  Could not get the external quote data for " + externalQuoteId );
        }
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


    public JmApiSpec getApiSpec()
          throws Exception
    {
        List<IntegrationEntity> authEntity = externalIntegrationRepository.getIntegrationEntityByType( IntegrationType.JM_AUTH );

        if ( authEntity.size() > 1 )
        {
            throw new Exception( "Misconfiguration of JM AUTH entity!! Only single JM_AUTH entity allowed but found multiple" );
        }

        return objectMapper.convertValue( authEntity.get( 0 ).getSpec(), JmApiSpec.class );
    }
}

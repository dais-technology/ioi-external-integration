package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( orgId, IntegrationType.JM_CREATE_ACCOUNT ); // TODO check should tis be lineId or orgId
        //        log.info(String.format("createAccount->integrationEntity: %s", new ObjectMapper().writeValueAsString(integrationEntity)));

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );
        //        log.info(String.format("createAccount->actionJMSQuoteSpecDto: %s", new ObjectMapper().writeValueAsString(actionJMSQuoteSpecDto)));

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );
        //        log.info(String.format("createAccount->jmAuthResult: %s", new ObjectMapper().writeValueAsString(jmAuthResult)));

        final URI uri = URI.create( actionJMSQuoteSpecDto.getCreateAccountUrl() );

        return jmApplicationClient.createAccount( uri,
                                                  "Bearer " + jmAuthResult.getAccess_token(),
                                                  actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                  createAccountRequest );
    }


    public SubmitApplicationResponse submit( final SubmitApplicationRequest submitApplicationRequest,
                                             final UUID orgId )
    {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( orgId, IntegrationType.JM_SUBMIT_APPLICATION ); // TODO check should tis be lineId or orgId

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final URI uri = URI.create( actionJMSQuoteSpecDto.getSubmitApplicationUrl() );

        final SubmitApplicationResponse response = jmApplicationClient.submitApplication( uri,
                                                                                          "Bearer " + jmAuthResult.getAccess_token(),
                                                                                          actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                          submitApplicationRequest );

        persistExternalQuoteData( response, submitApplicationRequest.getQuoteId() );

        return response;
    }

    public ResponseEntity<Resource> downloadApplication( DownloadApplicationRequest downloadApplicationRequest,
                                                         UUID orgId )
    {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( orgId, IntegrationType.JM_DOWNLOAD_APPLICATION );

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final URI uri = URI.create( actionJMSQuoteSpecDto.getDownloadApplicationUrl() );

        final ByteArrayResource byteArrayResource = jmApplicationClient.downloadApplication( uri,
                                                                                             "Bearer " + jmAuthResult.getAccess_token(),
                                                                                             actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                                             downloadApplicationRequest );

        return ResponseEntity.ok()
                             .contentLength( byteArrayResource.contentLength() )
                             .contentType( MediaType.APPLICATION_OCTET_STREAM )
                             .body( byteArrayResource );
    }

    private void persistExternalQuoteData( final SubmitApplicationResponse response,
                                           final UUID externalQuoteId )
    {

        // At the time of the application submission

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
            log.warn( "Could not get the external quote data for " + externalQuoteId + " created a new record" );
        }


        quoteData.put( "accountNumber", response.getAccountNumber() );
        quoteData.put( "policyNumber", response.getPolicyNumber() );

        externalQuoteDataService.saveOrUpdate( externalQuoteData );
    }

}

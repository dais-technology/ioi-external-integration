package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.DownloadApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;


@Service
public class JMDownloadApplicationServiceImpl
{
    @Autowired
    JMAuthClient jmAuthClient;

    @Autowired
    JMApplicationClient jmApplicationClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;


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
}

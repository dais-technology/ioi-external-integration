package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.JMAuthData;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import com.dais.ioi.external.domain.dto.spec.JmApiSpec;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;


@Slf4j
@Service
public class JMAuthService
{
    @Autowired
    private JMAuthClient jmAuthClient;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @SneakyThrows
    public JMAuthData getAuthData( JmSource jmSource )
    {
        IntegrationEntity authEntity = externalIntegrationRepository.getIntegrationEntityByUsageAndType( jmSource.toString(), IntegrationType.JM_AUTH );

        final JmApiSpec jmApiSpec = objectMapper.convertValue( authEntity.getSpec(), JmApiSpec.class );
        JMAuthResult jmAuthResult = getAuth( jmApiSpec, jmAuthClient );

        return JMAuthData.builder().accessToken( jmAuthResult.getAccess_token() )
                         .apiSubscriptionKey( jmApiSpec.getApiSubscriptionkey() )
                         .baseUri( URI.create( jmApiSpec.getBaseUrl() ) )
                         .build();
    }
}

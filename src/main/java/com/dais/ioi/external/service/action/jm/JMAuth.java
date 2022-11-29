package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.domain.dto.spec.JmApiSpec;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;


@Slf4j
public abstract class JMAuth
{

    @SneakyThrows
    public static JMAuthResult getAuth( final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,
                                        final JMAuthClient jmAuthClient )
    {
        final String authTokenRequest = String.join( "&",
                                                     "grant_type=password",
                                                     "scope=partyAPI offline_access",
                                                     "username=" + URLEncoder.encode( actionJMSQuoteSpecDto.getUserName(), StandardCharsets.UTF_8.toString() ),
                                                     "client_id=" + URLEncoder.encode( actionJMSQuoteSpecDto.getClientId(), StandardCharsets.UTF_8.toString() ),
                                                     "client_secret=" + URLEncoder.encode( actionJMSQuoteSpecDto.getClientSecret(), StandardCharsets.UTF_8.toString() ),
                                                     "password=" + URLEncoder.encode( actionJMSQuoteSpecDto.getClientPassword(), StandardCharsets.UTF_8.toString() ) );

        final URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getAuthUrl() );
        //        log.info(String.format("createAccount->getAuth: %s -> %s", determinedBasePathUri.toString(), new ObjectMapper().writeValueAsString(authTokenRequest)));
        return jmAuthClient.getToken( determinedBasePathUri, authTokenRequest );
    }


    @SneakyThrows
    public static JMAuthResult getAuth( final JmApiSpec jmApiSpec,
                                        final JMAuthClient jmAuthClient )
    {
        final String authTokenRequest = String.join( "&",
                                                     "grant_type=password",
                                                     "scope=partyAPI offline_access",
                                                     "username=" + URLEncoder.encode( jmApiSpec.getUserName(), StandardCharsets.UTF_8.toString() ),
                                                     "client_id=" + URLEncoder.encode( jmApiSpec.getClientId(), StandardCharsets.UTF_8.toString() ),
                                                     "client_secret=" + URLEncoder.encode( jmApiSpec.getClientSecret(), StandardCharsets.UTF_8.toString() ),
                                                     "password=" + URLEncoder.encode( jmApiSpec.getClientPassword(), StandardCharsets.UTF_8.toString() ) );

        final URI determinedBasePathUri = URI.create( jmApiSpec.getAuthUrl() );

        return jmAuthClient.getToken( determinedBasePathUri, authTokenRequest );
    }
}

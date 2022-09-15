package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;

@Slf4j
public abstract class JMAuth
{

    @SneakyThrows
    public static JMAuthResult getAuth(final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto, final JMAuthClient jmAuthClient)
    {
        final String authTokenRequest = String.join("&",
                "grant_type=password",
                "scope=partyAPI offline_access",
                "username=" + actionJMSQuoteSpecDto.getUserName(),
                "client_id=" + actionJMSQuoteSpecDto.getClientId(),
                "client_secret=" + actionJMSQuoteSpecDto.getClientSecret(),
                "password=" + actionJMSQuoteSpecDto.getClientPassword());

        final URI determinedBasePathUri = URI.create(actionJMSQuoteSpecDto.getAuthUrl());
        log.info(String.format("createAccount->getAuth: %s -> %s", determinedBasePathUri.toString(), new ObjectMapper().writeValueAsString(authTokenRequest)));
        return jmAuthClient.getToken(determinedBasePathUri, authTokenRequest);
    }
}

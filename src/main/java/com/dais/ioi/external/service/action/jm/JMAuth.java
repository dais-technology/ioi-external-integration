package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;

import java.net.URI;

public abstract class JMAuth
{

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

       return jmAuthClient.getToken(determinedBasePathUri, authTokenRequest);
    }
}

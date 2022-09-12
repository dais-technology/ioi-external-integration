package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;

@Service
@Slf4j
@RequiredArgsConstructor
public class JMCreateAccountServiceImpl {
    @Autowired
    JMAuthClient jmAuthClient;
    @Autowired
    JMApplicationClient jmApplicationClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    public CreateAccountResponse createAccount(final CreateAccountRequest createAccountRequest, final UUID orgId ) {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType(orgId, IntegrationType.JM_CREATE_ACCOUNT); // TODO check should tis be lineId or orgId

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue(integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class);

        final JMAuthResult jmAuthResult = getAuth(actionJMSQuoteSpecDto, jmAuthClient);

        return processAccountCreation(createAccountRequest, jmAuthResult, actionJMSQuoteSpecDto);
    }

    private CreateAccountResponse processAccountCreation(final CreateAccountRequest createAccountRequest, final JMAuthResult jmAuthResult, final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto) {

        final URI uri = URI.create(actionJMSQuoteSpecDto.getCreateAccountUrl());
//        final URI uri = URI.create("https://test-api.jewelersmutual.com/api/quoteandapplication-t8/v3/account/create");

        return jmApplicationClient.createAccount(uri,
            "Bearer " + jmAuthResult.getAccess_token(),
            actionJMSQuoteSpecDto.getApiSubscriptionkey(),
            createAccountRequest);
    }
}

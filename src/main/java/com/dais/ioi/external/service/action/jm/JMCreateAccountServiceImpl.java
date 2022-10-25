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
import lombok.SneakyThrows;
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

    @SneakyThrows
    public CreateAccountResponse createAccount(final CreateAccountRequest createAccountRequest, final UUID lineId ) {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( lineId, IntegrationType.JM_CREATE_ACCOUNT); // TODO check should tis be lineId or lineId
//        log.info(String.format("createAccount->integrationEntity: %s", new ObjectMapper().writeValueAsString(integrationEntity)));

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue(integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class);
//        log.info(String.format("createAccount->actionJMSQuoteSpecDto: %s", new ObjectMapper().writeValueAsString(actionJMSQuoteSpecDto)));

        final JMAuthResult jmAuthResult = getAuth(actionJMSQuoteSpecDto, jmAuthClient);
//        log.info(String.format("createAccount->jmAuthResult: %s", new ObjectMapper().writeValueAsString(jmAuthResult)));

        return processAccountCreation(createAccountRequest, jmAuthResult, actionJMSQuoteSpecDto);
    }

    private CreateAccountResponse processAccountCreation(final CreateAccountRequest createAccountRequest, final JMAuthResult jmAuthResult, final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto) {

        final URI uri = URI.create(actionJMSQuoteSpecDto.getCreateAccountUrl());

        return jmApplicationClient.createAccount(uri,
            "Bearer " + jmAuthResult.getAccess_token(),
            actionJMSQuoteSpecDto.getApiSubscriptionkey(),
            createAccountRequest);
    }
}

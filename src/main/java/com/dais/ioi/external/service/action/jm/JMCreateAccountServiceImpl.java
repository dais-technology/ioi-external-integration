package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
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
import java.util.Map;
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

    //TODO: figure out the input output for this
    public TriggerResponseDto createAccount(final FiredTriggerDto ap) {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntitiesByOrganizationId(ap.getLineId());

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue(integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class);

        final JMAuthResult jmAuthResult = getAuth(actionJMSQuoteSpecDto, jmAuthClient);

        //Not sure if we need this response DTO
        CreateAccountResponse response = processAccountCreation(ap, jmAuthResult, actionJMSQuoteSpecDto);

        return null;
    }

    private CreateAccountResponse processAccountCreation(final FiredTriggerDto firedTriggerDto, final JMAuthResult jmAuthResult, final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto) {

        //TODO: figure out the input. I just assumed here its in payload
        final Map<String, ?> payload = firedTriggerDto.getPayload();
        final UUID quoteId = UUID.fromString((String) payload.get("quoteId"));

        final CreateAccountRequest request = CreateAccountRequest.builder()
                .quoteId(quoteId)
                .build();

        final URI uri = URI.create( actionJMSQuoteSpecDto.getQuickQuoteUrl() );

        return jmApplicationClient.createAccount(uri,
                "Bearer " + jmAuthResult.getAccess_token(),
                actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                request);
    }
}

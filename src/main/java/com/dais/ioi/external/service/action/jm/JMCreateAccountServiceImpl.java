package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.external.config.client.IOIQuoteClient;
import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.CreateAccountRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.TriggerQuotesDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Map;
import java.util.Optional;
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
    private IOIQuoteClient ioiQuoteClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    public CreateAccountResponse createAccount(final FiredTriggerDto ap) {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType(ap.getLineId(), IntegrationType.JM_CREATE_ACCOUNT); // TODO check should tis be lineId or orgId

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue(integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class);

        final JMAuthResult jmAuthResult = getAuth(actionJMSQuoteSpecDto, jmAuthClient);

        return processAccountCreation(ap, jmAuthResult, actionJMSQuoteSpecDto);
    }

    private CreateAccountResponse processAccountCreation(final FiredTriggerDto firedTriggerDto, final JMAuthResult jmAuthResult, final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto) {

        //TODO: figure out the input. I just assumed here its in payload
        final Map<String, ?> payload = firedTriggerDto.getPayload();
        final UUID quoteId = UUID.fromString((String) payload.get("quoteId"));
        final UUID clientId = UUID.fromString((String) payload.get("clientId"));
        final UUID lineId = firedTriggerDto.getLineId();

//        final List<ProductQuoteDto> productQuotesDto = ioiQuoteClient.getProductQuotes(clientId, QuoteSearchDto.builder().lineId(lineId).build());
//        final Optional<ProductQuoteDto> productQuoteDto = productQuotesDto.stream().findFirst();
//        final Optional<LineQuoteDto> lineQuoteDto = productQuoteDto.get().getLineQuotes().stream().filter(quoteDto -> quoteDto.getLineId().equals(lineId)).findFirst();
//        final Optional<QuoteDto> ioiQuote = lineQuoteDto.get().getQuotes().getQuoted().stream().filter(quoteDto -> quoteDto.getRequestId().equals(quoteId)).findFirst();

        final TriggerQuotesDto triggerQuotesDto = ioiQuoteClient.getQuotes(firedTriggerDto.getTriggerRequestId(), false);
        final Optional<QuoteDto> ioiQuote = triggerQuotesDto.getQuoted().stream().filter(quoteDto -> quoteDto.getRequestId().equals(quoteId)).findFirst();

        final UUID jmQuoteId;

        if (!ioiQuote.isPresent()) {
            throw new RuntimeException("Quote not found");
        } else {
            jmQuoteId = UUID.fromString(ioiQuote.get().getQuoteDetails().getExternalData().getExternalQuoteId());
        }

        final CreateAccountRequest request = CreateAccountRequest.builder()
            .quoteId(jmQuoteId)
            .build();

        //final URI uri = URI.create(actionJMSQuoteSpecDto.getQuickQuoteUrl());
        final URI uri = URI.create("https://test-api.jewelersmutual.com/api/quoteandapplication-t8/v3/account/create");

        return jmApplicationClient.createAccount(uri,
            "Bearer " + jmAuthResult.getAccess_token(),
            actionJMSQuoteSpecDto.getApiSubscriptionkey(),
            request);
    }
}

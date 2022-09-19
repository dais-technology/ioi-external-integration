package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.external.config.client.JMApplicationClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationRequest;
import com.dais.ioi.external.domain.dto.jm.SubmitApplicationResponse;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;


@Service
@Slf4j
@RequiredArgsConstructor
public class JMSubmitApplicationServiceImpl
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


    public SubmitApplicationResponse submit( final SubmitApplicationRequest submitApplicationRequest,
                                             final UUID orgId )
    {

        final IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( orgId, IntegrationType.JM_SUBMIT_APPLICATION ); // TODO check should tis be lineId or orgId

        final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( integrationEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        final SubmitApplicationResponse response = processSubmitApplication( submitApplicationRequest, jmAuthResult, actionJMSQuoteSpecDto );

        persistExternalQuoteData( response, submitApplicationRequest.getQuoteId() );

        return response;
    }


    private void persistExternalQuoteData( final SubmitApplicationResponse response,
                                           final UUID externalQuoteId )
    {
        Map<String, String> quoteData = new HashMap<>();
        quoteData.put( "accountNumber", response.getAccountNumber() );
        quoteData.put( "policyNumber", response.getPolicyNumber() );

        ExternalQuoteDataDto externalQuoteData = ExternalQuoteDataDto.builder().externalQuoteId( externalQuoteId.toString() ).quoteData( quoteData ).build();
        externalQuoteDataService.saveOrUpdate( externalQuoteData );
    }


    private SubmitApplicationResponse processSubmitApplication( final SubmitApplicationRequest submitApplicationRequest,
                                                                final JMAuthResult jmAuthResult,
                                                                final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {

        final URI uri = URI.create( actionJMSQuoteSpecDto.getSubmitApplicationUrl() );

        return jmApplicationClient.submitApplication( uri,
                                                      "Bearer " + jmAuthResult.getAccess_token(),
                                                      actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                      submitApplicationRequest );
    }
}

package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.InboundResponseDataDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.IOIActionClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
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


@Service
@Slf4j
@RequiredArgsConstructor

public class JMQuoteServiceImpl
{
    @Autowired
    JMAuthClient jmAuthClient;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    JMQuickQuoteHelperImpl jmQuickQuoteHelper;

    @Autowired
    JMAddQuoteHelperImpl jmAddQuoteHelper;

    @Autowired
    IOIActionClient ioiActionClient;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;
     public TriggerResponseDto fire( final FiredTriggerDto ap ) throws Exception
    {
        IntegrationEntity entity =  externalIntegrationRepository.getIntegrationEntitiesByOrganizationId( ap.getLineId() );

        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );

        final String authTokenRequest = String.join( "&",
                                                     "grant_type=password",
                                                     "scope=partyAPI offline_access",
                                                     "username=" + actionJMSQuoteSpecDto.getUserName() ,
                                                     "client_id=" + actionJMSQuoteSpecDto.getClientId() ,
                                                     "client_secret=" + actionJMSQuoteSpecDto.getClientSecret() ,
                                                     "password=" +  actionJMSQuoteSpecDto.getClientPassword() ) ;

        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getAuthUrl());

        JMAuthResult jmAuthResult = jmAuthClient.getToken(determinedBasePathUri, authTokenRequest );

        TriggerResponseDto triggerResponseDto;

        if ( entity.getType().equals( IntegrationType.JM_ADDQUOTE) ) {

            triggerResponseDto  = jmAddQuoteHelper.processAddQuote( ap, jmAuthResult, actionJMSQuoteSpecDto );

        }
        else {
            triggerResponseDto =  jmQuickQuoteHelper.processQuickQuote( ap, jmAuthResult, actionJMSQuoteSpecDto );

        }
        InboundResponseDataDto inboundResponseDataDto = new InboundResponseDataDto();
        inboundResponseDataDto.setRequestId( triggerResponseDto.getTriggerRequestId() );

        Map<String, Object> payload = objectMapper.convertValue( triggerResponseDto.getMetadata().get( ap.getTriggerRequestId().toString()), Map.class );
        inboundResponseDataDto.setPayload( payload);

        ioiActionClient.processInboundData( inboundResponseDataDto );

        return triggerResponseDto;
    }
}

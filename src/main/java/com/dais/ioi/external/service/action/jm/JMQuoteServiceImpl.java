package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.InboundResponseDataDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.IOIActionClient;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.dais.ioi.external.service.action.jm.JMAuth.getAuth;
import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;


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


    public TriggerResponseDto fire( final FiredTriggerDto ap )
          throws Exception
    {

        String externalIntegrationType = (String) ap.getPayload().get( "externalIntegrationType" );

        IntegrationEntity entity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( ap.getLineId(), IntegrationType.valueOf( externalIntegrationType ) );

        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );

        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        TriggerResponseDto triggerResponseDto;

        if ( entity.getType().equals( IntegrationType.JM_ADDQUOTE ) )
        {

            triggerResponseDto = jmAddQuoteHelper.processAddQuote( ap, jmAuthResult, actionJMSQuoteSpecDto );

            String externalQuoteId = (String) ap.getPayload().get( "externalQuoteId" );

            if ( externalQuoteId != null && !externalQuoteId.equalsIgnoreCase( "" ) )
            {

                return triggerResponseDto;
            }

            if ( getValue( () -> triggerResponseDto.getMetadata().get( "isCoverageAvailable" ).toString(), "true" ).equalsIgnoreCase( "false" ) )
            {

                return triggerResponseDto;
            }
        }
        else
        {
            triggerResponseDto = jmQuickQuoteHelper.processQuickQuote( ap, jmAuthResult, actionJMSQuoteSpecDto );
        }
        InboundResponseDataDto inboundResponseDataDto = new InboundResponseDataDto();
        inboundResponseDataDto.setRequestId( triggerResponseDto.getTriggerRequestId() );

        Map<String, Object> payload = objectMapper.convertValue( triggerResponseDto.getMetadata().get( ap.getTriggerRequestId().toString() ), Map.class );
        inboundResponseDataDto.setPayload( payload );

        ioiActionClient.processInboundData( inboundResponseDataDto );

        return triggerResponseDto;
    }


    public QuoteDto getQuickQuote( final GetQuoteDto ap )
          throws Exception
    {
        IntegrationEntity entity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( ap.getLineId(), IntegrationType.JM_QUICKQUOTE );
        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );
        final JMAuthResult jmAuthResult = getAuth( actionJMSQuoteSpecDto, jmAuthClient );

        return jmQuickQuoteHelper.getQuickQuote( ap, jmAuthResult, actionJMSQuoteSpecDto );
    }
}

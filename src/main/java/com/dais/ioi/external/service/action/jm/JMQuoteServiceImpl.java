package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.enums.ActionType;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.LoggingDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.jm.GetQuoteDto;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.logger.ActivityLoggerService;
import com.dais.ioi.log.domain.dto.Category;
import com.dais.ioi.log.domain.dto.LogDto;
import com.dais.ioi.log.domain.dto.LogLevel;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;


@Service
@Slf4j
@RequiredArgsConstructor
public class JMQuoteServiceImpl
{
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    JMQuickQuoteHelperImpl jmQuickQuoteHelper;

    @Autowired
    JMAddQuoteHelperImpl jmAddQuoteHelper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private final ActivityLoggerService devLog;


    public TriggerResponseDto fire( final FiredTriggerDto ap )
          throws Exception
    {

        String externalIntegrationType = (String) ap.getPayload().get( "externalIntegrationType" );

        IntegrationEntity entity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( ap.getLineId(), IntegrationType.valueOf( externalIntegrationType ) );

        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );

        TriggerResponseDto triggerResponseDto;

        triggerResponseDto = jmAddQuoteHelper.processAddQuote( ap, actionJMSQuoteSpecDto );

        String externalQuoteId = (String) ap.getPayload().get( "externalQuoteId" );

        if ( externalQuoteId != null && !externalQuoteId.equalsIgnoreCase( "" ) )
        {

            return triggerResponseDto;
        }

        if ( getValue( () -> triggerResponseDto.getMetadata().get( "isCoverageAvailable" ).toString(), "true" ).equalsIgnoreCase( "false" ) )
        {

            return triggerResponseDto;
        }

        return triggerResponseDto;
    }


    public AddPaymentPlanResponseDto addPaymentPlan( final AddPaymentPlanRequestDto paymentPlan )
          throws Exception
    {
        IntegrationEntity entity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( paymentPlan.getLineId(), IntegrationType.JM_ADDQUOTE );
        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );

        AddPaymentPlanResponseDto addPaymentPlanResponseDto = jmAddQuoteHelper.addPaymentPlan( paymentPlan.getExternalQuoteId(), paymentPlan.getAgent(), paymentPlan.getIntake(), paymentPlan.getSelectedPaymentPlan(), paymentPlan.getJmSource(), actionJMSQuoteSpecDto );
        if ( paymentPlan.getSource().getOrganizationId() != null )
        {
            LoggingDto loggingDto = LoggingDto.builder()
                                              .name( "ADD PAYMENT" )
                                              .description( "Add payment plan request and response" )
                                              .input( objectMapper.convertValue( paymentPlan, Map.class ) )
                                              .output( objectMapper.convertValue( addPaymentPlanResponseDto, Map.class ) )
                                              .build();

            devLog.logActivity( LogDto.builder()
                                      .organizationId( paymentPlan.getSource().getOrganizationId() )
                                      .lineId( paymentPlan.getLineId() )
                                      .category( Category.EXTERNAL_OUTBOUND )
                                      .action( String.valueOf( ActionType.EXTERNAL_INTEGRATION ) )
                                      .trigger( "JM_PAYMENT" )
                                      .level( LogLevel.INFO )
                                      .message( objectMapper.convertValue( loggingDto, Map.class ) )
                                      .build() );
        }

        return addPaymentPlanResponseDto;
    }


    public QuoteDto getQuickQuote( final GetQuoteDto ap )
          throws Exception
    {
        IntegrationEntity entity = externalIntegrationRepository.getIntegrationEntityByLineIdAndType( ap.getLineId(), IntegrationType.JM_QUICKQUOTE );
        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( entity.getSpec(), ActionJMSQuoteSpecDto.class );

        return jmQuickQuoteHelper.getQuickQuote( ap, actionJMSQuoteSpecDto );
    }
}

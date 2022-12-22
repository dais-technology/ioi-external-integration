package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.enums.ActionType;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.LoggingDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.domain.dto.spec.JmApiSpec;
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
    JMAuthClient jmAuthClient;

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

        final JmApiSpec jmApiSpec = getApiSpec();

        TriggerResponseDto triggerResponseDto;

        triggerResponseDto = jmAddQuoteHelper.processAddQuote( ap, jmApiSpec, actionJMSQuoteSpecDto );

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

        final JmApiSpec jmApiSpec = getApiSpec();

        AddPaymentPlanResponseDto addPaymentPlanResponseDto = jmAddQuoteHelper.addPaymentPlan( paymentPlan.getExternalQuoteId(), paymentPlan.getAgent(), paymentPlan.getIntake(), paymentPlan.getSelectedPaymentPlan(), jmApiSpec, actionJMSQuoteSpecDto );
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

        final JmApiSpec jmApiSpec = getApiSpec();

        return jmQuickQuoteHelper.getQuickQuote( ap, jmApiSpec, actionJMSQuoteSpecDto );
    }

    public JmApiSpec getApiSpec()
          throws Exception
    {
        List<IntegrationEntity> authEntity = externalIntegrationRepository.getIntegrationEntityByType( IntegrationType.JM_AUTH );

        if ( authEntity.size() > 1 )
        {
            throw new Exception( "Misconfiguration of JM AUTH entity!! Only single JM_AUTH entity allowed but found multiple" );
        }

        return objectMapper.convertValue( authEntity.get( 0 ).getSpec(), JmApiSpec.class );
    }
}

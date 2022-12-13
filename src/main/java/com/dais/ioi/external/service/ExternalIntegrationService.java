package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanRequestDto;
import com.dais.ioi.external.domain.dto.jm.AddPaymentPlanResponseDto;
import com.dais.ioi.quote.domain.dto.QuoteDto;

import java.util.UUID;


public interface ExternalIntegrationService
{
    IntegrationDto getById( UUID integrationId );

    IntegrationDto create( final IntegrationDto integrationDto );

    IntegrationDto createOrUpdate( final IntegrationDto integrationDto );

    TriggerResponseDto process( FiredTriggerDto firedTriggerDto )
          throws Exception;

    AddPaymentPlanResponseDto addPaymentPlan( final AddPaymentPlanRequestDto paymentPlan )
          throws Exception;

    @Deprecated
    QuoteDto getQuickQuote( GetQuoteDto firedTriggerDto )
          throws Exception;

    QuoteDto getCachedQuickQuote( final GetQuoteDto quoteDto )
          throws Exception;

    TriggerResponseDto processSynchronous( final FiredTriggerDto firedTriggerDto )
          throws Exception;

    void deleteById( UUID integrationId );

}

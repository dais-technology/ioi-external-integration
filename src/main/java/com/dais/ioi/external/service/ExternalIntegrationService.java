package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import org.springframework.scheduling.Trigger;


public interface ExternalIntegrationService
{
    IntegrationDto create( final IntegrationDto integrationDto );

    TriggerResponseDto process( FiredTriggerDto firedTriggerDto );

    TriggerResponseDto submitApplication( FiredTriggerDto firedTriggerDto );

    TriggerResponseDto createAccount( FiredTriggerDto firedTriggerDto );
}

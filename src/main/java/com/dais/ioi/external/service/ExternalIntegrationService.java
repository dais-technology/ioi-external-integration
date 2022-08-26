package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;


public interface ExternalIntegrationService
{
    IntegrationDto create( final IntegrationDto integrationDto );

    void process( FiredTriggerDto firedTriggerDto );
}

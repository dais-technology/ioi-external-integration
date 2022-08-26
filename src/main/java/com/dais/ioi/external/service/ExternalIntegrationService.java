package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.external.domain.dto.ExternalInputDto;


public interface ExternalIntegrationService
{
    public void process( FiredTriggerDto firedTriggerDto );
}

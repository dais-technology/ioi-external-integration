package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
public interface ExternalIntegrationService
{
    public TriggerResponseDto process( FiredTriggerDto firedTriggerDto );
}

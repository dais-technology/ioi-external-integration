package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.dto.IntegrationDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.jm.CreateAccountResponse;


public interface ExternalIntegrationService
{
    IntegrationDto create( final IntegrationDto integrationDto );

    TriggerResponseDto process( FiredTriggerDto firedTriggerDto )
          throws Exception;

    void hubspotTrack( final HubspotTrackRequest request );

    TriggerResponseDto submitApplication( FiredTriggerDto firedTriggerDto );

    CreateAccountResponse createAccount(FiredTriggerDto firedTriggerDto );
}

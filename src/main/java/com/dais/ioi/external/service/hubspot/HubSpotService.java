package com.dais.ioi.external.service.hubspot;

import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;

import java.util.Map;


public interface HubSpotService
{
    //todo: replace parameters with proper DTO
    void trackEvent( final HubspotTrackRequest request );
}

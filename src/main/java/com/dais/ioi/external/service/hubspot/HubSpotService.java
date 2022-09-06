package com.dais.ioi.external.service.hubspot;

import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;


public interface HubSpotService
{
    void trackEvent( final HubspotTrackRequest request );
}

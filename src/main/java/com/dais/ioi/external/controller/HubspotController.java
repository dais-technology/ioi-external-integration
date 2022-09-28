package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.HubspotApi;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.service.hubspot.HubSpotService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping( "/external" )
@AllArgsConstructor
public class HubspotController
      implements HubspotApi
{
    private final HubSpotService hubSpotService;


    @Override
    public void trackEvent( final HubspotTrackRequest request )
    {
        hubSpotService.trackEvent( request );
    }
}

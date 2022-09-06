package com.dais.ioi.external.domain.dto.spec;

import lombok.Data;


@Data
public class HubspotTrackSpec
{
    private String portalId;

    private String apiKey;

    private String eventId;
}

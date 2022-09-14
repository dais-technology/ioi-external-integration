package com.dais.ioi.external.domain.dto.hubspot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HubspotTrackRequest
{
    private UUID organizationId;

    private Map<String, ?> input;
}

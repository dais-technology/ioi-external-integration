package com.dais.ioi.external.domain.dto.hubspot;

import com.dais.ioi.external.domain.dto.BaseSourceDto;
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
      extends BaseSourceDto
{
    private UUID lineId;

    private String usage;

    private Map<String, ?> input;
}

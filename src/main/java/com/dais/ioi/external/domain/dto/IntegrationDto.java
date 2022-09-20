package com.dais.ioi.external.domain.dto;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class IntegrationDto
{
    private UUID id;

    private UUID organizationId;

    private IntegrationType type;

    private String usage;

    private String description;

    private Map<String, ?> spec;
}

package com.dais.ioi.external.domain.dto;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class GetQuoteDto
{
    private UUID lineId;

    private UUID clientId;

    private UUID organizationId;

    private IntegrationType externalIntegrationType;

    private AgentInfoDto agentInfo;

    private LinkedHashMap<String, ClientAnswerDto> intake;

    private String effectiveDate;
}

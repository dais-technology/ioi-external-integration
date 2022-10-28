package com.dais.ioi.external.domain.dto.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.ioi.external.domain.dto.AgentInfoDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class AddPaymentPlanRequestDto
{
    private UUID lineId;

    //TODO: Verify if this can be a UUID
    private String externalQuoteId;

    private AgentInfoDto agent;

    private Map<String, ClientAnswerDto> intake;

    //TODO: use a dto
    private Map<String, Object> selectedPaymentPlan;
}

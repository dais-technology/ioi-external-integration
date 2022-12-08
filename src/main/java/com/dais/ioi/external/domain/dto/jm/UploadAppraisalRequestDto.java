package com.dais.ioi.external.domain.dto.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
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
public class UploadAppraisalRequestDto
{
    private UUID clientId;

    private String accountNumber;

    private Map<String, ClientAnswerDto> intake;
}

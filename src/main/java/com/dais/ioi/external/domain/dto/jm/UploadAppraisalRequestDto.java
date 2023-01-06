package com.dais.ioi.external.domain.dto.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
@EqualsAndHashCode(callSuper = true)
public class UploadAppraisalRequestDto extends JmBaseDto
{
    @NotNull
    private UUID clientId;

    @NotNull
    private String accountNumber;

    @NotNull
    private Map<String, ClientAnswerDto> intake;
}

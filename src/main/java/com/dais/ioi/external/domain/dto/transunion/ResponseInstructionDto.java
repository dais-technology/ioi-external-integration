package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseInstructionDto
{
    @Builder.Default
    private String returnErrorText = "true";

    @Builder.Default
    private String document = "";
}

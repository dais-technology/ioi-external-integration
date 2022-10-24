package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassCodeQuestionDto
{
    private String questionId;

    private String questionCd;

    private String responseInd;

    private String percentageAnswerValue;

    private OptionResponseDto optionResponseDto;
}
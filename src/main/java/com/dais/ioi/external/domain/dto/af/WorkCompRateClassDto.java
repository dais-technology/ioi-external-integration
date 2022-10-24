package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompRateClassDto
{
    private Integer ratingClassificationCd;

    private Integer ratingClassificationSubCd;

    private Double payrollAmount;

    private ClassCodeQuestionsDto classCodeQuestionsDto;
}

package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompLineBusinessDto
{
    private List<WorkCompRateStateDto> workCompRateStateDto;

    private CommlCoverageDto commlCoverageDto;

    private IneligibilityDto ineligibilityDto;

    private StatementDto statementDto;
}

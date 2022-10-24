package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommlPolicySupplementDto
{

    private String operationsDesc;

    private LengthTimeInBusinessDto lengthTimeInBusinessDto;

    private String lossDataAvailable;

    private Integer numberClaims;

    private Double totalClaimAmount;
}

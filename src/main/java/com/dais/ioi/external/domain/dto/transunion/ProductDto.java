package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDto
{
    private String code;

    private SubjectDto subject;

    private ResponseInstructionDto responseInstructions;

    private PermissiblePurposeDto permissiblePurpose;
}

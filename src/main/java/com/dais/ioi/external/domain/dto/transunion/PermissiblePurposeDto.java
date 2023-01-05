package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PermissiblePurposeDto
{
    @Builder.Default
    private String code = "IN";

    @Builder.Default
    private String inquiryECOADesignator = "individual";
}

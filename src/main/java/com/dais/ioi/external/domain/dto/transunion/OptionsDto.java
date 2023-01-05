package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OptionsDto
{
    private String processingEnvironment;

    @Builder.Default
    private String country = "us";

    @Builder.Default
    private String language = "en";

    @Builder.Default
    private String contractualRelationship = "individual";

    @Builder.Default
    private String pointOfSaleIndicator = "none";
}

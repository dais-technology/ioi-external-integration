package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommercialCoverageDto
{
    @JacksonXmlProperty( localName = "CoverageCd" )
    @Builder.Default
    private String coverageCd = "WC7WorkersCompEmpLiabInsurancePolicyACov";

    @JacksonXmlProperty( localName = "CoverageDesc" )
    @Builder.Default
    private String coverageDesc = "Employers Liability";

    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "Limit" )
    private List<LimitDto> limitDto;
}

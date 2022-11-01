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
public class WorkCompLineBusinessDto
{
    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "WorkCompRateState" )
    private List<WorkCompRateStateDto> workCompRateStateDto;

    @JacksonXmlProperty( localName = "CommlCoverage" )
    private CommercialCoverageDto commercialCoverageDto;

    @JacksonXmlProperty( localName = "Ineligibility" )
    private IneligibilityDto ineligibilityDto;

    @JacksonXmlProperty( localName = "Statement" )
    private StatementDto statementDto;
}

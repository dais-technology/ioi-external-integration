package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompLocationDto
{
    @JacksonXmlProperty( isAttribute = true,
                         localName = "LocationRef" )
    private String locationRef;

    @JacksonXmlProperty( localName = "WorkCompRateClass" )
    private WorkCompRateClassDto workCompRateClassDto;
}

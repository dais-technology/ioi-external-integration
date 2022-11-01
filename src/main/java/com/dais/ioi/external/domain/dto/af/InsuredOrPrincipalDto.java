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
public class InsuredOrPrincipalDto
{
    @JacksonXmlProperty( isAttribute = true )
    @Builder.Default
    private String id = "n0";

    @JacksonXmlProperty( localName = "GeneralPartyInfo" )
    private GeneralPartyInformationDto generalPartyInformationDto;
}

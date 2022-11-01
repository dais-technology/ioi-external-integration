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
public class AdditionalInterestDto
{
    @JacksonXmlProperty( isAttribute = true )
    private String id;

    @JacksonXmlProperty( localName = "GeneralPartyInfo" )
    private GeneralPartyInformationDto generalPartyInformationDto;

    @JacksonXmlProperty( localName = "AdditionalInterestInfo" )
    private AdditionalInterestInfoDto additionalInterestInfoDto;
}

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
public class ProducerDto
{
    @JacksonXmlProperty( localName = "ItemIdInfo" )
    private ItemIdInfoDto itemIdInfoDto;

    @JacksonXmlProperty( localName = "GeneralPartyInfo" )
    private GeneralPartyInformationDto generalPartyInformationDto;
}

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
public class GeneralPartyInformationDto
{
    @JacksonXmlProperty( localName = "NameInfo" )
    private NameDto nameDto;

    @JacksonXmlProperty( localName = "Addr" )
    private AddressDto addressDto;

    @JacksonXmlProperty( localName = "Communications" )
    private CommunicationsDto communicationsDto;
}

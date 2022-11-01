package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class AddressDto
{
    @JacksonXmlProperty( localName = "AddrTypeCd" )
    private String addressTypeCd;

    @JacksonXmlProperty( localName = "Addr1" )
    private String address1;

    @JacksonXmlProperty( localName = "Addr2" )
    private String address2;

    @JacksonXmlProperty( localName = "City" )
    private String city;

    @JacksonXmlProperty( localName = "StateProvCd" )
    private String stateProvCd;

    @JacksonXmlProperty( localName = "PostalCode" )
    private String postalCd;

    @JacksonXmlProperty( localName = "County" )
    private String county;

    @JacksonXmlProperty( localName = "CountryCd" )
    private String countryCd;
}

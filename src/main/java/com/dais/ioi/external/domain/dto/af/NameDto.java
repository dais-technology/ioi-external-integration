package com.dais.ioi.external.domain.dto.af;

import com.dais.ioi.external.domain.dto.internal.enums.af.LegalEntity;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NameDto
{
    @JacksonXmlProperty( isAttribute = true )
    private String id;

    @JacksonXmlProperty( localName = "PersonName" )
    private PersonNameDto personNameDto;

    @JacksonXmlProperty( localName = "CommlName" )
    private CommercialNameDto commercialNameDto;

    @JacksonXmlProperty( localName = "LegalEntityCd" )
    private LegalEntity legalEntityCd;

    @JacksonXmlProperty( localName = "TaxIdentity" )
    private TaxIdentityDto taxIdentityDto;
}

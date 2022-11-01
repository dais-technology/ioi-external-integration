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
public class CommercialPolicyDto
{
    @JacksonXmlProperty( localName = "ControllingStateProvCd" )
    private String controllingStateProvCd;

    @JacksonXmlProperty( localName = "com.afg_TotalEmployees" )
    private Long totalEmployees;

    @JacksonXmlProperty( localName = "ContractTerm" )
    private ContractTermDto contractTermDto;

    @JacksonXmlProperty( localName = "CommlPolicySupplement" )
    private CommercialPolicySupplementDto commercialPolicySupplementDto;
}

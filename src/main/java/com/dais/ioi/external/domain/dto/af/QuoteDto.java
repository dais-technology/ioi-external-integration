package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement( name = "ACORD" )
public class QuoteDto
{
    @JacksonXmlProperty( localName = "SignonRq" )
    private SignonDto signonDto;

    @JacksonXmlProperty( localName = "InsuranceSvcRq" )
    private InsuranceServiceDto insuranceServiceDto;
}

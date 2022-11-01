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
public class CommercialPolicySupplementDto
{

    @JacksonXmlProperty( localName = "OperationsDesc" )
    private String operationsDesc;

    @JacksonXmlProperty( localName = "LengthTimeInBusiness" )
    private BusinessLengthDto businessLengthDto;

    @JacksonXmlProperty( localName = "LossDataAvailable" )
    private String lossDataAvailable;

    @JacksonXmlProperty( localName = "NumberClaims" )
    private Integer numberOfClaims;

    @JacksonXmlProperty( localName = "TotalClaimAmount" )
    private Double totalClaimAmount;
}

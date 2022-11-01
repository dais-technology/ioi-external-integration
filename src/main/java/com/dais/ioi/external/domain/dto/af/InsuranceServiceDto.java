package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceServiceDto
{
    @JacksonXmlProperty( localName = "RqUID" )
    private UUID rqUID;

    @JacksonXmlProperty( localName = "WorkCompPolicyQuoteInqRq" )
    private WorkCompPolicyQuoteDto workCompPolicyQuoteDto;
}

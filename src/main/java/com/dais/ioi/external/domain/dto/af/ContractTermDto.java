package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContractTermDto
{
    @JacksonXmlProperty( localName = "EffectiveDt" )
    private LocalDate effectiveDt;

    @JacksonXmlProperty( localName = "ExpirationDt" )
    private LocalDate expirationDt;
}

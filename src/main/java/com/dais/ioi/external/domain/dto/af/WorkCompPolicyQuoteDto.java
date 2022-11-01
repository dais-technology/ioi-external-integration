package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompPolicyQuoteDto
{
    @JacksonXmlProperty( localName = "TransactionRequestDt" )
    private LocalDate transactionRequestDt;

    @JacksonXmlProperty( localName = "Producer" )
    private ProducerDto producerDto;

    @JacksonXmlProperty( localName = "InsuredOrPrincipal" )
    private InsuredOrPrincipalDto insuredOrPrincipalDto;

    @JacksonXmlProperty( localName = "CommlPolicy" )
    private CommercialPolicyDto commercialPolicyDto;

    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "Location" )
    private List<LocationDto> locationDto;

    @JacksonXmlProperty( localName = "WorkCompLineBusiness" )
    private WorkCompLineBusinessDto workCompLineBusinessDto;
}

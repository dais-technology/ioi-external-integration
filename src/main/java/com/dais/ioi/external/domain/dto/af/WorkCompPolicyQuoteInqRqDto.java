package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompPolicyQuoteInqRqDto
{
    private LocalDate transactionRequestDt;

    private ProducerDto producerDto;

    private InsuredOrPrincipalDto insuredOrPrincipalDto;

    private CommlPolicyDto commlPolicyDto;

    private LocationDto locationDto;

    private WorkCompLineBusinessDto workCompLineBusinessDto;
}

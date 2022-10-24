package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuranceSvcRqDto
{
    private UUID rqUID;

    private WorkCompPolicyQuoteInqRqDto workCompPolicyQuoteInqRqDto;
}

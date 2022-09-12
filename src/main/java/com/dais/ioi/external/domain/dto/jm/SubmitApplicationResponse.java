package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitApplicationResponse
{
    private String accountNumber;

    private BigDecimal totalPremium;

    private String policyNumber;

    private BigDecimal totalTaxAndSurcharge;

    private List<String> errorList;
}

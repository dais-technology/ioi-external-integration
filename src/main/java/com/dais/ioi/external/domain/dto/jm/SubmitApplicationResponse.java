package com.dais.ioi.external.domain.dto.jm;

import java.math.BigDecimal;
import java.util.List;

public class SubmitApplicationResponse
{
    private String accountNumber;

    private BigDecimal totalPremium;

    private String policyNumber;

    private BigDecimal totalTaxAndSurcharge;

    private List<String> errorList;
}

package com.dais.ioi.external.domain.dto.jm;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
public class SubmitApplicationRequest
{
    private UUID quoteId;

    private BigDecimal totalAmount;
}

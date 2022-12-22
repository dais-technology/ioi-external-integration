package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.external.domain.dto.BaseSourceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmitApplicationRequest
      extends BaseSourceDto
{
    //JM quoteId
    @NonNull
    private UUID quoteId;

    @NonNull
    private BigDecimal totalAmount;
}

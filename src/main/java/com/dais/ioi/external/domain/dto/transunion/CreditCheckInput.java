package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCheckInput
{
    @NonNull
    private UUID requestId;

    private UUID orgId;

    @NonNull
    private Map<String, Object> intake;
}

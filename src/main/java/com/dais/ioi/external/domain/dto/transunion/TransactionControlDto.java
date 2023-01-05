package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransactionControlDto
{

    private UUID userRefNumber;

    private SubscriberDto subscriber;

    private OptionsDto options;
}

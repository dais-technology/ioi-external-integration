package com.dais.ioi.external.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;
import java.util.UUID;


@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalQuoteDataDto
{
    private UUID id;

    private String externalQuoteId;

    //ioi-quote-service requestId;
    private UUID quoteId;

    private Map<String, ?> quoteData;

    private UUID clientId;
}

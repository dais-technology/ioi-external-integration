package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class JmQuoteOptionDto
{
    private UUID id;

    private UUID lineId;

    private UUID clientId;

    private QuoteDto quoteOption;

    private String intakeKey;

    private OffsetDateTime submissionDate;
}

package com.dais.ioi.external.domain.dto.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class JmStoreDto
{
    private ClientAnswerDto externalQuoteId;
}

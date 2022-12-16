package com.dais.ioi.external.domain.dto.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.LinkedHashMap;
import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
@EqualsAndHashCode( callSuper = true )
public class GetQuoteDto
      extends JmBaseDto
{
    private UUID lineId;

    private UUID clientId;

    private UUID organizationId;

    private LinkedHashMap<String, ClientAnswerDto> intake;
}

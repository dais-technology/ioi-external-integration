package com.dais.ioi.external.domain.dto.count;

import com.dais.ioi.external.domain.dto.internal.enums.CounterType;
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
public class CountDto
{
    private CounterType type;

    private CountForClient key;
}

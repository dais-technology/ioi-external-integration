package com.dais.ioi.external.domain.dto.count;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@JsonIgnoreProperties( ignoreUnknown = true )
public class CountForClient
{
    private UUID clientId;

    private String key;
}

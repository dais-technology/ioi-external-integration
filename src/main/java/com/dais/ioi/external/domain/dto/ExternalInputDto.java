package com.dais.ioi.external.domain.dto;


import lombok.Data;

import java.util.Map;
import java.util.UUID;

@Data
public class ExternalInputDto
{
    private String lineId;

    private Map<String, ?> payload;

}

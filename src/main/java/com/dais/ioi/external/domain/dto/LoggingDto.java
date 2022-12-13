package com.dais.ioi.external.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoggingDto
{
    private String name;

    private String description;

    private Map<String, ?> input;

    private Map<String, ?> output;
}

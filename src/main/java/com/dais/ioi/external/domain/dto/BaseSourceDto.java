package com.dais.ioi.external.domain.dto;

import com.dais.ioi.action.domain.dto.pub.TriggerSourceDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public abstract class BaseSourceDto
{
    private TriggerSourceDto source;
}

package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.action.domain.dto.pub.TriggerSourceDto;
import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JmBaseDto
{
    @NotNull
    private JmSource jmSource;

    private TriggerSourceDto source;
}

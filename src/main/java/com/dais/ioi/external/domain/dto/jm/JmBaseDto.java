package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.external.domain.dto.jm.enums.JmSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JmBaseDto
{
    private JmSource jmSource;
}

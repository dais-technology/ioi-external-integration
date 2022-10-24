package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProducerDto
{
    private ItemIdInfoDto itemIdInfoDto;

    private GeneralPartyInfoDto generalPartyInfoDto;
}

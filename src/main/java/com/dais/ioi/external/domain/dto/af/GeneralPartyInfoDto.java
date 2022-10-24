package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GeneralPartyInfoDto
{
    private NameInfoDto nameInfoDto;

    private AddrDto addrDto;

    private CommunicationsDto communicationsDto;

}

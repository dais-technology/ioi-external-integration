package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InsuredOrPrincipalDto
{
    @Builder.Default
    private String id = "n0";

    private GeneralPartyInfoDto generalPartyInfoDto;

}

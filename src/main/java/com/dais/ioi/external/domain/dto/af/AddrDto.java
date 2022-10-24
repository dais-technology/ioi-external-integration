package com.dais.ioi.external.domain.dto.af;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddrDto
{
    private String addrTypeCd;

    private String addr1;

    private String addr2;

    private String city;

    private String stateProvCd;

    private String postalCode;

    private String county;

    private String countryCode;
}

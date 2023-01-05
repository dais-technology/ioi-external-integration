package com.dais.ioi.external.domain.dto.smarty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZipCodeAddressDto
{

    private String zipCode;

    private String countryCode;

    private String stateCode;

    private Set<String> cities;

    private Set<String> counties;

    private String zipCodeType;
}

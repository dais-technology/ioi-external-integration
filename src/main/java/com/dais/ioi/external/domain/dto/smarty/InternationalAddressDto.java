package com.dais.ioi.external.domain.dto.smarty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InternationalAddressDto
{
    private String zipCode;

    private String country;

    private String address1;

    private String address2;

    private String locality;

    private String administrativeArea;
}

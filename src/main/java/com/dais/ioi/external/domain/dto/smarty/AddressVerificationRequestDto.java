package com.dais.ioi.external.domain.dto.smarty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVerificationRequestDto
{

    private String inputId;

    @NotEmpty
    private String address1;

    private String address2;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    private String zip;

    @NotEmpty
    private String country;
}

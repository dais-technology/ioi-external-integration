package com.dais.ioi.external.domain.dto.smarty;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVerificationRequest
{

    @JsonProperty( "input_id" )
    private String inputId;

    @NotEmpty
    private String street;

    private String secondary;

    @NotEmpty
    private String city;

    @NotEmpty
    private String state;

    private String zipcode;

    @NotEmpty
    @Builder.Default
    private String match = "invalid";
}

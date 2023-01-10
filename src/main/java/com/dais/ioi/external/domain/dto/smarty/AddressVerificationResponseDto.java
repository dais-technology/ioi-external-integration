package com.dais.ioi.external.domain.dto.smarty;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressVerificationResponseDto
{

    private String inputId;

    @Builder.Default
    @ApiModelProperty( "Whether the address was found and confirmed" )
    private boolean found = true;

    @Builder.Default
    @ApiModelProperty( "Whether the address was updated during verification" )
    private boolean updated = false;

    @Builder.Default
    @ApiModelProperty( "Whether the address is complete. An example of an incomplete address is one that is missing an apartment number." )
    private boolean complete = true;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String county;
}

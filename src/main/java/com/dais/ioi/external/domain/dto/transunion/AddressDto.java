package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddressDto
{
    @Builder.Default
    private String status = "current";

    private StreetDto street;

    private LocationDto location;

    @Builder.Default
    private String residence = "";
}

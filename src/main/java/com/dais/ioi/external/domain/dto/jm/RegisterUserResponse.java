package com.dais.ioi.external.domain.dto.jm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserResponse
{
    @JsonProperty( "status" )
    public String status;
}

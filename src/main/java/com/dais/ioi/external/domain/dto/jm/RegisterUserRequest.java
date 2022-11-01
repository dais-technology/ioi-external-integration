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
public class RegisterUserRequest
{
    @JsonProperty( "AccountNumber" )
    private Long accountNumber;

    @JsonProperty( "Applicant" )
    private Applicant applicant;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Applicant
    {
        @JsonProperty( "PortalPassword" )
        private String portalPassword;

        @JsonProperty( "Email" )
        private String email;

        @JsonProperty( "FirstName" )
        private String firstName;

        @JsonProperty( "LastName" )
        private String lastName;

        @JsonProperty( "ResidenceAddress" )
        private ResidenceAddress residenceAddress;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ResidenceAddress
    {
        @JsonProperty( "PostalCode" )
        private String postalCode;
    }
}

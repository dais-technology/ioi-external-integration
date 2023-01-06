package com.dais.ioi.external.domain.dto.jm;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude
public class GetEmbeddedQuoteResponse
{
    private Integer statusCode;

    private List<String> errorMessages;

    private Double totalPremiumWithTaxes;

    private Double totalTaxesAndSurcharges;

    private Double minimumPremium;

    private Double minimumTaxesAndSurcharges;

    private Applicant applicant;

    private List<JewelryItem> jeweleryItems;

    private List<ItemWiseRateInfo> itemWiseRateInfo;


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude
    public static class Applicant
    {
        private String phoneNumber;

        private String emailAddress;

        private String firstName;

        private String lastName;

        private String postalCode;

        private String county;

        private String state;

        private String country;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude
    public static class JewelryItem
    {
        private String itemId;

        private String jeweleryType;

        private Double itemValue;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude
    public static class ItemWiseRateInfo
    {
        private String itemId;

        private String jeweleryType;

        private List<RatingInfo> ratingInfo;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude
    public static class RatingInfo
    {
        private Double deductible;

        private Double itemPremiumWithTaxes;

        private Double itemTaxesAndSurcharges;
    }
}

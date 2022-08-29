package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuickQuoteResult
{
    public String externalOrderNumber;

    public int statusCode;

    public ArrayList<Object> errorMessages;

    public double totalPremiumWithTaxes;

    public double totalTaxesAndSurcharges;

    public ArrayList<ItemWiseRateInfo> itemWiseRateInfo;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemWiseRateInfo
    {
        public String itemId;

        public String jeweleryType;

        public ArrayList<RatingInfo> ratingInfo;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingInfo
    {
        public int deductible;

        public double itemPremiumWithTaxes;

        public double itemTaxesAndSurcharges;
    }
}




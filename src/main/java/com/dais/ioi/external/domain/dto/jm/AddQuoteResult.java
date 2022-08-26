package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AddQuoteResult
{

    public String quoteId;

    public int statusCode;

    public boolean isUnderwritingNeeded;

    public boolean isCoverageAvailable;

    public ArrayList<Object> errorMessages;

    public RatingInfo ratingInfo;

    public ArrayList<PaymentPlan> paymentPlans;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ItemRateDetail
    {
        public int itemNumber;

        public ArrayList<RateOption> rateOptions;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PaymentPlan
    {
        public double downPaymentAmount;

        public int installmentAmount;

        public int serviceFee;

        public double downPaymentTax;

        public int installmentTax;

        public String name;

        public int numberOfInstallments;

        public ArrayList<Schedule> schedules;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateBreakdown
    {
        public String rateType;

        public double rateValue;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RateOption
    {
        public int deductible;

        public ArrayList<RateBreakdown> rateBreakdown;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RatingInfo
    {
        public double totalPremium;

        public double totalTaxesAndSurcharges;

        public int minimumPremium;

        public double minimumTaxesAndSurcharges;

        public ArrayList<ItemRateDetail> itemRateDetails;
    }



    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Schedule
    {
        public Date paymentDueDate;

        public boolean isDownPayment;

        public double totalAmount;

        public int downPaymentAmount;

        public int installmentAmount;

        public int installmentFee;

        public double taxesSurcharges;
    }
}

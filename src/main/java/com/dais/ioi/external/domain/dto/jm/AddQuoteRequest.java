package com.dais.ioi.external.domain.dto.jm;// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;


@Data
@Builder
public class AddQuoteRequest
{

    @JsonProperty( "QuoteId" )
    public Object quoteId;

    @JsonProperty( "PrimaryContact" )
    public PrimaryContact primaryContact;

    @JsonProperty( "JeweleryItems" )
    public ArrayList<JeweleryItem> jeweleryItems;

    @JsonProperty( "EffectiveDate" )
    public String effectiveDate;

    @JsonProperty( "ProducerCode" )
    public String producerCode;

    @JsonProperty( "HasPaperlessDelivery" )
    public boolean hasPaperlessDelivery;

    @JsonProperty( "ConsentToCredit" )
    public boolean consentToCredit;

    @JsonProperty( "ApplicationTakenBy" )
    public Object applicationTakenBy;

    public UnderwritingInfo underwritingInfo;

    @JsonProperty( "deductibleOptions" )

    public ArrayList<DeductibleOption> deductibleOptions;

    @JsonProperty( "selectedPaymentPlan" )
    public SelectedPlan selectedPaymentPlan;

    @JsonProperty( "User" )
    public User user;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class JeweleryItem
    {
        @JsonProperty( "JeweleryType" )
        public String jeweleryType;

        @JsonProperty( "JewelerySubType" )
        public String jewelerySubType;

        @JsonProperty( "ItemValue" )
        public int itemValue;

        @JsonProperty( "ItemNumber" )
        public int itemNumber;

        @JsonProperty( "ItemDamage" )
        private String itemDamage;

        @JsonProperty( "LastAppraisalDate" )
        public String lastAppraisalDate;

        @JsonProperty( "SerialNumber" )
        public String serialNumber;

        @JsonProperty( "ItemPossession" )
        private String itemPossession;

        @JsonProperty( "ItemDescription" )
        public String itemDescription;

        @JsonProperty( "PrimaryWearer" )
        public PrimaryWearer primaryWearer;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class LossHistoryEvent
    {
        @JsonProperty( "LossType" )
        public String lossType;

        @JsonProperty( "Amount" )
        public Double amount;

        @JsonProperty( "LossDate" )
        public String lossDate;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PrimaryContact
    {
        @JsonProperty( "FirstName" )
        public String firstName;

        @JsonProperty( "LastName" )
        public String lastName;

        @JsonProperty( "Gender" )
        public Object gender;

        @JsonProperty( "DateOfBirth" )
        public String dateOfBirth;

        @JsonProperty( "EmailAddress" )
        public String emailAddress;

        @JsonProperty( "PhoneNumber" )
        public String phoneNumber;

        @JsonProperty( "ResidentialAddress" )
        public ResidentialAddress residentialAddress;

        @JsonProperty( "MailingAddress" )
        public ResidentialAddress mailingAddress;

        @JsonProperty( "ContactPreference" )
        public Object contactPreference;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PrimaryWearer
    {
        @JsonProperty( "FirstName" )
        public String firstName;

        @JsonProperty( "LastName" )
        public String lastName;

        @JsonProperty( "Gender" )
        public String gender;

        @JsonProperty( "DateOfBirth" )
        public String dateOfBirth;

        @JsonProperty( "EmailAddress" )
        public String emailAddress;

        @JsonProperty( "PhoneNumber" )
        public Object phoneNumber;

        @JsonProperty( "ResidentialAddress" )
        public ResidentialAddress residentialAddress;

        @JsonProperty( "MailingAddress" )
        public ResidentialAddress mailingAddress;

        @JsonProperty( "ContactPreference" )
        public Object contactPreference;

        @JsonProperty( "RelationWithApplicant" )
        public String relationWithApplicant;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class ResidentialAddress
    {
        public String address1;

        public String address2;

        public String city;

        public String country;

        public String county;

        public String state;

        public String postalCode;
    }



    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UnderwritingInfo
    {
        public ArrayList<UnderwritingQuestion> underwritingQuestions;

        @JsonProperty( "LossHistoryEvents" )
        public ArrayList<LossHistoryEvent> lossHistoryEvents;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class UnderwritingQuestion
    {
        @JsonProperty( "Key" )
        public String key;

        @JsonProperty( "Value" )
        public Object value;
    }


    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class DeductibleOption
    {
        @JsonProperty( "itemNumber" )
        public int itemNumber;

        @JsonProperty( "deductible" )
        public Double deductible;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class SelectedPlan
    {
        @JsonProperty( "name" )
        public String name;

        @JsonProperty( "numberOfInstallments" )
        public int numberOfInstallments;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class User
    {
        @JsonProperty( "UserId" )
        public String userId;

        @JsonProperty( "UserFirstName" )
        public String userFirstName;

        @JsonProperty( "UserLastName" )
        public String userLastName;

        @JsonProperty( "UserEmailAddress" )
        public String userEmailAddress;

        @JsonProperty( "UserPhoneNumber" )
        public String userPhoneNumber;
    }
}


package com.dais.ioi.external.domain.dto.jm;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddQuoteRequest
{
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

    @JsonProperty( "ApplicationTakenBy" )
    public Object applicationTakenBy;

    @JsonProperty( "UnderwritingQuestions" )
    public ArrayList<UnderwritingQuestion> underwritingQuestions = new ArrayList<>();

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
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

        @JsonProperty( "PrimaryWearer" )
        public PrimaryWearer primaryWearer;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PrimaryContact
    {
        @JsonProperty( "FirstName" )
        public String firstName;

        @JsonProperty( "LastName" )
        public String lastName;

        @JsonProperty( "DateOfBirth" )
        public String dateOfBirth;

        @JsonProperty( "EmailAddress" )
        public String emailAddress;

        @JsonProperty( "PhoneNumber" )
        public String phoneNumber;

        @JsonProperty( "ResidentialAddress" )
        public ResidentialAddress residentialAddress;

        @JsonProperty( "MailingAddress" )
        public Object mailingAddress;

        @JsonProperty( "ContactPreference" )
        public Object contactPreference;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
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
        public String phoneNumber;

        @JsonProperty( "ResidentialAddress" )
        public ResidentialAddress residentialAddress;

        @JsonProperty( "MailingAddress" )
        public Object mailingAddress;

        @JsonProperty( "ContactPreference" )
        public Object contactPreference;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
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
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UnderwritingQuestion
    {
        @JsonProperty( "Key" )
        public String key;

        @JsonProperty( "Value" )
        public String value;
    }
}

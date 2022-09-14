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
import java.util.Date;


@Data
@Builder
public class AddQuoteRequest {

    @JsonProperty("QuoteId")
    public Object quoteId;
    @JsonProperty("PrimaryContact")
    public PrimaryContact primaryContact;
    @JsonProperty("JeweleryItems")
    public ArrayList<JeweleryItem> jeweleryItems;
    @JsonProperty("EffectiveDate")
    public String effectiveDate;
    @JsonProperty("ProducerCode")
    public String producerCode;
    @JsonProperty("HasPaperlessDelivery")
    public boolean hasPaperlessDelivery;
    @JsonProperty("ApplicationTakenBy")
    public Object applicationTakenBy;
    public UnderwritingInfo underwritingInfo;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder

public static class JeweleryItem{



    @JsonProperty("JeweleryType")
    public String jeweleryType;
    @JsonProperty("JewelerySubType")
    public String jewelerySubType;
    @JsonProperty("ItemValue")
    public int itemValue;
    @JsonProperty("ItemNumber")
    public int itemNumber;
    @JsonProperty("ItemDamage")
    private String itemDamage;
    @JsonProperty("ItemPossession")
    private String itemPossession;
    @JsonProperty("PrimaryWearer")
    public PrimaryWearer primaryWearer;
}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public static class LossHistoryEvent{
    @JsonProperty("LossType")
    public String lossType;
    @JsonProperty("Amount")
    public int amount;
    @JsonProperty("LossDate")
    public Date lossDate;
}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public static class PrimaryContact{
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("Gender")
    public Object gender;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("EmailAddress")
    public String emailAddress;
    @JsonProperty("PhoneNumber")
    public String phoneNumber;
    @JsonProperty("ResidentialAddress")
    public ResidentialAddress residentialAddress;
    @JsonProperty("MailingAddress")
    public Object mailingAddress;
    @JsonProperty("ContactPreference")
    public Object contactPreference;
}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public static class PrimaryWearer{
    @JsonProperty("FirstName")
    public String firstName;
    @JsonProperty("LastName")
    public String lastName;
    @JsonProperty("Gender")
    public String gender;
    @JsonProperty("DateOfBirth")
    public String dateOfBirth;
    @JsonProperty("EmailAddress")
    public String emailAddress;
    @JsonProperty("PhoneNumber")
    public Object phoneNumber;
    @JsonProperty("ResidentialAddress")
    public ResidentialAddress residentialAddress;
    @JsonProperty("MailingAddress")
    public Object mailingAddress;
    @JsonProperty("ContactPreference")
    public Object contactPreference;
}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public static class ResidentialAddress{
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
public static class UnderwritingInfo{
    public ArrayList<UnderwritingQuestion> underwritingQuestions;
    @JsonProperty("LossHistoryEvents")
    public ArrayList<LossHistoryEvent> lossHistoryEvents;
}
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
public static class UnderwritingQuestion{
    @JsonProperty("Key")
    public String key;
    @JsonProperty("Value")
    public Object value;
}

}


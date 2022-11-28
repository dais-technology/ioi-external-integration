package com.dais.ioi.external.domain.dto.spec;

import lombok.Data;


@Data
public class ActionJMSQuoteSpecDto
{
    // Auth fields

    private String authUrl;

    private String userName;

    private String clientId;

    private String clientSecret;

    private String clientPassword;

    private String apiSubscriptionkey;

    private String quickQuoteUrl;

    private String addQuoteUrl;

    private String updateQuoteUrl;

    // Quick Quote fields
    private String county;

    private String state;

    private String zip;

    private String orderNumber;

    private String itemId;

    private String itemType;

    private String itemSubType;

    private String itemGender;


    private String itemValue;

    private String itemLoop;

    //Add quote fields

    private String customerInfoReferralSource;

    private String customerInfoAgencyExpressOptions;

    private String primaryContactFirstName;

    private String primaryContactLastName;

    private String primaryContactGender;

    private String primaryContactDob;

    private String primaryContactEmail;

    private String primaryContactPhoneNumber;

    private String primaryContactResAddr1;

    private String primaryContactResAddr2;

    private String primaryContactResAddrCity;

    private String primaryContactResAddrCountry;

    private String primaryContactResAddrCounty;

    private String primaryContactResAddrState;

    private String primaryContactResAddrPostalCode;


    private String primaryWearerFirstName;

    private String primaryWearerLastName;

    private String primaryWearerGender;

    private String primaryWearerDob;

    private String primaryWearerEmail;

    private String primaryWearerPhoneNumber;

    private String primaryWearerResAddr1;

    private String primaryWearerResAddr2;

    private String primaryWearerResAddrCity;

    private String primaryWearerResAddrCountry;

    private String primaryWearerResAddrCounty;

    private String primaryWearerResAddrState;

    private String primaryWearerResAddrPostalCode;

    private String primaryWearerRelationWithApplicant;

    private String hasMailingAddr;

    private String primaryContactMailingAddrCity;

    private String primaryContactMailingAddr1;

    private String primaryContactMailingAddr2;

    private String primaryContactMailingAddrPostalCode;

    private String primaryContactMailingAddrCounty;

    private String primaryContactMailingAddrState;

    private String consentToCredit;

    private String felonyConviction;

    private String lostWithin7Years;

    private String misdemeanorConviction;

    private String crimeForProfit;

    private String canceledOrDeniedCoverage;

    private String coverageDenyReason;

    private String additionalUnderwriting;

    private String alarmId;

    private String convictionType;

    private String convictionSentenceCompletionDate;

    private String storeJewelryInSafeDepositBox;

    private String safeDepositBoxLocation;

    private String livesInGatedEntranceCommunity;

    private String communityHasFence;

    private String communityHasGuardsAtGate;

    private String communityGuardsFrequency;

    private String communityIsPatrolled;

    private String communityPatrolFrequency;

    private String communityResidentEntranceDescription;

    private String communityResidentEntranceDescriptionOther;

    private String communityGuestEntranceDescription;

    private String communityGuestEntranceDescriptionOther;

    private String domesticHelpEmployed;

    private String domesticHelpDescription;

    private String domesticHelpDescriptionOther;

    private String domesticHelpEmploymentLength;

    private String domesticHelpResidesAtHome;

    private String domesticHelpVisitFrequency;

    private String homeHasOtherResidents;

    private String homeOtherResidentsDescription;

    private String howOftenJewelryWorn;

    private String travelOvernightFrequency;

    private String travelOverseas;

    private String travelPrecautionOption;

    private String travelPrecautionOtherDescription;

    private String hasPaperlessDelivery;

    private String itemDamage;

    private String itemPossession;

    private String itemDescription;

    private String lastAppraisalDate;

    private String serialNumber;

    private String deductible;

    private String effectiveDate;

    private String lostTheftDamageLoop;

    private String typeOfLoss;

    private String amountOfLoss;

    private String dateOfLoss;
}

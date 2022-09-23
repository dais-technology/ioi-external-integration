package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.util.NormalizedPremium;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.enums.AmountType;
import com.dais.ioi.quote.domain.dto.enums.QuoteType;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDetailDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoveragesDto;
import com.dais.ioi.quote.domain.dto.pub.PubExternalDataDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumTaxesDto;
import com.dais.ioi.quote.domain.dto.pub.PubQuoteDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;



@Service
@Slf4j
public class JMAddQuoteHelperImpl
{
    public static final DateTimeFormatter EFFECTIVE_DATE_FORMAT = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );

    private final JMQuoteClient jmQuoteClient;

    private final ObjectMapper objectMapper;

    public JMAddQuoteHelperImpl( @Autowired final JMQuoteClient jmQuoteClient,
                                 @Autowired final ObjectMapper objectMapper)
    {
        this.jmQuoteClient = jmQuoteClient;
        this.objectMapper = objectMapper;
    }


    public TriggerResponseDto processAddQuote( FiredTriggerDto firedTriggerDto,
                                 JMAuthResult jmAuthResult ,
                                 ActionJMSQuoteSpecDto actionJMSQuoteSpecDto)
          throws  Exception
    {

        final UUID requestId = null == firedTriggerDto.getTriggerRequestId() ? UUID.randomUUID() : firedTriggerDto.getTriggerRequestId();

        String externalQuoteId = (String) firedTriggerDto.getPayload().get( "externalQuoteId");

        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );

        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto );

        final String effectiveDateAnswer = triggerSpec.getIntake().get( actionJMSQuoteSpecDto.getEffectiveDate() ).getAnswer();

        final LocalDate effectiveDate = OffsetDateTime.parse( effectiveDateAnswer ).toLocalDate();

        addQuoteRequest.setEffectiveDate( effectiveDate.format( EFFECTIVE_DATE_FORMAT ) );


// If the external quote id is sent, its treated as exclusively for upating
        if ( externalQuoteId != null && !externalQuoteId.equalsIgnoreCase( "" ))
        {
            URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getUpdateQuoteUrl());

            addQuoteRequest.setQuoteId( externalQuoteId );

            String planName = getValue( () -> ((Map)firedTriggerDto.getPayload().get( "selectedPaymentPlan" )).get( "name" ).toString(), "");

            Integer numberOfInstallments = Integer.parseInt(   getValue( () -> ((Map)firedTriggerDto.getPayload().get( "selectedPaymentPlan" )).get( "numberOfInstallments" ).toString(), "") );

            addPaymentPlan(addQuoteRequest, planName, numberOfInstallments);

            log.info(objectMapper.writeValueAsString( addQuoteRequest ));

            AddQuoteResult updQuoteResult = jmQuoteClient.updateQuote( determinedBasePathUri,
                                                                       "Bearer " + jmAuthResult.getAccess_token(),
                                                                       actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                       addQuoteRequest );

            if ( getValue( ()-> updQuoteResult.getErrorMessages().size(),0 ) > 0) {

                String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );

                throw new Exception(errorMessage);

            }

            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

            HashMap<String, Object> idMap = new HashMap<>();

            idMap.put( "externalQuoteId", externalQuoteId );

            triggerResponseDto.setTriggerRequestId( requestId );

            triggerResponseDto.setMetadata(idMap);

            return triggerResponseDto;

        }


        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getAddQuoteUrl());

        log.info(objectMapper.writeValueAsString( addQuoteRequest ));




            AddQuoteResult addQuoteResult = jmQuoteClient.addQuote( determinedBasePathUri,
                                                                    "Bearer " + jmAuthResult.getAccess_token(),
                                                                    actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                    addQuoteRequest );


// This block will be hit if there is no coverage and the http response is 200
            if (addQuoteResult.isCoverageAvailable == false ) {

                TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

                HashMap<String, Object> metaDatamap = new HashMap<>();

                metaDatamap.put( "isUnderwritingNeeded" ,addQuoteResult.isUnderwritingNeeded());
                metaDatamap.put( "isCoverageAvailable" ,addQuoteResult.isCoverageAvailable());

                log.info("setting request Id to " + requestId);
                triggerResponseDto.setTriggerRequestId( requestId );

                triggerResponseDto.setMetadata(metaDatamap);

                return triggerResponseDto;
            }

            externalQuoteId = addQuoteResult.getQuoteId();

            if ( getValue( () -> addQuoteResult.getErrorMessages().size(), 0 ) > 0 )
            {
                String errorMessage = addQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
                throw new Exception( errorMessage );
            }



        addQuoteRequest.setQuoteId( externalQuoteId );

        determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getUpdateQuoteUrl());

        AddQuoteResult updQuoteResult = jmQuoteClient.updateQuote( determinedBasePathUri,
                                                                "Bearer " + jmAuthResult.getAccess_token(),
                                                                actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                addQuoteRequest );

        if ( getValue( ()-> updQuoteResult.getErrorMessages().size(),0 ) > 0) {
            String errorMessage = updQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
            throw new Exception(errorMessage);

        }


        PubQuoteDetailsDto quoteDetails = getQuoteDetails( updQuoteResult );

        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

        HashMap<String, Object> metaDatamap = new HashMap<>();
        metaDatamap.put( "ratePlans", updQuoteResult.getPaymentPlans() );
        metaDatamap.put( "isUnderwritingNeeded" ,addQuoteResult.isUnderwritingNeeded());
        metaDatamap.put( "isCoverageAvailable" ,addQuoteResult.isCoverageAvailable());


        QuoteDto newQuote = QuoteDto.builder()
                                  /*  .actionId( firedTriggerDto.actionEntity.getId() )
                                    .pipelineId( firedTriggerDto.triggerEntity.getPipeline().getId() )
                                    .quotingOrganizationId( firedTriggerDto.triggerEntity.getPipeline().getOrganizationId() )
                                    .triggerRequestId( firedTriggerDto.triggerResponse.getTriggerRequestId() )
                                    .bundleId( firedTriggerDto.firedTrigger.getBundleId() )
                                    .lineId( firedTriggerDto.line.getId() )
                                    .source( firedTriggerDto.firedTrigger.getSource() )*/
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .quoteTimestamp( OffsetDateTime.now() )
                                    .source( firedTriggerDto.getSource() )
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .type( QuoteType.QUOTE )
                                    .clientId( triggerSpec.getClientId() )
                                    .requestId( requestId )
                                    .effectiveDate( effectiveDate )
                                    .bindable( true )
                                    .quoteDetails( quoteDetails )
                                    .metadata( metaDatamap)
                                    .build();

        triggerResponseDto.getMetadata().put( requestId.toString(),  newQuote );

        triggerResponseDto.setTriggerRequestId( requestId );

        return triggerResponseDto;
    }


    // Add Quote Methods
    private AddQuoteRequest createAddQuoteRequest( LinkedHashMap<String, ClientAnswerDto> intake,
                                                   ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        AddQuoteRequest addQuoteRequest = AddQuoteRequest.builder().build();

        addProducerCode(addQuoteRequest,actionJMSQuoteSpecDto,intake);

        addPaperLessOption( addQuoteRequest,actionJMSQuoteSpecDto,intake );

        AddQuoteRequest.PrimaryContact primaryContact = new AddQuoteRequest.PrimaryContact();
        AddQuoteRequest.ResidentialAddress residentialAddress = new AddQuoteRequest.ResidentialAddress();

        //Map primary contact
        primaryContact.setFirstName(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryWearerFirstName() ).getAnswer(), "" )
        );
        primaryContact.setLastName(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactLastName() ).getAnswer(), "" )
        );
        primaryContact.setDateOfBirth(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactDob() ).getAnswer(), "" )
        );
        primaryContact.setEmailAddress(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactEmail() ).getAnswer(), "" )
        );
        primaryContact.setPhoneNumber(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactPhoneNumber() ).getAnswer(), "" )
        );
        // Map residential address
        residentialAddress.setAddress1(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddr1() ).getAnswer(), "" )
        );
        residentialAddress.setAddress2(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddr2() ).getAnswer(), "" )
        );
        residentialAddress.setCity(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCity() ).getAnswer(), "" )
        );
        residentialAddress.setCountry(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCountry() ).getAnswer(), "" )
        );
        residentialAddress.setCounty(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrCounty() ).getAnswer(), "" )
        );
        residentialAddress.setState(
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrState() ).getAnswer(), "" )
        );
        residentialAddress.setPostalCode(
            JMUtils.formatZipCode(   getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrPostalCode() ).getAnswer(), "" ) )
        );

        primaryContact.setResidentialAddress( residentialAddress );

        addQuoteRequest.setPrimaryContact( primaryContact );

        processUnderWriting( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        processAddQuoteIteration( addQuoteRequest, intake.get( actionJMSQuoteSpecDto.getItemLoop()).getIterations(), actionJMSQuoteSpecDto );

        return addQuoteRequest;
    }


    private void processUnderWriting( AddQuoteRequest addQuoteRequest,
                                      LinkedHashMap<String, ClientAnswerDto> intake,
                                      ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {

        AddQuoteRequest.UnderwritingInfo underwritingInfo = new AddQuoteRequest.UnderwritingInfo();
        underwritingInfo.setUnderwritingQuestions( new ArrayList<>() );
        underwritingInfo.setLossHistoryEvents( new ArrayList<>() );

        AddQuoteRequest.UnderwritingQuestion felony = new AddQuoteRequest.UnderwritingQuestion();
        felony.setKey( "felonyConviction" );
        felony.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getFelonyConviction() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( felony );

        AddQuoteRequest.UnderwritingQuestion lostWithin7Years = new AddQuoteRequest.UnderwritingQuestion();
        lostWithin7Years.setKey( "lostWithin7Years" );
        lostWithin7Years.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getLostWithin7Years() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( lostWithin7Years );

        AddQuoteRequest.UnderwritingQuestion misdemeanor = new AddQuoteRequest.UnderwritingQuestion();
        misdemeanor.setKey( "misdemeanorConviction" );
        misdemeanor.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getMisdemeanorConviction() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( misdemeanor );

        AddQuoteRequest.UnderwritingQuestion crimeForProfit = new AddQuoteRequest.UnderwritingQuestion();
        crimeForProfit.setKey( "crimeForProfit" );
        crimeForProfit.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCrimeForProfit() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( crimeForProfit );

        AddQuoteRequest.UnderwritingQuestion cancelledCoverage = new AddQuoteRequest.UnderwritingQuestion();
        cancelledCoverage.setKey( "canceledOrDeniedCoverage" );
        cancelledCoverage.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCanceledOrDeniedCoverage() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( cancelledCoverage );

        AddQuoteRequest.UnderwritingQuestion additionalUnderwriting = new AddQuoteRequest.UnderwritingQuestion();
        additionalUnderwriting.setKey( "IsAdditionalUnderwritingNeeded" );
        additionalUnderwriting.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getAdditionalUnderwriting() ).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( additionalUnderwriting );


        AddQuoteRequest.UnderwritingQuestion alarmId = new AddQuoteRequest.UnderwritingQuestion();
        alarmId.setKey( "AlarmId");
        alarmId.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getAlarmId()).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( alarmId );

     /*   AddQuoteRequest.UnderwritingQuestion convictionType = new AddQuoteRequest.UnderwritingQuestion();
        convictionType.setKey( "ConvictionType");
        convictionType.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getConvictionType()).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( convictionType );

        AddQuoteRequest.UnderwritingQuestion convictionSentenceCompletionDate = new AddQuoteRequest.UnderwritingQuestion();
        convictionSentenceCompletionDate.setKey( "ConvictionSentenceCompletionDate");
        convictionSentenceCompletionDate.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getConvictionSentenceCompletionDate()).getAnswer(), "" ) );
        underwritingInfo.getUnderwritingQuestions().add( convictionSentenceCompletionDate );*/


        addQuoteRequest.setUnderwritingInfo( underwritingInfo );


    }


    private void processAddQuoteIteration( AddQuoteRequest addQuoteRequest,
                                           List<ClientLoopIterationDto> iterations,
                                           ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        ArrayList<AddQuoteRequest.JeweleryItem> jeweleryItems = new ArrayList<>();
        int itemNumber = 1;
        ArrayList<AddQuoteRequest.DeductibleOption> deductibleOptions = new ArrayList<>();
        for ( ClientLoopIterationDto clientLoopIterationDto : iterations )
        {
            AddQuoteRequest.JeweleryItem item = new AddQuoteRequest.JeweleryItem();


            item.setJeweleryType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemType() ).getAnswer().toLowerCase(), "" ).toString()
            );
            item.setJewelerySubType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemSubType() ).getAnswer(), "" ).toString()
            );

            item.setItemNumber(
                  itemNumber
            );
            item.setItemValue(
                  Integer.parseInt( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer(), "" ).toString() )
            );
          /*  item.setItemDamage(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemDamage() ).getAnswer(), "" ).toString()
            );
            item.setItemPossession(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemPossession() ).getAnswer(), "" ).toString()
            );*/
            // Remove after questions answered
           // item.setItemDamage( "no" );
            //   item.setItemPossession( "yes" );
            //
            AddQuoteRequest.PrimaryWearer primaryWearer = new AddQuoteRequest.PrimaryWearer();

            primaryWearer.setLastName(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerLastName() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setFirstName(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerFirstName() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setPhoneNumber(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerPhoneNumber() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setDateOfBirth(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerDob() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setEmailAddress(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerEmail() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setPhoneNumber(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerPhoneNumber() ).getAnswer(), "" ).toString()
            );

            primaryWearer.setGender(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemGender()).getAnswer(), "" ).toString()

            );

            AddQuoteRequest.ResidentialAddress primaryWearerResidentialAddress = new AddQuoteRequest.ResidentialAddress();

            primaryWearerResidentialAddress.setAddress1(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddr1() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setAddress2(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddr2() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setCity(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCity() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setCountry(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCountry() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setCounty(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrCountry() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setState(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrState() ).getAnswer(), "" )
            );
            primaryWearerResidentialAddress.setPostalCode(
                JMUtils.formatZipCode(    getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrPostalCode() ).getAnswer(), "" ) )
            );

            AddQuoteRequest.DeductibleOption deductibleOption = new AddQuoteRequest.DeductibleOption();

            deductibleOption.setDeductible(
                  Double.parseDouble(  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getDeductible() ).getAnswer(), "0" ) )
            );

            deductibleOption.setItemNumber(
                 itemNumber
            );

            deductibleOptions.add( deductibleOption );


            primaryWearer.setResidentialAddress( primaryWearerResidentialAddress );
            item.setPrimaryWearer( primaryWearer );
            jeweleryItems.add( item );
            itemNumber++;
        }
        addQuoteRequest.setDeductibleOptions( deductibleOptions );
        addQuoteRequest.setJeweleryItems( jeweleryItems );
    }

    private void addPaymentPlan(AddQuoteRequest addQuoteRequest, String name, int installments ) {

        AddQuoteRequest.SelectedPlan selectedPlan = new AddQuoteRequest.SelectedPlan();
        selectedPlan.setName( name );
        selectedPlan.setNumberOfInstallments( installments );
        addQuoteRequest.setSelectedPaymentPlan( selectedPlan );
    }
    private void addProducerCode( AddQuoteRequest addQuoteRequest, ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,  LinkedHashMap<String, ClientAnswerDto> intake ) {

        String producerCode = "";

        String customerInfoReferralSource =  getValue( () -> intake.get( actionJMSQuoteSpecDto.getCustomerInfoReferralSource() ).getAnswer(), "" );

        if ( customerInfoReferralSource.equalsIgnoreCase( "Agency Express" )) {
            producerCode =  getValue( () -> intake.get( actionJMSQuoteSpecDto.getCustomerInfoAgencyExpressOptions() ).getAnswer(), "" );
        }
        else {
            producerCode = customerInfoReferralSource;
        }

        if (producerCode.equalsIgnoreCase( "" )) {
            producerCode = "DIRD";
        }
        addQuoteRequest.setProducerCode( producerCode);

    }

    private void addPaperLessOption( AddQuoteRequest addQuoteRequest, ActionJMSQuoteSpecDto actionJMSQuoteSpecDto,  LinkedHashMap<String, ClientAnswerDto> intake ) {

        boolean paperlessOption = false;

        String hasPaperlessDelivery =  getValue( () -> intake.get( actionJMSQuoteSpecDto.getHasPaperlessDelivery() ).getAnswer(), "" );

        if ( hasPaperlessDelivery.equalsIgnoreCase( "yes" )) {
            paperlessOption =  true;
        }

        addQuoteRequest.setHasPaperlessDelivery( paperlessOption);

    }




    private PubQuoteDetailsDto getQuoteDetails( AddQuoteResult addQuoteResult )
    {
        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        PubPremiumDto.PubPremiumDtoBuilder premiumBuilder = PubPremiumDto.builder();

        final NormalizedPremium normalizedPremium = new NormalizedPremium( addQuoteResult.ratingInfo );

        premiumBuilder.amount( normalizedPremium.getPremiumOnly() );

        premiumBuilder.taxesAndFees( Arrays.asList( PubPremiumTaxesDto.builder()
                                                                      .amount( normalizedPremium.getTotalTaxesAndSurcharges() )
                                                                      .type( "Taxes and Surcharges" ).build(),
                                                    PubPremiumTaxesDto.builder()
                                                                      .amount( normalizedPremium.getDiscount() )
                                                                      .type( "Discount" ).build() ) );

        quoteBuilder.premium( premiumBuilder.build() );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        addQuoteResult.getRatingInfo().getItemRateDetails().forEach( itemRateDetail -> {

            PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

            pubCoveragesBuilder.type( "todo" );

            String itemId = String.valueOf( itemRateDetail.getItemNumber() );

            List<PubCoverageDto> coverages = getPubCoverages( itemRateDetail, itemId );

            pubCoveragesBuilder.coverages( coverages );

            pubCoverages.add( pubCoveragesBuilder.build() );
        } );
        quoteBuilder.coverageTypes( pubCoverages );

        PubExternalDataDto.PubExternalDataDtoBuilder externalDataBuilder = PubExternalDataDto.builder();

        externalDataBuilder.externalQuoteId( addQuoteResult.getQuoteId() );

       quoteBuilder.externalData( externalDataBuilder.build() );

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
    }


    private List<PubCoverageDto> getPubCoverages( AddQuoteResult.ItemRateDetail itemRateDetail,
                                                  String itemId )
    {
        PubCoveragesDto.PubCoveragesDtoBuilder builder = PubCoveragesDto.builder();
        builder.type( "todo" );

        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            PubCoverageDto.PubCoverageDtoBuilder pubCoverageBuilder = PubCoverageDto.builder();
            BigDecimal premium = new BigDecimal( rateOption.getRateBreakdown().get( 0 ).getRateValue() ).setScale( 2, RoundingMode.HALF_EVEN );
            pubCoverageBuilder.premium( premium );
            Map<String, List<PubCoverageDetailDto>> details = new HashMap<>();

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder deductibleBuilder = PubCoverageDetailDto.builder();
            deductibleBuilder.amountType( AmountType.DOLLAR );
            deductibleBuilder.amount( ( (Integer) rateOption.getDeductible() ).toString() );
            details.put( "deductible", Collections.singletonList( deductibleBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemTaxesAndSurchargesBuilder = PubCoverageDetailDto.builder();
            itemTaxesAndSurchargesBuilder.amountType( AmountType.DOLLAR );
            itemTaxesAndSurchargesBuilder.amount( ( (Double) rateOption.getRateBreakdown().get( 1 ).getRateValue() ).toString() );
            details.put( "itemTaxesAndSurcharges", Collections.singletonList( itemTaxesAndSurchargesBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemIdBuilder = PubCoverageDetailDto.builder();
            itemIdBuilder.amountType( AmountType.TEXT );
            itemIdBuilder.amount( itemId );
            details.put( "itemId", Collections.singletonList( itemIdBuilder.build() ) );

            pubCoverageBuilder.details( details );
            coverages.add( pubCoverageBuilder.build() );
        }
        return coverages;
    }
}

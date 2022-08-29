package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
// import com.dais.ioi.action.model.ActionPayload;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.enums.AmountType;
import com.dais.ioi.quote.domain.dto.enums.QuoteType;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDetailDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoveragesDto;
import com.dais.ioi.quote.domain.dto.pub.PubExternalDataDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumDto;
import com.dais.ioi.quote.domain.dto.pub.PubQuoteDetailsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;



@Service
public class JMAddQuoteHelperImpl
{
  //  @Autowired
  //  JMQuoteClient jmQuoteClient;

    @Autowired
    JMAuthClient jmAuthClient;


    @Autowired
    private ObjectMapper objectMapper;

/*
    public void processAddQuote( ActionPayload ap,
                                 JMAuthResult jmAuthResult )
    {
        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( ap.firedTrigger.getPayload(), QuoteRequestSpecDto.class );

        ActionJMSQuoteSpecDto actionJMSQuoteSpecDto = objectMapper.convertValue( ap.actionEntity.getSpec(), ActionJMSQuoteSpecDto.class );

        AddQuoteRequest addQuoteRequest = createAddQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto );

        AddQuoteResult addQuoteResult = jmQuoteClient.addQuote( "Bearer " + jmAuthResult.getAccess_token(), jmSubscriptionKey, addQuoteRequest );

        PubQuoteDetailsDto quoteDetails = getQuoteDetails( addQuoteResult );

        QuoteDto newQuote = QuoteDto.builder()
                                    .actionId( ap.actionEntity.getId() )
                                    .pipelineId( ap.triggerEntity.getPipeline().getId() )
                                    .quotingOrganizationId( ap.triggerEntity.getPipeline().getOrganizationId() )
                                    .triggerRequestId( ap.triggerResponse.getTriggerRequestId() )
                                    .quoteTimestamp( OffsetDateTime.now() )
                                    .bundleId( ap.firedTrigger.getBundleId() )
                                    .lineId( ap.line.getId() )
                                    .source( ap.firedTrigger.getSource() )
                                    .clientOrganizationId( ap.firedTrigger.getSource().getOrganizationId() )
                                    .type( QuoteType.QUOTE )
                                    .clientId( triggerSpec.getClientId() )
                                    //      .requestId( requestId )
                                    //      .effectiveDate( effectiveDate )
                                    //      .bindable( spec.isRatable() )
                                    .quoteDetails( quoteDetails )
                                    .metadata( Collections.singletonMap( "ratePlans", addQuoteResult.getPaymentPlans() ) )

                                    //  .metadata( paymentPlans )
                                    //      .messages( messages )
                                    .build();

        ap.triggerResponse.getMetadata().put( ap.actionEntity.getId().toString(), newQuote );
    }


    // Add Quote Methods
    private AddQuoteRequest createAddQuoteRequest( LinkedHashMap<String, ClientAnswerDto> intake,
                                                   ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        AddQuoteRequest addQuoteRequest = AddQuoteRequest.builder().build();

        addQuoteRequest.setProducerCode( "DIRD" );

        addQuoteRequest.setEffectiveDate( "2022-10-01T00:00:00" );

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
              getValue( () -> intake.get( actionJMSQuoteSpecDto.getPrimaryContactResAddrPostalCode() ).getAnswer(), "" )
        );

        primaryContact.setResidentialAddress( residentialAddress );

        addQuoteRequest.setPrimaryContact( primaryContact );

        processUnderWriting( addQuoteRequest, intake, actionJMSQuoteSpecDto );

        processAddQuoteIteration( addQuoteRequest, intake.get( "items" ).getIterations(), actionJMSQuoteSpecDto );

        return addQuoteRequest;
    }


    private void processUnderWriting( AddQuoteRequest addQuoteRequest,
                                      LinkedHashMap<String, ClientAnswerDto> intake,
                                      ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        addQuoteRequest.setUnderwritingQuestions( new ArrayList<>() );

        AddQuoteRequest.UnderwritingQuestion felony = new AddQuoteRequest.UnderwritingQuestion();
        felony.setKey( actionJMSQuoteSpecDto.getFelonyConviction() );
        felony.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getFelonyConviction() ).getAnswer(), "" ) );
        addQuoteRequest.getUnderwritingQuestions().add( felony );

        AddQuoteRequest.UnderwritingQuestion lostWithin7Years = new AddQuoteRequest.UnderwritingQuestion();
        lostWithin7Years.setKey( actionJMSQuoteSpecDto.getLostWithin7Years() );
        lostWithin7Years.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getLostWithin7Years() ).getAnswer(), "" ) );
        addQuoteRequest.getUnderwritingQuestions().add( lostWithin7Years );

        AddQuoteRequest.UnderwritingQuestion misdemeanor = new AddQuoteRequest.UnderwritingQuestion();
        misdemeanor.setKey( actionJMSQuoteSpecDto.getMisdemeanorConviction() );
        misdemeanor.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getMisdemeanorConviction() ).getAnswer(), "" ) );
        addQuoteRequest.getUnderwritingQuestions().add( misdemeanor );

        AddQuoteRequest.UnderwritingQuestion crimeForProfit = new AddQuoteRequest.UnderwritingQuestion();
        crimeForProfit.setKey( actionJMSQuoteSpecDto.getCrimeForProfit() );
        crimeForProfit.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCrimeForProfit() ).getAnswer(), "" ) );
        addQuoteRequest.getUnderwritingQuestions().add( crimeForProfit );

        AddQuoteRequest.UnderwritingQuestion cancelledCoverage = new AddQuoteRequest.UnderwritingQuestion();
        cancelledCoverage.setKey( actionJMSQuoteSpecDto.getCanceledOrDeniedCoverage() );
        cancelledCoverage.setValue( getValue( () -> intake.get( actionJMSQuoteSpecDto.getCanceledOrDeniedCoverage() ).getAnswer(), "" ) );
        addQuoteRequest.getUnderwritingQuestions().add( cancelledCoverage );
    }


    private void processAddQuoteIteration( AddQuoteRequest addQuoteRequest,
                                           List<ClientLoopIterationDto> iterations,
                                           ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        ArrayList<AddQuoteRequest.JeweleryItem> jeweleryItems = new ArrayList<>();
        for ( ClientLoopIterationDto clientLoopIterationDto : iterations )
        {
            AddQuoteRequest.JeweleryItem item = new AddQuoteRequest.JeweleryItem();
            item.setJeweleryType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemType() ).getAnswer(), "" ).toString()
            );
            item.setJewelerySubType(
                  getValue( () -> clientLoopIterationDto.getAnswers().get( "test" ).getAnswer(), "" ).toString()
            );

            item.setItemNumber(

                  1
                  // Integer.parseInt( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemId() ).getAnswer(), 0 ).toString() )
            );
            item.setItemValue(
                  Integer.parseInt( getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer(), "" ).toString() )
            );
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

            primaryWearer.setGender( "F" );

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
                  getValue( () -> clientLoopIterationDto.getAnswers().get( actionJMSQuoteSpecDto.getPrimaryWearerResAddrPostalCode() ).getAnswer(), "" )
            );

            primaryWearer.setResidentialAddress( primaryWearerResidentialAddress );
            item.setPrimaryWearer( primaryWearer );
            jeweleryItems.add( item );
        }
        addQuoteRequest.setJeweleryItems( jeweleryItems );
    }



    private PubQuoteDetailsDto getQuoteDetails( AddQuoteResult addQuoteResult )
    {
        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        PubPremiumDto.PubPremiumDtoBuilder premiumBuilder = PubPremiumDto.builder();

        premiumBuilder.amount( new BigDecimal( (Double) addQuoteResult.ratingInfo.getTotalPremium() ).round( new MathContext( 2, RoundingMode.HALF_EVEN ) ) );

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

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
    }


    private List<PubCoverageDto> getPubCoverages( AddQuoteResult.ItemRateDetail itemRateDetail,
                                                  String itemId )
    {
        //   String type = (String) rateInfo.getJeweleryType();
        PubCoveragesDto.PubCoveragesDtoBuilder builder = PubCoveragesDto.builder();
        builder.type( "todo" );

        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( AddQuoteResult.RateOption rateOption : itemRateDetail.getRateOptions() )
        {
            PubCoverageDto.PubCoverageDtoBuilder pubCoverageBuilder = PubCoverageDto.builder();
            BigDecimal premium = new BigDecimal( (double) rateOption.getRateBreakdown().get( 0 ).getRateValue() ).round( new MathContext( 2, RoundingMode.HALF_EVEN ) );
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
    }*/
}

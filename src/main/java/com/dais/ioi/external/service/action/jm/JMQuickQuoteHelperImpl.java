package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
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
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.net.URI;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;

@Service
public class JMQuickQuoteHelperImpl
{
  @Autowired
  JMQuoteClient jmQuoteClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;


    public TriggerResponseDto processQuickQuote( FiredTriggerDto firedTriggerDto,
                                   JMAuthResult jmAuthResult,
                                                 ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        final UUID requestId = null == firedTriggerDto.getTriggerRequestId() ? UUID.randomUUID() : firedTriggerDto.getTriggerRequestId();

        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );

        QuickQuoteRequest quickQuoteRequest = createQuickQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto );

        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getQuickQuoteUrl());

        QuickQuoteResult quickQuoteResult = jmQuoteClient.getQuickQuote( determinedBasePathUri,
                                                                         "Bearer " + jmAuthResult.getAccess_token(),
                                                                         actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                         quickQuoteRequest );

        // Map to the ioi generic quote DTO
        PubQuoteDetailsDto quoteDetails = getQuoteDetails( quickQuoteResult );

        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();

        QuoteDto newQuote = QuoteDto.builder()
                                /*    .actionId( ap.actionEntity.getId() )
                                    .pipelineId( ap.triggerEntity.getPipeline().getId() )
                                    .quotingOrganizationId( ap.triggerEntity.getPipeline().getOrganizationId() )
                                    .triggerRequestId( ap.triggerResponse.getTriggerRequestId() )
                                    .bundleId( ap.firedTrigger.getBundleId() )
                                    .lineId( ap.line.getId() )
                                    )*/
                                    .quoteTimestamp( OffsetDateTime.now() )
                                    .source( firedTriggerDto.getSource() )
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .type( QuoteType.QUOTE )
                                    .clientId( triggerSpec.getClientId() )
                                    .requestId( requestId )
                                    .bindable( false )
                                    .effectiveDate( LocalDate.now()    )
                                    .quoteDetails( quoteDetails )
                                    .metadata( Collections.singletonMap( "totalTaxesAndSurcharges", (Double) quickQuoteResult.getTotalTaxesAndSurcharges() ) )
                                    .build();

        triggerResponseDto.getMetadata().put( requestId.toString(),  newQuote );

        triggerResponseDto.setTriggerRequestId( requestId );

        return triggerResponseDto;
    }


    private PubQuoteDetailsDto getQuoteDetails( QuickQuoteResult quickQuoteResult )
    {
        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        PubPremiumDto.PubPremiumDtoBuilder premiumBuilder = PubPremiumDto.builder();

        premiumBuilder.amount( new BigDecimal( (Double) quickQuoteResult.getTotalPremiumWithTaxes() ).round( new MathContext( 2, RoundingMode.HALF_EVEN ) ) );

        quoteBuilder.premium( premiumBuilder.build() );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        quickQuoteResult.getItemWiseRateInfo().forEach( rateInfo -> {

            PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

            pubCoveragesBuilder.type( rateInfo.jeweleryType );

            String itemId = (String) rateInfo.getItemId();

            List<PubCoverageDto> coverages = getPubCoverages( rateInfo, itemId );

            pubCoveragesBuilder.coverages( coverages );

            pubCoverages.add( pubCoveragesBuilder.build() );
        } );
        quoteBuilder.coverageTypes( pubCoverages );

        PubExternalDataDto.PubExternalDataDtoBuilder externalDataBuilder = PubExternalDataDto.builder();

        externalDataBuilder.externalQuoteId( (String) quickQuoteResult.getExternalOrderNumber() );

        PubQuoteDetailsDto quoteDetailsDto = quoteBuilder.build();

        return quoteDetailsDto;
    }


    private QuickQuoteRequest createQuickQuoteRequest( LinkedHashMap<String, ClientAnswerDto> intake,
                                                       ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        QuickQuoteRequest quickQuoteRequest = QuickQuoteRequest.builder().build();
        try
        {
            quickQuoteRequest.setCounty(
                  getValue( () -> intake.get( actionJMSQuoteSpecDto.getCounty() ).getAnswer(), "" )
            );
            quickQuoteRequest.setState(
                  getValue( () -> intake.get( actionJMSQuoteSpecDto.getState() ).getAnswer(), "" )
            );
            quickQuoteRequest.setPostalCode(
                  getValue( () -> intake.get( actionJMSQuoteSpecDto.getZip() ).getAnswer(), "" )
            );

            processQuickQuoteIterations( quickQuoteRequest, getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), null ), actionJMSQuoteSpecDto );

            return quickQuoteRequest;
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }


    private void processQuickQuoteIterations( QuickQuoteRequest quickQuoteRequest,
                                              List<ClientLoopIterationDto> iterations,
                                              ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        ArrayList<QuickQuoteRequest.JeweleryItem> jeweleryItems = new ArrayList<>();

        for ( ClientLoopIterationDto iteration : iterations )
        {
            QuickQuoteRequest.JeweleryItem item = new QuickQuoteRequest.JeweleryItem();
            item.setItemId( getValue( () -> iteration.getAnswers().get( actionJMSQuoteSpecDto.getItemId() ).getAnswer(), "" ) );
            item.setItemValue( getValue( () -> Integer.parseInt( iteration.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer() ), 0 ) );
            item.setJeweleryType( getValue( () -> iteration.getAnswers().get( actionJMSQuoteSpecDto.getItemType() ).getAnswer(), "" ) );
            jeweleryItems.add( item );
        }

        quickQuoteRequest.setJeweleryItems( jeweleryItems );
    }


    private List<PubCoverageDto> getPubCoverages( QuickQuoteResult.ItemWiseRateInfo rateInfo,
                                                  String itemId )
    {
        String type = (String) rateInfo.getJeweleryType();
        PubCoveragesDto.PubCoveragesDtoBuilder builder = PubCoveragesDto.builder();
        builder.type( type );

        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( QuickQuoteResult.RatingInfo ratingInfo : rateInfo.getRatingInfo() )
        {
            PubCoverageDto.PubCoverageDtoBuilder pubCoverageBuilder = PubCoverageDto.builder();
            BigDecimal premium = new BigDecimal( (double) ratingInfo.getItemPremiumWithTaxes() ).round( new MathContext( 2, RoundingMode.HALF_EVEN ) );
            pubCoverageBuilder.premium( premium );
            Map<String, List<PubCoverageDetailDto>> details = new HashMap<>();

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder deductibleBuilder = PubCoverageDetailDto.builder();
            deductibleBuilder.amountType( AmountType.DOLLAR );
            deductibleBuilder.amount( ( (Integer) ratingInfo.getDeductible() ).toString() );
            details.put( "deductible", Collections.singletonList( deductibleBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemTaxesAndSurchargesBuilder = PubCoverageDetailDto.builder();
            itemTaxesAndSurchargesBuilder.amountType( AmountType.DOLLAR );
            itemTaxesAndSurchargesBuilder.amount( ( (Double) ratingInfo.getItemTaxesAndSurcharges() ).toString() );
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

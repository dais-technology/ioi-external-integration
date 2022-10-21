package com.dais.ioi.external.service.action.jm;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.GetQuoteDto;
import com.dais.ioi.external.domain.dto.jm.AdditionalItemInfoDto;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.util.NormalizedPremium;
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
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.net.URI;
import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.dais.ioi.external.service.action.jm.JMUtils.getValue;


@Slf4j
@Service
public class JMQuickQuoteHelperImpl
{
    @Autowired
    JMQuoteClient jmQuoteClient;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;


    @Deprecated
    public TriggerResponseDto processQuickQuote( FiredTriggerDto firedTriggerDto,
                                                 JMAuthResult jmAuthResult,
                                                 ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {
        final UUID requestId = null == firedTriggerDto.getTriggerRequestId() ? UUID.randomUUID() : firedTriggerDto.getTriggerRequestId();

        QuoteRequestSpecDto triggerSpec = objectMapper.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );

        QuickQuoteRequest quickQuoteRequest = createQuickQuoteRequest( triggerSpec.getIntake(), actionJMSQuoteSpecDto );

        URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getQuickQuoteUrl() );

        QuickQuoteResult quickQuoteResult = jmQuoteClient.getQuickQuote( determinedBasePathUri,
                                                                         "Bearer " + jmAuthResult.getAccess_token(),
                                                                         actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                         quickQuoteRequest );


        if ( getValue( () -> quickQuoteResult.getErrorMessages().size(), 0 ) > 0 )
        {
            String errorMessage = quickQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
            throw new Exception( errorMessage );
        }

        // Map to the ioi generic quote DTO
        PubQuoteDetailsDto quoteDetails = getQuoteDetails( quickQuoteResult, triggerSpec.getIntake(), actionJMSQuoteSpecDto );

        TriggerResponseDto triggerResponseDto = new TriggerResponseDto();


        HashMap<String, Object> metaDatamap = new HashMap<>();
        metaDatamap.put( "totalTaxesAndSurcharges", (Double) quickQuoteResult.getTotalTaxesAndSurcharges() );
        metaDatamap.put( "minimumPremium", quickQuoteResult.getMinimumPremium() );
        metaDatamap.put( "minimumTaxesAndSurcharges", quickQuoteResult.getMinimumTaxesAndSurcharges() );


        QuoteDto newQuote = QuoteDto.builder()
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .quoteTimestamp( OffsetDateTime.now() )
                                    .source( firedTriggerDto.getSource() )
                                    .clientOrganizationId( firedTriggerDto.getSource().getOrganizationId() )
                                    .type( QuoteType.QUOTE )
                                    .clientId( triggerSpec.getClientId() )
                                    .requestId( requestId )
                                    .bindable( false )
                                    .effectiveDate( LocalDate.now() )
                                    .quoteDetails( quoteDetails )
                                    .metadata( metaDatamap )
                                    .build();

        triggerResponseDto.getMetadata().put( requestId.toString(), newQuote );

        triggerResponseDto.setTriggerRequestId( requestId );

        return triggerResponseDto;
    }


    public QuoteDto getQuickQuote( GetQuoteDto getQuickQuote,
                                   JMAuthResult jmAuthResult,
                                   ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
          throws Exception
    {
        {
            UUID trace = UUID.randomUUID();
            log.info( "(" + trace.toString() + ") IMPORTANT: Begin getQuickQuoteCall" );
            log.info( "(" + trace.toString() + ") IMPORTANT: Received getQuickQuote request with GetQuoteDto: " + objectMapper.writeValueAsString( getQuickQuote ) );
            QuickQuoteRequest quickQuoteRequest = createQuickQuoteRequest( getQuickQuote.getIntake(), actionJMSQuoteSpecDto );

            URI determinedBasePathUri = URI.create( actionJMSQuoteSpecDto.getQuickQuoteUrl() );

            log.info( "(" + trace.toString() + ") IMPORTANT: requesting JM QUICK QUOTE with body: " + objectMapper.writeValueAsString( quickQuoteRequest ) );
            QuickQuoteResult quickQuoteResult = jmQuoteClient.getQuickQuote( determinedBasePathUri,
                                                                             "Bearer " + jmAuthResult.getAccess_token(),
                                                                             actionJMSQuoteSpecDto.getApiSubscriptionkey(),
                                                                             quickQuoteRequest );

            log.info( "(" + trace.toString() + ") IMPORTANT: JM QUICK QUOTE response: " + objectMapper.writeValueAsString( quickQuoteRequest ) );

            if ( getValue( () -> quickQuoteResult.getErrorMessages().size(), 0 ) > 0 )
            {
                String errorMessage = quickQuoteResult.getErrorMessages().stream().map( s -> s.toString() ).collect( Collectors.joining( "," ) );
                throw new Exception( errorMessage );
            }

            // Map to the ioi generic quote DTO
            PubQuoteDetailsDto quoteDetails = getQuoteDetails( quickQuoteResult, getQuickQuote.getIntake(), actionJMSQuoteSpecDto );

            TriggerResponseDto triggerResponseDto = new TriggerResponseDto();


            HashMap<String, Object> metaDatamap = new HashMap<>();
            metaDatamap.put( "totalTaxesAndSurcharges", (Double) quickQuoteResult.getTotalTaxesAndSurcharges() );
            metaDatamap.put( "minimumPremium", quickQuoteResult.getMinimumPremium() );
            metaDatamap.put( "minimumTaxesAndSurcharges", quickQuoteResult.getMinimumTaxesAndSurcharges() );


            QuoteDto newQuote = QuoteDto.builder()
                                        .clientOrganizationId( getQuickQuote.getOrganizationId() )
                                        .quoteTimestamp( OffsetDateTime.now() )
                                        .type( QuoteType.QUOTE )
                                        .lineId( getQuickQuote.getLineId() )
                                        .clientId( getQuickQuote.getClientId() )
                                        .bindable( false )
                                        .effectiveDate( LocalDate.now() )
                                        .quoteDetails( quoteDetails )
                                        .metadata( metaDatamap )
                                        .build();
            log.info( "(" + trace.toString() + ") IMPORTANT: JM QUICK QUOTE Response transformed to ioi quoteOptions: " + objectMapper.writeValueAsString( newQuote ) );
            log.info( "(" + trace.toString() + ") IMPORTANT: End getQuickQuoteCall" );
            return newQuote;
        }
    }


    private Map<String, AdditionalItemInfoDto> getItemIdToAdditionalItemInfo( final QuickQuoteResult quickQuoteResult,
                                                                              final LinkedHashMap<String, ClientAnswerDto> intake,
                                                                              final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        final Map<String, AdditionalItemInfoDto> itemIdToIterationId = new HashMap<>();
        if ( intake.containsKey( actionJMSQuoteSpecDto.getItemLoop() ) )
        {
            final List<ClientLoopIterationDto> intakeItems = getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), new ArrayList<>() );
            final ArrayList<QuickQuoteResult.ItemWiseRateInfo> jmItemInfo = quickQuoteResult.getItemWiseRateInfo();
            final Integer jmItemCount = jmItemInfo.size();
            final Integer intakeItemCount = intakeItems.size();
            if ( NumberUtils.compare( jmItemCount, intakeItemCount ) != 0 )
            {
                throw new InvalidParameterException( String.format( "jmItemCount(%s) is not equal to intakeItemCount(%s)", jmItemCount, intakeItemCount ) );
            }
            for ( final ClientLoopIterationDto item : intakeItems )
            {
                final QuickQuoteResult.ItemWiseRateInfo itemWiseRateInfo = jmItemInfo.get( intakeItems.indexOf( item ) );
                final String itemId = itemWiseRateInfo.getItemId();
                final UUID iterationId = item.getIterationId();

                final AdditionalItemInfoDto.AdditionalItemInfoDtoBuilder additionalItemInfoDtoBuilder = AdditionalItemInfoDto.builder();
                additionalItemInfoDtoBuilder.iterationId( iterationId );

                final Map<String, ClientAnswerDto> itemAnswers = item.getAnswers();
                if ( itemAnswers.containsKey( getValue( () -> actionJMSQuoteSpecDto.getItemValue(), "" ) ) )
                {
                    final ClientAnswerDto itemValueAnswer = itemAnswers.get( getValue( () -> actionJMSQuoteSpecDto.getItemValue(), "" ) );
                    final String itemValue = itemValueAnswer.getAnswer();
                    additionalItemInfoDtoBuilder.itemValue( itemValue );
                }
                itemIdToIterationId.put( itemId, additionalItemInfoDtoBuilder.build() );
            }
        }
        return itemIdToIterationId;
    }


    private PubQuoteDetailsDto getQuoteDetails( QuickQuoteResult quickQuoteResult,
                                                final LinkedHashMap<String, ClientAnswerDto> intake,
                                                final ActionJMSQuoteSpecDto actionJMSQuoteSpecDto )
    {
        Map<String, AdditionalItemInfoDto> itemIdToAdditionalItemInfo = getItemIdToAdditionalItemInfo( quickQuoteResult, intake, actionJMSQuoteSpecDto );

        PubQuoteDetailsDto.PubQuoteDetailsDtoBuilder quoteBuilder = PubQuoteDetailsDto.builder();

        PubPremiumDto.PubPremiumDtoBuilder premiumBuilder = PubPremiumDto.builder();

        final NormalizedPremium normalizedPremium = new NormalizedPremium( quickQuoteResult.getTotalPremiumWithTaxes(),
                                                                           quickQuoteResult.getTotalTaxesAndSurcharges(),
                                                                           0d );

        premiumBuilder.amount( normalizedPremium.getPremiumWithoutTaxesOrSurcharges() );

        quoteBuilder.premium( premiumBuilder.build() );

        List<PubCoveragesDto> pubCoverages = new ArrayList<>();

        quickQuoteResult.getItemWiseRateInfo().forEach( rateInfo -> {

            PubCoveragesDto.PubCoveragesDtoBuilder pubCoveragesBuilder = PubCoveragesDto.builder();

            pubCoveragesBuilder.type( rateInfo.jeweleryType );

            String itemId = (String) rateInfo.getItemId();

            AdditionalItemInfoDto additionalItemInfoDto = itemIdToAdditionalItemInfo.get( itemId );

            List<PubCoverageDto> coverages = getPubCoverages( rateInfo, itemId, additionalItemInfoDto );

            pubCoveragesBuilder.coverages( coverages );

            pubCoverages.add( pubCoveragesBuilder.build() );
        } );

        Collections.sort( pubCoverages, Comparator.comparingDouble( s -> Double.parseDouble( s.getCoverages().get( 0 ).getDetails().get( "itemId" ).get( 0 ).getAmount() ) ) );

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

            quickQuoteRequest.setPostalCode(
                  JMUtils.formatZipCode( getValue( () -> intake.get( actionJMSQuoteSpecDto.getZip() ).getAnswer(), "" ) )
            );

            processQuickQuoteIterations( quickQuoteRequest, getValue( () -> intake.get( actionJMSQuoteSpecDto.getItemLoop() ).getIterations(), new ArrayList<>() ), actionJMSQuoteSpecDto );

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

        int itemId = 1;

        for ( ClientLoopIterationDto iteration : iterations )
        {
            QuickQuoteRequest.JeweleryItem item = new QuickQuoteRequest.JeweleryItem();
            item.setItemId( ( String.valueOf( itemId ) ) );
            item.setItemValue( getValue( () -> Integer.parseInt( iteration.getAnswers().get( actionJMSQuoteSpecDto.getItemValue() ).getAnswer() ), 0 ) );
            item.setJeweleryType( getValue( () -> iteration.getAnswers().get( actionJMSQuoteSpecDto.getItemType() ).getAnswer().toLowerCase(), "" ) );
            jeweleryItems.add( item );
            itemId++;
        }

        quickQuoteRequest.setJeweleryItems( jeweleryItems );
    }


    private List<PubCoverageDto> getPubCoverages( QuickQuoteResult.ItemWiseRateInfo rateInfo,
                                                  String itemId,
                                                  final AdditionalItemInfoDto additionalItemInfoDto )
    {
        String type = (String) rateInfo.getJeweleryType();
        PubCoveragesDto.PubCoveragesDtoBuilder builder = PubCoveragesDto.builder();
        builder.type( type );

        List<PubCoverageDto> coverages = new ArrayList<>();
        for ( QuickQuoteResult.RatingInfo ratingInfo : rateInfo.getRatingInfo() )
        {
            PubCoverageDto.PubCoverageDtoBuilder pubCoverageBuilder = PubCoverageDto.builder();

            final NormalizedPremium normalizedPremium = new NormalizedPremium( ratingInfo );

            pubCoverageBuilder.premium( normalizedPremium.getPremiumWithoutTaxesOrSurcharges() );
            Map<String, List<PubCoverageDetailDto>> details = new HashMap<>();

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder deductibleBuilder = PubCoverageDetailDto.builder();
            deductibleBuilder.amountType( AmountType.DOLLAR );
            deductibleBuilder.amount( ( (Integer) ratingInfo.getDeductible() ).toString() );
            details.put( "deductible", Collections.singletonList( deductibleBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemTaxesAndSurchargesBuilder = PubCoverageDetailDto.builder();
            itemTaxesAndSurchargesBuilder.amountType( AmountType.DOLLAR );
            itemTaxesAndSurchargesBuilder.amount( BigDecimal.valueOf( ( (Double) ratingInfo.getItemTaxesAndSurcharges() ) ).toString() );
            details.put( "itemTaxesAndSurcharges", Collections.singletonList( itemTaxesAndSurchargesBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder itemIdBuilder = PubCoverageDetailDto.builder();
            itemIdBuilder.amountType( AmountType.TEXT );
            itemIdBuilder.amount( itemId );
            details.put( "itemId", Collections.singletonList( itemIdBuilder.build() ) );

            //TODO: disable until JM Prod is stable
            //            PubCoverageDetailDto.PubCoverageDetailDtoBuilder iterationIdBuilder = PubCoverageDetailDto.builder();
            //            iterationIdBuilder.amountType( AmountType.TEXT );
            //            iterationIdBuilder.amount( additionalItemInfoDto.getIterationId().toString() );
            //            details.put( "iterationId", Collections.singletonList( iterationIdBuilder.build() ) );

            PubCoverageDetailDto.PubCoverageDetailDtoBuilder valueBuilder = PubCoverageDetailDto.builder();
            valueBuilder.amountType( AmountType.DOLLAR );
            valueBuilder.amount( BigDecimal.valueOf( Double.valueOf( additionalItemInfoDto.getItemValue() ) ).toString() );
            details.put( "itemValue", Collections.singletonList( valueBuilder.build() ) );

            pubCoverageBuilder.details( details );
            coverages.add( pubCoverageBuilder.build() );
        }
        Collections.sort( coverages, Comparator.comparingDouble( s -> Double.parseDouble( s.getDetails().get( "deductible" ).get( 0 ).getAmount() ) ) );

        return coverages;
    }
}

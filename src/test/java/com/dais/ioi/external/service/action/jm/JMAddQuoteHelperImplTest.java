package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.internal.spec.QuoteRequestSpecDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMAuthClient;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.jm.AddQuoteRequest;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.JMAuthData;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.utils.test.JsonComparisonUtils;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.skyscreamer.jsonassert.JSONCompareMode.NON_EXTENSIBLE;


class JMAddQuoteHelperImplTest
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static
    {
        // Now you should use JavaTimeModule instead
        OBJECT_MAPPER.registerModule( new JSR310Module() );
        OBJECT_MAPPER.configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false );
    }

    // Just a sanity check before pushing PR
    @Test
    void effectiveDateParsing()
    {
        final LocalDateTime effectiveDate = OffsetDateTime.parse( "2022-09-29T11:44:52-05:00" ).toLocalDateTime().with( LocalTime.MIDNIGHT );
        assertEquals( "2022-09-29T00:00", effectiveDate.toString() );

        final String formattedDate = effectiveDate.format( JMAddQuoteHelperImpl.EFFECTIVE_DATE_FORMAT );
        assertEquals( "2022-09-29T00:00:00", formattedDate );
    }


    @Test
    void testPrimaryWearerMapping()
          throws Exception
    {
        // Create instance
        final JMQuoteClient mockJmQuoteClient = Mockito.mock( JMQuoteClient.class );
        final JmQuoteOptionsService jmQuoteOptionsService = Mockito.mock( JmQuoteOptionsService.class );
        final JMAuthService mockJmAuthService = Mockito.mock( JMAuthService.class );
        final JMAddQuoteHelperImpl addQuoteHelper = new JMAddQuoteHelperImpl( mockJmQuoteClient, OBJECT_MAPPER, null, jmQuoteOptionsService, mockJmAuthService );

        // Prepare inputs
        final FiredTriggerDto firedTriggerDto = JsonFileUtils.loadResourceAs(
              "addquotehelper/multiple_wearers_request.json", FiredTriggerDto.class );
        final JMAuthResult jmAuthResult = JMAuthResult.builder().access_token( "test token" ).build();
        final ActionJMSQuoteSpecDto spec = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteSpecWearer.json", ActionJMSQuoteSpecDto.class );

        // Prepare Mock API Outputs
        final AddQuoteResult addQuoteResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteResponse.json", AddQuoteResult.class );
        QuoteRequestSpecDto triggerSpec = OBJECT_MAPPER.convertValue( firedTriggerDto.getPayload(), QuoteRequestSpecDto.class );


        AddQuoteRequest request = addQuoteHelper.createAddQuoteRequest( triggerSpec.getIntake(), spec, new HashMap<String, String>() );


        request.getPrimaryContact();
    }


    @Test
        //TODO: Assertions on AddQuoteRequest
    void mailingAddressIsIncludedInJmRequestSanityCheck()
          throws Exception
    {
        // Create instance
        final JMQuoteClient mockJmQuoteClient = Mockito.mock( JMQuoteClient.class );
        final JMAuthService mockJmAuthService = Mockito.mock( JMAuthService.class );
        final ExternalQuoteDataService externalQuoteDataService = Mockito.mock( ExternalQuoteDataService.class );
        final JmQuoteOptionsService jmQuoteOptionsService = Mockito.mock( JmQuoteOptionsService.class );
        final JMAddQuoteHelperImpl addQuoteHelper = new JMAddQuoteHelperImpl( mockJmQuoteClient, OBJECT_MAPPER, externalQuoteDataService, jmQuoteOptionsService, mockJmAuthService );

        // Prepare inputs
        final FiredTriggerDto firedTriggerDto = JsonFileUtils.loadResourceAs(
              "addquotehelper/mailingAddressDifferent_triggerRequest.json", FiredTriggerDto.class );
        final JMAuthData jmAuthData = JMAuthData.builder().accessToken( "test token" ).baseUri( URI.create( "http://test.com" ) ).build();
        final ActionJMSQuoteSpecDto spec = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteSpec.json", ActionJMSQuoteSpecDto.class );

        // Prepare Mock API Outputs
        final AddQuoteResult addQuoteResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteResponse.json", AddQuoteResult.class );

        Mockito.when( mockJmQuoteClient.addQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );
        Mockito.when( mockJmQuoteClient.updateQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );
        Mockito.when( externalQuoteDataService.saveOrUpdate( any() ) ).thenReturn( null );
        Mockito.when( mockJmAuthService.getAuthData( any() ) ).thenReturn( jmAuthData );

        // Execute
        final TriggerResponseDto triggerResponseDto = addQuoteHelper.processAddQuote( firedTriggerDto, spec );

        // Verify Results
        final TriggerResponseDto expectedResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/expectedTriggerResponse.json", TriggerResponseDto.class );

        JsonComparisonUtils.assertMatch( expectedResult, triggerResponseDto, getComparator(), "triggerResponseDto" );
    }


    @Test
    void happyPathSanityCheck()
          throws Exception
    {
        // Create instance
        final JMQuoteClient mockJmQuoteClient = Mockito.mock( JMQuoteClient.class );
        final JMAuthService mockJmAuthService = Mockito.mock( JMAuthService.class );
        final ExternalQuoteDataService externalQuoteDataService = Mockito.mock( ExternalQuoteDataService.class );
        final JmQuoteOptionsService jmQuoteOptionsService = Mockito.mock( JmQuoteOptionsService.class );
        final JMAddQuoteHelperImpl addQuoteHelper = new JMAddQuoteHelperImpl( mockJmQuoteClient, OBJECT_MAPPER, externalQuoteDataService, jmQuoteOptionsService, mockJmAuthService );

        // Prepare inputs
        final FiredTriggerDto firedTriggerDto = JsonFileUtils.loadResourceAs(
              "addquotehelper/happyPath_triggerRequest.json", FiredTriggerDto.class );
        final JMAuthData jmAuthData = JMAuthData.builder().accessToken( "test token" ).baseUri( URI.create( "http://test.com" ) ).build();
        final ActionJMSQuoteSpecDto spec = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteSpec.json", ActionJMSQuoteSpecDto.class );

        // Prepare Mock API Outputs
        final AddQuoteResult addQuoteResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteResponse.json", AddQuoteResult.class );

        Mockito.when( mockJmQuoteClient.addQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );
        Mockito.when( mockJmQuoteClient.updateQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );
        Mockito.when( mockJmAuthService.getAuthData( any() ) ).thenReturn( jmAuthData );

        // Execute
        final TriggerResponseDto triggerResponseDto = addQuoteHelper.processAddQuote( firedTriggerDto, spec );

        // Verify Results
        final TriggerResponseDto expectedResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/expectedTriggerResponse.json", TriggerResponseDto.class );

        JsonComparisonUtils.assertMatch( expectedResult, triggerResponseDto, getComparator(), "triggerResponseDto" );
    }


    private CustomComparator getComparator()
    {
        return new CustomComparator( NON_EXTENSIBLE,
                                     new Customization( "metadata.EXTERNAL_QUOTE.quoteTimestamp",
                                                        ( request, response ) -> true )
        );
    }
}
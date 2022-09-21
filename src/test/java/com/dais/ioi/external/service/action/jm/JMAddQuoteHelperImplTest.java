package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.utils.test.JsonComparisonUtils;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.Customization;
import org.skyscreamer.jsonassert.comparator.CustomComparator;

import java.time.LocalDate;
import java.time.OffsetDateTime;

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
        final LocalDate effectiveDate = OffsetDateTime.parse( "2022-09-29T11:44:52-05:00" ).toLocalDate();
        assertEquals( "2022-09-29", effectiveDate.toString() );

        final String formattedDate = effectiveDate.format( JMAddQuoteHelperImpl.EFFECTIVE_DATE_FORMAT );
        assertEquals( "2022-09-29", formattedDate );
    }


    @Test
    void happyPathSanityCheck()
          throws Exception
    {
        // Create instance
        final JMQuoteClient mockJmQuoteClient = Mockito.mock( JMQuoteClient.class );
        final JMAddQuoteHelperImpl addQuoteHelper = new JMAddQuoteHelperImpl( mockJmQuoteClient, OBJECT_MAPPER );

        // Prepare inputs
        final FiredTriggerDto firedTriggerDto = JsonFileUtils.loadResourceAs(
              "addquotehelper/happyPath_triggerRequest.json", FiredTriggerDto.class );
        final JMAuthResult jmAuthResult = JMAuthResult.builder().access_token( "test token" ).build();
        final ActionJMSQuoteSpecDto spec = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteSpec.json", ActionJMSQuoteSpecDto.class );

        // Prepare Mock API Outputs
        final AddQuoteResult addQuoteResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteResponse.json", AddQuoteResult.class );

        Mockito.when( mockJmQuoteClient.addQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );
        Mockito.when( mockJmQuoteClient.updateQuote( any(), any(), any(), any() ) ).thenReturn( addQuoteResult );

        // Execute
        final TriggerResponseDto triggerResponseDto = addQuoteHelper.processAddQuote( firedTriggerDto, jmAuthResult, spec );

        // Verify Results
        final TriggerResponseDto expectedResult = JsonFileUtils.loadResourceAs(
              "addquotehelper/expectedTriggerResponse.json", TriggerResponseDto.class );

        JsonComparisonUtils.assertMatch( expectedResult, triggerResponseDto, getComparator(), "triggerResponseDto" );
    }


    private CustomComparator getComparator()
    {
        return new CustomComparator( NON_EXTENSIBLE,
                                     new Customization( "metadata.c5213585-ea28-4ce2-bf76-f9c402aa7489.quoteTimestamp",
                                                        ( request, response ) -> true )
        );
    }
}
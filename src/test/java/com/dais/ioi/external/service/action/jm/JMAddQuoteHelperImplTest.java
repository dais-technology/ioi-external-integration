package com.dais.ioi.external.service.action.jm;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.config.client.JMQuoteClient;
import com.dais.ioi.external.domain.dto.jm.JMAuthResult;
import com.dais.ioi.external.domain.dto.spec.ActionJMSQuoteSpecDto;
import com.dais.utils.test.JsonComparisonUtils;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.io.IOException;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;


class JMAddQuoteHelperImplTest
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

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
        final JMQuoteClient mockJmQuoteClient = Mockito.mock(JMQuoteClient.class);
        final JMAddQuoteHelperImpl addQuoteHelper = new JMAddQuoteHelperImpl( mockJmQuoteClient, OBJECT_MAPPER );

        // Prepare inputs
        final FiredTriggerDto firedTriggerDto = JsonFileUtils.loadResourceAs(
              "addquotehelper/happyPath_triggerRequest.json", FiredTriggerDto.class );
        final JMAuthResult jmAuthResult = JMAuthResult.builder().access_token( "test token" ).build();
        final ActionJMSQuoteSpecDto spec = JsonFileUtils.loadResourceAs(
              "addquotehelper/addQuoteSpec.json", ActionJMSQuoteSpecDto.class );

        // Execute
        final TriggerResponseDto triggerResponseDto = addQuoteHelper.processAddQuote( firedTriggerDto, jmAuthResult, spec );

        // Verify Results
        JsonComparisonUtils.assertMatch( null, triggerResponseDto, JSONCompareMode.NON_EXTENSIBLE, "triggerResponseDto" );
    }
}
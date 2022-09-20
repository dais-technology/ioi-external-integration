package com.dais.ioi.external.service.action.jm;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;


class JMAddQuoteHelperImplTest
{
    // Just a sanity check before pushing PR
    @Test
    void effectiveDateParsing()
    {
        final LocalDate effectiveDate = OffsetDateTime.parse( "2022-09-29T11:44:52-05:00" ).toLocalDate();
        assertEquals( "2022-09-29", effectiveDate.toString() );

        final String formattedDate = effectiveDate.format( JMAddQuoteHelperImpl.EFFECTIVE_DATE_FORMAT );
        assertEquals( "2022-09-29", formattedDate );
    }
}
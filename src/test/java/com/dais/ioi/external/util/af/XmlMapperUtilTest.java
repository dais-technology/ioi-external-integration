package com.dais.ioi.external.util.af;

import com.dais.ioi.external.domain.dto.af.QuoteDto;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.xmlunit.builder.DiffBuilder;
import org.xmlunit.diff.Diff;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class XmlMapperUtilTest
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Test
    public void testXmlIsGeneratedFromJson()
          throws IOException
    {
        final XmlMapperUtil xmlMapperUtil = givenAnXmlMapper();
        final QuoteDto xmlObject = givenAnXmlObject();
        final String output = whenXmlMapperUtilIsCalled( xmlObject, xmlMapperUtil );
        thenVerifyTheOutput( output );
    }


    private void thenVerifyTheOutput( final String output )
          throws IOException
    {
        final String expectedXml = JsonFileUtils.loadResourceAs( "util/XmlMapperUtilTestData/expectedXml.xml", String.class );


        final Diff xmlComparison = DiffBuilder.compare( expectedXml ).withTest( output )
                                              .checkForSimilar()
                                              .ignoreWhitespace()
                                              .ignoreComments()
                                              .build();

        assertFalse( xmlComparison.hasDifferences() );
    }


    private String whenXmlMapperUtilIsCalled( final QuoteDto xmlObject,
                                              final XmlMapperUtil xmlMapperUtil )
          throws JsonProcessingException
    {
        return xmlMapperUtil.buildXml( xmlObject );
    }


    private QuoteDto givenAnXmlObject()
          throws IOException
    {
        OBJECT_MAPPER.registerModule( new JavaTimeModule() );
        InputStream is = XmlMapperUtilTest.class.getClassLoader().getResourceAsStream( "util/XmlMapperUtilTestData/getQuotesData.json" );
        return OBJECT_MAPPER.readValue( is, QuoteDto.class );
    }


    private XmlMapperUtil givenAnXmlMapper()
    {
        return new XmlMapperUtil();
    }
}

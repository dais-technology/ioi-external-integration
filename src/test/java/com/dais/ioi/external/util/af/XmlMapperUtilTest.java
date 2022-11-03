package com.dais.ioi.external.util.af;

import com.dais.ioi.external.domain.dto.af.ACORD;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class XmlMapperUtilTest
{
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();


    @Test
    public void testXmlIsGeneratedFromJson()
          throws IOException, JAXBException
    {
        final XmlMapperUtil xmlMapperUtil = givenAnXmlMapper();
        final ACORD xmlObject = givenAnXmlObject();
        final String output = whenXmlMapperUtilIsCalled( xmlObject, xmlMapperUtil );
        thenVerifyTheOutput( output );
    }


    private void thenVerifyTheOutput( final String output )
          throws IOException
    {
        final String expectedXml = JsonFileUtils.loadResourceAs( "util/XmlMapperUtilTestData/expectedXml.xml", String.class );

        assertEquals( expectedXml, output );
    }


    private String whenXmlMapperUtilIsCalled( final ACORD xmlObject,
                                              final XmlMapperUtil xmlMapperUtil )
          throws JAXBException
    {
        return xmlMapperUtil.buildXml( xmlObject );
    }


    private ACORD givenAnXmlObject()
          throws IOException
    {
        OBJECT_MAPPER.registerModule( new JavaTimeModule() );
        InputStream is = XmlMapperUtilTest.class.getClassLoader().getResourceAsStream( "util/XmlMapperUtilTestData/getQuotesData.json" );
        return OBJECT_MAPPER.readValue( is, ACORD.class );
    }


    private XmlMapperUtil givenAnXmlMapper()
    {
        return new XmlMapperUtil();
    }
}

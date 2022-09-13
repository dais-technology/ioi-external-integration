package com.dais.ioi.external.util;

import com.dais.ioi.external.FileReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class JsonPathPropertiesMapperUtilTest
{

    private FileReader reader = new FileReader();


    @Test
    public void test()
          throws IOException
    {
        Map source = givenASourceObject();
        Map<String, String> properties = givenJsonPathProperties();
        JsonPathPropertiesMapperUtil mapper = givenAJsonPathPropertiesMapperUtil();
        Map<String, String> result = whenTheMapperMaps( mapper, properties, source );
        thenTheResultContainsAllMappedFields( result );
    }


    private void thenTheResultContainsAllMappedFields( final Map<String, String> actual )
          throws IOException
    {
        Map expected = reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/jsonPathExpectedOutput.json" );
        assertEquals( expected, actual );
    }


    private Map<String, String> whenTheMapperMaps( final JsonPathPropertiesMapperUtil mapper,
                                                   final Map<String, String> properties,
                                                   final Map source )
    {
        return mapper.map( properties, source );
    }


    private JsonPathPropertiesMapperUtil givenAJsonPathPropertiesMapperUtil()
    {
        return new JsonPathPropertiesMapperUtil();
    }


    private Map<String, String> givenJsonPathProperties()
          throws IOException
    {
        return reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/jsonPathProperties.json" );
    }


    private Map givenASourceObject()
          throws IOException
    {
        return reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/sourceData.json" );
    }
}

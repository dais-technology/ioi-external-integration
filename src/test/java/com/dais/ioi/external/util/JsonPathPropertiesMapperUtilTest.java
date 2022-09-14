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
    public void testAllFieldsMap()
          throws IOException
    {
        Map source = givenASourceObject();
        Map<String, String> properties = givenJsonPathProperties();
        JsonPathPropertiesMapperUtil mapper = givenAJsonPathPropertiesMapperUtil();
        Map<String, String> result = whenTheMapperMaps( mapper, properties, source );
        thenTheResultContainsAllMappedFields( result );
    }


    @Test
    public void testFieldsNotMappedGetIgnored()
          throws IOException
    {
        Map source = givenASourceObject();
        Map<String, String> properties = givenJsonPathPropertiesWithFieldThatDoNotMap();
        JsonPathPropertiesMapperUtil mapper = givenAJsonPathPropertiesMapperUtil();
        Map<String, String> result = whenTheMapperMaps( mapper, properties, source );
        thenOnlyTheValidPropertiesAreMapped( result );
    }


    @Test
    public void testFieldsAreNotStringsGetIgnored()
          throws IOException
    {
        Map source = givenASourceObject();
        Map<String, String> properties = givenJsonPathPropertiesWithFieldThatAreNotString();
        JsonPathPropertiesMapperUtil mapper = givenAJsonPathPropertiesMapperUtil();
        Map<String, String> result = whenTheMapperMaps( mapper, properties, source );
        thenOnlyTheValidPropertiesAreMapped( result );
    }


    private Map<String, String> givenJsonPathPropertiesWithFieldThatAreNotString()
          throws IOException
    {
        return reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/jsonPathPropertiesWithNonStringQueries.json" );
    }


    private void thenOnlyTheValidPropertiesAreMapped( final Map<String, String> actual )
          throws IOException
    {
        Map expected = reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/jsonPathExpectedOutputMissingPaths.json" );
        assertEquals( expected, actual );
    }


    private Map<String, String> givenJsonPathPropertiesWithFieldThatDoNotMap()
          throws IOException
    {
        return reader.loadFileAsMap( "util/jsonPathPropertiesMapperUtilTestData/jsonPathPropertiesWithMissingPaths.json" );
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

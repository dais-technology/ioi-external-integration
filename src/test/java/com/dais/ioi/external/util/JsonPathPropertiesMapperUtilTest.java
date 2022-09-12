package com.dais.ioi.external.util;

import com.dais.ioi.external.FileReader;
import org.junit.jupiter.api.Test;

import java.util.Map;


public class JsonPathPropertiesMapperUtilTest
{

    private FileReader reader = new FileReader();


    @Test
    public void test()
    {
        Map source = givenASourceObject();
        Map<String, String> properties = givenJsonPathProperties();
        JsonPathPropertiesMapperUtil mapper = givenAJsonPathPropertiesMapperUtil( properties, source );
        Map<String, String> result = whenTheMapperMaps();
        thenTheResultContainsAllMappedFields( result );
    }


    private Map givenASourceObject()
    {
        return null;
    }
}

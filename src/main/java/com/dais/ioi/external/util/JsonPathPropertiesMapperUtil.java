package com.dais.ioi.external.util;

import com.jayway.jsonpath.JsonPath;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class JsonPathPropertiesMapperUtil
{

    public Map<String, String> map( final Map<String, String> properties,
                                    final Map source )
    {
        Map<String, String> returnProperties = new HashMap<>();
        for ( String property : properties.keySet() )
        {
            String jsonPath = properties.get( property );
            Object value = JsonPath.read( source, jsonPath );
            if ( value instanceof String )
            {
                returnProperties.put( property, (String) value );
            }
            if ( value instanceof Collection )
            {
                Collection values = (Collection) value;
                int i = 1;
                for ( Object item : values )
                {
                    if ( item instanceof String )
                    {
                        returnProperties.put( property + "_" + i, (String) item );
                        i++;
                    }
                }
            }
        }
        return returnProperties;
    }
}

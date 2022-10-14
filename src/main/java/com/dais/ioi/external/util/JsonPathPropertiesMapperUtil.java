package com.dais.ioi.external.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.PathNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


@Slf4j
public class JsonPathPropertiesMapperUtil
{

    private ObjectMapper mapper = new ObjectMapper();


    public Map<String, String> map( final Map<String, String> mappings,
                                    final Map source )
    {
        Map<String, String> returnProperties = new HashMap<>();
        for ( String property : mappings.keySet() )
        {
            String jsonPath = mappings.get( property );
            Optional<Object> queryResult = queryJson( source, jsonPath );
            if ( queryResult.isPresent() )
            {
                Object value = queryResult.get();
                if ( value instanceof String )
                {
                    returnProperties.put( property, (String) value );
                }
                else if ( value instanceof Number )
                {
                    returnProperties.put( property, String.valueOf( value ) );
                }
                else if ( value instanceof Collection )
                {
                    Collection values = (Collection) value;
                    Integer i = 1;
                    for ( Object item : values )
                    {
                        if ( item instanceof String )
                        {
                            returnProperties.put( StringUtils.replace( property, "<#>", i.toString() ), (String) item );
                            i++;
                        }
                    }
                }
                else
                {
                    logInvalidQuery( source, jsonPath, "jsonPath does not resolve to String: %s" );
                }
            }
        }
        return returnProperties;
    }


    private void logInvalidQuery( final Map source,
                                  final String jsonPath,
                                  final String s )
    {
        try
        {
            log.info( String.format( s, jsonPath ) );
            log.info( "Source Data: " + mapper.writeValueAsString( source ) );
        }
        catch ( Exception e )
        {
            throw new RuntimeException( e );
        }
    }


    private Optional<Object> queryJson( Map source,
                                        String jsonPath )
    {
        try
        {
            return Optional.of( JsonPath.read( source, jsonPath ) );
        }
        catch ( PathNotFoundException e )
        {
            logInvalidQuery( source, jsonPath, "Not a valid jsonPath: %s" );
            return Optional.empty();
        }
    }
}

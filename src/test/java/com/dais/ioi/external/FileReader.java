package com.dais.ioi.external;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import static com.google.common.base.Preconditions.checkArgument;


@Slf4j
public class FileReader
{

    private ObjectMapper mapper = new ObjectMapper();


    public String loadFileAsString( @NonNull String fileName )
          throws IOException
    {
        checkArgument( !fileName.isEmpty(), "File Name cannot be empty" );

        try ( final InputStream inputStream = getClass().getClassLoader().getResourceAsStream( fileName ) )
        {
            return IOUtils.toString( inputStream, "UTF-8" );
        }
        catch ( final Exception e )
        {
            log.error( String.format( "Error loading file as string: %s", fileName ) );
            throw e;
        }
    }


    public byte[] loadFileAsByteArray( @NonNull String fileName )
          throws IOException
    {
        checkArgument( !fileName.isEmpty(), "File Name cannot be empty" );

        try ( final InputStream inputStream = getClass().getClassLoader().getResourceAsStream( fileName ) )
        {
            return IOUtils.toByteArray( inputStream );
        }
        catch ( final Exception e )
        {
            log.error( String.format( "Error loading file as byte array: %s", fileName ) );
            throw e;
        }
    }


    public Map loadFileAsMap( @NonNull String fileName )
          throws IOException
    {
        try
        {
            String fileAsString = loadFileAsString( fileName );
            return mapper.readValue( fileAsString, Map.class );
        }
        catch ( final Exception e )
        {
            log.error( String.format( "Error loading file as Map: %s", fileName ) );
            throw e;
        }
    }
}

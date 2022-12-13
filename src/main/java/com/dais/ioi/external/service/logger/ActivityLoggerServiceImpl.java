package com.dais.ioi.external.service.logger;

import com.dais.ioi.external.config.client.ActivityLogClient;
import com.dais.ioi.log.domain.dto.LogDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.cache.LoadingCache;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Slf4j
@Service
@RequiredArgsConstructor
public class ActivityLoggerServiceImpl
      implements ActivityLoggerService
{
    private final LoadingCache<String, Pair<String, String>> adminCache;

    private final ActivityLogClient activityLogClient;

    private final ObjectMapper objectMapper;


    @Override
    public void logActivity( final LogDto logMessage )
    {
        try
        {
            final Pair<String, String> tokens = adminCache.get( "admin" );

            activityLogClient.storeLog( tokens.getKey(),
                                        tokens.getValue(),
                                        logMessage );
        }
        catch ( Exception e )
        {
            e.printStackTrace();
            log.error( "Failed to log to activity log: ", asString( logMessage ) );
        }
    }


    public String asString( final Object o )
    {
        if ( null == o )
        {
            return "null";
        }

        try
        {
            return objectMapper.writeValueAsString( o );
        }
        catch ( final IOException e )
        {
            log.error( "Failed to stringify a JSON object: {}", o );
            e.printStackTrace();
        }

        throw new IllegalStateException( "Failed to stringify a JSON object: " + o );
    }
}

package com.dais.ioi.external.util;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.skyscreamer.jsonassert.JSONCompare;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.skyscreamer.jsonassert.JSONCompareResult;


@Slf4j
public class CompareJsonUtil
{
    public Boolean isEqual( final String originalIntake,
                            final String newIntake )
          throws JSONException
    {
        log.info( "Original intake: " + originalIntake );
        log.info( "New intake: " + newIntake );
        JSONCompareResult jsonCompareResult = JSONCompare.compareJSON( originalIntake, newIntake, JSONCompareMode.LENIENT );
        if ( jsonCompareResult.failed() )
        {
            log.info( "New Intake is not Equal: " + jsonCompareResult.getMessage() );
        }
        return !jsonCompareResult.failed();
    }
}

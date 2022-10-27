package com.dais.ioi.external.service.action.jm;

import java.util.function.Supplier;
import java.util.regex.Pattern;


public class JMUtils
{
    private final static Pattern REGEX_US_ZIP = Pattern.compile( "^\\d{5}(?:-\\d{4})?$" );

    private final static Pattern REGEX_CA_ZIP = Pattern.compile( "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$" );
    public static <T> T getValue( Supplier<T> getFunction,
                                  T defaultValue )
    {
        try
        {
            return getFunction.get() != null ? getFunction.get() : defaultValue;
        }
        catch ( NullPointerException ex )
        {
            return defaultValue;
        }
    }

    public static String formatZipCode(String zipCode) {

        final String formattedCode = zipCode.trim().toUpperCase().replaceAll( " ", "" ); // 'code' is the zipcode from front-end.

        String returnCode = formattedCode;

        if ( !REGEX_CA_ZIP.matcher( formattedCode ).matches() && formattedCode.length() > 5) {

                returnCode = formattedCode.substring( 0, 5 );

        }
        return returnCode;
    }
}

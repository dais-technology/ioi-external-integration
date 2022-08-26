package com.dais.ioi.external.service.action.jm;

import java.util.function.Supplier;


public class JMUtils
{
    public static <T> T getValue( Supplier<T> getFunction,
                                  T defaultValue )
    {
        try
        {
            return getFunction.get();
        }
        catch ( NullPointerException ex )
        {
            return defaultValue;
        }
    }
}

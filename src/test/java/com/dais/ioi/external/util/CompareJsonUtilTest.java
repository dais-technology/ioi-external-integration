package com.dais.ioi.external.util;

import com.dais.utils.test.JsonFileUtils;
import org.json.JSONException;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CompareJsonUtilTest
{

    @Test
    public void testIntakeIsTheSame()
          throws IOException, JSONException
    {
        String originalIntake = givenAnIntake();
        String changedIntake = givenAnIntake();

        CompareJsonUtil compareJsonUtil = givenACompareJsonUtil();
        Boolean result = whenTheTwoIntakesAreCompared( compareJsonUtil, originalIntake, changedIntake );
        thenTheCompareUtilReturnsTrue( result );
    }


    @Test
    public void testIntakeHasChangedNewItemValue()
          throws IOException, JSONException
    {
        String originalIntake = givenAnIntake();
        String changedIntake = givenAnIntakeWithChangedItemValue();

        CompareJsonUtil compareJsonUtil = givenACompareJsonUtil();
        Boolean result = whenTheTwoIntakesAreCompared( compareJsonUtil, originalIntake, changedIntake );
        thenTheCompareUtilReturnsFalse( result );
    }


    @Test
    public void testIntakeHasChangedNewItemChangedValue()
          throws IOException, JSONException
    {
        String originalIntake = givenAnIntake();
        String changedIntake = givenAnIntakeWithNewJewelryItemAndChangedItemValue();

        CompareJsonUtil compareJsonUtil = givenACompareJsonUtil();
        Boolean result = whenTheTwoIntakesAreCompared( compareJsonUtil, originalIntake, changedIntake );
        thenTheCompareUtilReturnsFalse( result );
    }


    private void thenTheCompareUtilReturnsTrue( final Boolean result )
    {
        assertTrue( result );
    }


    private void thenTheCompareUtilReturnsFalse( final Boolean result )
    {
        assertFalse( result );
    }


    private Boolean whenTheTwoIntakesAreCompared( final CompareJsonUtil compareJsonUtil,
                                                  final String originalIntake,
                                                  final String newIntake )
          throws JSONException
    {
        return compareJsonUtil.isEqual( originalIntake, newIntake );
    }


    private CompareJsonUtil givenACompareJsonUtil()
    {
        return new CompareJsonUtil();
    }


    private String givenAnIntakeWithNewJewelryItemAndChangedItemValue()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "compareJsonUtil/newItemChangePrice.json", String.class );
    }


    private String givenAnIntakeWithChangedItemValue()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "compareJsonUtil/newItemChangePrice.json", String.class );
    }


    private String givenAnIntake()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "compareJsonUtil/originalIntake.json", String.class );
    }
}

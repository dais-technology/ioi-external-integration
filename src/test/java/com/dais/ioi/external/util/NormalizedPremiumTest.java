package com.dais.ioi.external.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class NormalizedPremiumTest
{
    @Test
    void below50cents()
    {
        final NormalizedPremium normalizedPremium = new NormalizedPremium( 146.02d,
                                                                           1.02d,
                                                                           0d );

        assertAll(
              () -> assertEquals( "146.02", normalizedPremium.getPremiumWithTaxesAndSurcharges().toString() ),
              () -> assertEquals( "1.02", normalizedPremium.getTotalTaxesAndSurcharges().toString() ),
              () -> assertEquals( "145.00" , normalizedPremium.getPremiumWithoutTaxesOrSurcharges().toString() )
        );
    }

    @Test
    void even50cents()
    {
        final NormalizedPremium normalizedPremium = new NormalizedPremium( 146.50d,
                                                                           1.50d,
                                                                           0d );

        assertAll(
              () -> assertEquals( "146.50", normalizedPremium.getPremiumWithTaxesAndSurcharges().toString() ),
              () -> assertEquals( "1.50", normalizedPremium.getTotalTaxesAndSurcharges().toString() ),
              () -> assertEquals( "145.00" , normalizedPremium.getPremiumWithoutTaxesOrSurcharges().toString() )
        );
    }

    @Test
    void above50cents()
    {
        final NormalizedPremium normalizedPremium = new NormalizedPremium( 146.52d,
                                                                           1.52d,
                                                                           0d );

        assertAll(
              () -> assertEquals( "146.52", normalizedPremium.getPremiumWithTaxesAndSurcharges().toString() ),
              () -> assertEquals( "1.52", normalizedPremium.getTotalTaxesAndSurcharges().toString() ),
              () -> assertEquals( "145.00" , normalizedPremium.getPremiumWithoutTaxesOrSurcharges().toString() )
        );
    }

    @Test
    void withDiscount()
    {
        final NormalizedPremium normalizedPremium = new NormalizedPremium( 146.52d,
                                                                           1.52d,
                                                                           2d);

        assertAll(
              () -> assertEquals( "146.52", normalizedPremium.getPremiumWithTaxesAndSurcharges().toString() ),
              () -> assertEquals( "1.52", normalizedPremium.getTotalTaxesAndSurcharges().toString() ),
              () -> assertEquals( "145.00" , normalizedPremium.getPremiumWithoutTaxesOrSurcharges().toString() )
        );
    }
}
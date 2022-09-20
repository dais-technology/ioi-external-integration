package com.dais.ioi.external.util;

import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Getter
public class NormalizedPremium
{
    private final BigDecimal premiumWithTaxesAndSurcharges;

    private final BigDecimal premiumWithoutTaxesOrSurcharges;

    private final BigDecimal totalTaxesAndSurcharges;


    public NormalizedPremium( final double premiumWithTaxesAndSurcharges,
                              final double totalTaxesAndSurcharges )
    {
        this(premiumWithTaxesAndSurcharges, totalTaxesAndSurcharges, RoundingMode.HALF_EVEN );
    }

    public NormalizedPremium( final double premiumWithTaxesAndSurcharges,
                              final double totalTaxesAndSurcharges,
                              final RoundingMode roundingMode )
    {
        this.premiumWithTaxesAndSurcharges = new BigDecimal( premiumWithTaxesAndSurcharges ).setScale( 2, roundingMode );
        this.totalTaxesAndSurcharges = new BigDecimal( totalTaxesAndSurcharges ).setScale( 2, roundingMode );
        this.premiumWithoutTaxesOrSurcharges = this.premiumWithTaxesAndSurcharges.subtract( this.totalTaxesAndSurcharges ).setScale( 2, roundingMode );
    }
}

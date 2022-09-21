package com.dais.ioi.external.util;

import com.dais.ioi.external.domain.dto.jm.AddQuoteResult;
import com.dais.ioi.external.domain.dto.jm.QuickQuoteResult;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.RoundingMode;


@Getter
public class NormalizedPremium
{
    private final BigDecimal premiumOnly;

    private final BigDecimal premiumWithTaxesAndSurcharges;

    private final BigDecimal premiumWithoutTaxesOrSurcharges;

    private final BigDecimal totalTaxesAndSurcharges;

    private final BigDecimal discount;

    public NormalizedPremium( final AddQuoteResult.RatingInfo ratingInfo )
    {
        this( ratingInfo.getTotalPremium(),
              ratingInfo.getTotalTaxesAndSurcharges(),
              ratingInfo.getDiscount(),
              RoundingMode.HALF_EVEN );
    }

    public NormalizedPremium( final QuickQuoteResult.RatingInfo quickRatingInfo )
    {
        this( quickRatingInfo.getItemPremiumWithTaxes(),
              quickRatingInfo.getItemTaxesAndSurcharges(),
              0,
              RoundingMode.HALF_EVEN );
    }

    public NormalizedPremium( final double premiumWithTaxesAndSurcharges,
                              final double totalTaxesAndSurcharges )
    {
        this(premiumWithTaxesAndSurcharges, totalTaxesAndSurcharges, 0, RoundingMode.HALF_EVEN );
    }

    public NormalizedPremium( final double premiumWithTaxesAndSurcharges,
                              final double totalTaxesAndSurcharges,
                              final double discount,
                              final RoundingMode roundingMode )
    {
        this.premiumWithTaxesAndSurcharges = new BigDecimal( premiumWithTaxesAndSurcharges ).setScale( 2, roundingMode );
        this.totalTaxesAndSurcharges = new BigDecimal( totalTaxesAndSurcharges ).setScale( 2, roundingMode );
        this.discount = new BigDecimal( -discount ).setScale( 2, roundingMode );
        this.premiumWithoutTaxesOrSurcharges = this.premiumWithTaxesAndSurcharges.subtract( this.totalTaxesAndSurcharges ).setScale( 2, roundingMode );
        this.premiumOnly = this.premiumWithoutTaxesOrSurcharges.add( this.discount );
    }
}

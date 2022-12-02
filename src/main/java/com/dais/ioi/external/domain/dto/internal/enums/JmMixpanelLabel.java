package com.dais.ioi.external.domain.dto.internal.enums;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public enum JmMixpanelLabel
{
    NUM_COMPLETED_QUOTES( "# Completed Quotes" ),
    NUM_RETRIEVED_QUOTES( "# Retrieved Quotes" ),
    NUM_SUBMITTED_APPLICATIONS( "# Submitted Applications" ),
    FIRST_COMPLETED_QUOTE_DATE( "First Completed Quote Date" ),
    LAST_COMPLETED_QUOTE_DATE( "Last Submitted Application Date" );

    public final String label;
}

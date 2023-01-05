package com.dais.ioi.external.service.transunion;

import lombok.Getter;


@Getter
public enum CreditStatus
{
    SYSTEM_ERROR( "000", "Unknown System Error" ),
    SYSTEM_ERROR_LOCAL( "001", "Local System Error" ),
    SYSTEM_ERROR_REMOTE( "002", "Remote System Error" ),

    // Request Errors
    UNKNOWN_DATA_ERROR( "100", "Unknown Data Error" ),
    INVALID_REQUEST_FORMAT( "101", "Invalid Request Format" ),
    INVALID_REQUEST_CONFIGURATION( "102", "Invalid Request Configuration" ),
    INVALID_REQUEST_DATA( "103", "Invalid Request Data" ),

    // Responses (With Score)
    OK( "200", "OK" ),

    // Responses (No Score)
    UNAVAILABLE( "300", "Unknown Status" ),
    NOT_FOUND( "301", "Match Not Found" ),
    DECEASED( "302", "Deceased" ),
    RESTRICTED( "303", "Restricted" ),
    INSUFFICIENT_CREDIT( "304", "Insufficient Credit" );

    private final String status;

    private final String description;


    public int getStatusAsInt()
    {
        return Integer.valueOf( status );
    }


    CreditStatus( final String status,
                  final String description )
    {
        this.status = status;
        this.description = description;
    }
}

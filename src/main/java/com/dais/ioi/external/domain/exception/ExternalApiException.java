package com.dais.ioi.external.domain.exception;

public class ExternalApiException
      extends RuntimeException
{
    public ExternalApiException( final Exception e )
    {
        super( e );
    }


    public ExternalApiException( final String message,
                                 final Exception e )
    {
        super(message, e);
    }
}

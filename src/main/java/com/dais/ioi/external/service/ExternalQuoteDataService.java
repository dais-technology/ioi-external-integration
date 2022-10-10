package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;

import java.util.UUID;


public interface ExternalQuoteDataService
{
    ExternalQuoteDataDto create( ExternalQuoteDataDto externalQuoteData );

    ExternalQuoteDataDto saveOrUpdate( ExternalQuoteDataDto externalQuoteData );

    void deleteExternalQuote( UUID externalQuoteDataId );

    ExternalQuoteDataDto getByExternalQuoteId( String externalQuoteId );
}

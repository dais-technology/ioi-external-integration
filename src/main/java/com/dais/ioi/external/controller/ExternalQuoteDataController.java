package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.ExternalQuoteDataControllerApi;
import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.service.ExternalQuoteDataService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;


@Slf4j
@RestController
@RequestMapping( "/external/quote" )
@AllArgsConstructor
public class ExternalQuoteDataController
      implements ExternalQuoteDataControllerApi
{
    private final ExternalQuoteDataService externalQuoteDataService;


    public ExternalQuoteDataDto save( final ExternalQuoteDataDto externalQuoteData )
    {
        return externalQuoteDataService.create( externalQuoteData );
    }


    @Override
    public ExternalQuoteDataDto saveOrUpdate( final ExternalQuoteDataDto integrationDto )
    {
        return externalQuoteDataService.saveOrUpdate( integrationDto );
    }


    @Override
    public void deleteExternalQuote( final UUID externalQuoteDataId )
    {
        externalQuoteDataService.deleteExternalQuote( externalQuoteDataId );
    }


    @Override
    public ExternalQuoteDataDto findByExternalQuoteId( final String externalQuoteId )
    {
        return externalQuoteDataService.getByExternalQuoteId( externalQuoteId );
    }
}

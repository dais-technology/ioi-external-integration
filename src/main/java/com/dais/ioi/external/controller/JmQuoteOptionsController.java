package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.JmQuoteOptionsApi;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.entity.jm.JmQuoteOptionEntity;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;


@Slf4j
@RestController
@RequestMapping( "/external/jm/quoteoptions" )
@AllArgsConstructor
public class JmQuoteOptionsController
      implements JmQuoteOptionsApi
{

    private final JmQuoteOptionsService jmQuoteOptionsService;


    @Override
    public JmQuoteOptionDto save( final JmQuoteOptionDto quoteOption )
    {
        return jmQuoteOptionsService.save( quoteOption );
    }


    @Override
    public JmQuoteOptionDto getById( final UUID id )
    {
        return jmQuoteOptionsService.getById( id );
    }


    @Override
    public JmQuoteOptionDto getByClientIdLineId( final UUID clientId,
                                                 final UUID lineId )
    {
        return jmQuoteOptionsService.getByClientIdLineId( clientId, lineId );
    }


    @Override
    public void deleteById( final UUID id )
    {
        jmQuoteOptionsService.delete( id );
    }


    @Override
    public void deleteByClientIdLineId( final UUID clientId,
                                        final UUID lineId )
    {
        jmQuoteOptionsService.deleteByClientIdLineId( clientId, lineId );
    }


    @Override
    public QuoteDto getMostRecentQuoteOptions( final UUID clientId )
    {
        final JmQuoteOptionEntity jmQuoteOptionEntity = jmQuoteOptionsService.getMostRecentCompletedQuote( clientId )
                                                                             .orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
        return jmQuoteOptionEntity.getQuoteOption();
    }
}

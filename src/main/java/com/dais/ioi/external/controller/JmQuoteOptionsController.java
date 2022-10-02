package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.JmQuoteOptionsApi;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

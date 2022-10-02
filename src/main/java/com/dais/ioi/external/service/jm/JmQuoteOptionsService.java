package com.dais.ioi.external.service.jm;

import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;

import java.util.UUID;


public interface JmQuoteOptionsService
{
    JmQuoteOptionDto save( JmQuoteOptionDto quoteOption );

    JmQuoteOptionDto getById( UUID id );

    JmQuoteOptionDto getByClientIdLineId( UUID clientId,
                                          UUID lineId );

    void delete( UUID id );

    void deleteByClientIdLineId( UUID clientId,
                                 UUID lineId );
}

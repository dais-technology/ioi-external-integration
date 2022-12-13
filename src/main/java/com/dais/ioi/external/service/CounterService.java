package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.count.CountDto;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


public interface CounterService
{
    void count( CountDto count );

    int getCount( Map<String, ?> key );

    @Transactional
    void aggregate();

    List<Map<String, ?>> getByKeyValue( final String key,
                                        final String value );
}

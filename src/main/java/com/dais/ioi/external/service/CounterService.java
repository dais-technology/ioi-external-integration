package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.count.CountDto;
import com.dais.ioi.external.domain.dto.count.CountForClient;
import com.dais.ioi.external.entity.AggregateCountEntity;

import javax.transaction.Transactional;
import java.util.List;


public interface CounterService
{
    void count( CountDto count );

    int getCount( CountForClient key );

    @Transactional
    void aggregate();

    List<AggregateCountEntity> getByKeyValue( final String key,
                                              final String value );
}

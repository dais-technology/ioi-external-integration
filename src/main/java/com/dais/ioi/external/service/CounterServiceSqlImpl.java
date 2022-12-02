package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.count.CountDto;
import com.dais.ioi.external.domain.dto.internal.enums.CounterType;
import com.dais.ioi.external.entity.AggregateCountEntity;
import com.dais.ioi.external.entity.CountEntity;
import com.dais.ioi.external.repository.AggregateCountByKeyValue;
import com.dais.ioi.external.repository.AggregateCountRepository;
import com.dais.ioi.external.repository.CountByKeyValue;
import com.dais.ioi.external.repository.CountRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.ListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CounterServiceSqlImpl
      implements CounterService
{
    @Autowired
    private CountRepository countRepository;

    @Autowired
    private AggregateCountRepository aggregateCountRepository;

    @Autowired
    @Qualifier( "primaryObjectMapper" )
    private ObjectMapper objectMapper;


    @Override
    public void count( final CountDto count )
    {
        CountEntity countEntity = objectMapper.convertValue( count, CountEntity.class );
        countRepository.save( countEntity );
    }


    @Override
    public int getCount( final Map<String, ?> key )
    {
        final List<CountEntity> increment = countRepository.getCountEntityByKeyAndType( key, CounterType.INCREMENT );
        final List<CountEntity> decrement = countRepository.getCountEntityByKeyAndType( key, CounterType.DECREMENT );
        final int delta = increment.size() - decrement.size();
        final AggregateCountEntity aggregateCount = aggregateCountRepository.getByKey( key )
                                                                            .orElse( new AggregateCountEntity( key, 0 ) );
        return aggregateCount.getCount() + delta;
    }


    @Override
    public void aggregate()
    {
        final List<Map<String, Object>> keys = countRepository.getDistinctCountEntityByKey();
        keys.forEach( key -> {
            final List<CountEntity> increment = countRepository.getCountEntityByKeyAndType( key, CounterType.INCREMENT );
            final List<CountEntity> decrement = countRepository.getCountEntityByKeyAndType( key, CounterType.DECREMENT );
            final int count = increment.size() - decrement.size();
            final Optional<AggregateCountEntity> aggregateOptional = aggregateCountRepository.getByKey( key );
            if ( aggregateOptional.isPresent() )
            {
                final AggregateCountEntity existingAggregateCount = aggregateOptional.get();
                existingAggregateCount.setCount( existingAggregateCount.getCount() + count );
                aggregateCountRepository.save( existingAggregateCount );
            }
            else
            {
                aggregateCountRepository.save( new AggregateCountEntity( key, count ) );
            }
            final List<CountEntity> entitiesToDelete = ListUtils.union( increment, decrement );
            countRepository.deleteInBatch( entitiesToDelete );
        } );
    }


    @Override
    public List<Map<String, ?>> getByKeyValue( final String key,
                                               final String value )
    {
        final CountByKeyValue countSpec = new CountByKeyValue( key, value );
        final List<CountEntity> counts = countRepository.findAll( countSpec );
        final List<? extends Map<String, ?>> countKeys = counts.stream().map( countEntity -> countEntity.getKey() ).distinct().collect( Collectors.toList() );
        final AggregateCountByKeyValue aggregateCountSpec = new AggregateCountByKeyValue( key, value );
        final List<AggregateCountEntity> aggregateCountEntities = aggregateCountRepository.findAll( aggregateCountSpec );
        final List<? extends Map<String, ?>> aggregateKeys = aggregateCountEntities.stream().map( countEntity -> countEntity.getKey() ).collect( Collectors.toList() );
        return ListUtils.union( countKeys, aggregateKeys );
    }
}

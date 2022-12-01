package com.dais.ioi.external.repository;

import com.dais.ioi.external.entity.AggregateCountEntity;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


@AllArgsConstructor
public class AggregateCountByKeyValue
      implements Specification<AggregateCountEntity>
{
    private String key;

    private String value;


    @Override
    public Predicate toPredicate( final Root<AggregateCountEntity> root,
                                  final CriteriaQuery<?> query,
                                  final CriteriaBuilder builder )
    {
        return builder.equal(
              builder.function( "jsonb_extract_path_text", String.class, root.<String>get( "key" ), builder.literal( key ) ), this.value );
    }
}

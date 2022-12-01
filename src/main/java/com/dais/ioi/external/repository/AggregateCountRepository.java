package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.entity.AggregateCountEntity;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface AggregateCountRepository
      extends BaseAuditRepository<AggregateCountEntity, UUID>
{
    Optional<AggregateCountEntity> getByKey( Map<String, ?> key );
}

package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.domain.dto.internal.enums.CounterType;
import com.dais.ioi.external.entity.CountEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Repository
public interface CountRepository
      extends BaseAuditRepository<CountEntity, UUID>
{
    List<CountEntity> getCountEntityByKeyAndType( final Map<String, ?> key,
                                                  final CounterType type );

    @Query( "SELECT DISTINCT c.key FROM CountEntity c" )
    List<Map<String, Object>> getDistinctCountEntityByKey();
}

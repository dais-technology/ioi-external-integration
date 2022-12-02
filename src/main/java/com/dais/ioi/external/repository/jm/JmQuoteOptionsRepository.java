package com.dais.ioi.external.repository.jm;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.entity.jm.JmQuoteOptionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface JmQuoteOptionsRepository
      extends BaseAuditRepository<JmQuoteOptionEntity, UUID>
{
    Optional<JmQuoteOptionEntity> getJmQuoteOptionEntityByClientIdAndLineId( UUID clientId,
                                                                             UUID lineId );

    List<JmQuoteOptionEntity> getJmQuoteOptionEntitiesByClientId( UUID clientId);
}

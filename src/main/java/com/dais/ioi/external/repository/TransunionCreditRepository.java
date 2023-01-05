package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.entity.TransunionAuthEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface TransunionCreditRepository
      extends BaseAuditRepository<TransunionAuthEntity, UUID>
{
    TransunionAuthEntity getTransunionAuthEntitiesByType( IntegrationType type );
}

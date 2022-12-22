package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.entity.IntegrationEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface ExternalIntegrationRepository
      extends BaseAuditRepository<IntegrationEntity, UUID>
{
    IntegrationEntity getIntegrationEntitiesByLineId( UUID lineId );

    IntegrationEntity getIntegrationEntityByLineIdAndType( UUID lineId,
                                                           IntegrationType type );

    IntegrationEntity getIntegrationEntityByUsageAndType( String usage,
                                                          IntegrationType type );

    List<IntegrationEntity> getIntegrationEntityByType( IntegrationType type );
}

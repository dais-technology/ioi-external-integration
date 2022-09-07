package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.entity.IntegrationEntity;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface ExternalIntegrationRepository
      extends BaseAuditRepository<IntegrationEntity, UUID>
{
    IntegrationEntity getIntegrationEntitiesByOrganizationId( UUID organizationId );

    IntegrationEntity getIntegrationEntityByOrganizationIdAndType( UUID organizationId,
                                                                   IntegrationType type );
}

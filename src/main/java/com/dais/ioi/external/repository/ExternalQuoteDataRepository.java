package com.dais.ioi.external.repository;

import com.dais.common.persistence.repository.base.BaseAuditRepository;
import com.dais.ioi.external.entity.ExternalQuoteDataEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public interface ExternalQuoteDataRepository
      extends BaseAuditRepository<ExternalQuoteDataEntity, UUID>
{
    void deleteById( UUID externalQuoteDataId );

    Optional<ExternalQuoteDataEntity> getExternalQuoteDataEntityByExternalQuoteId( String externalQuoteId );

    @Query("select eqd.quoteId from ExternalQuoteDataEntity eqd where clientId is null and quoteId is not null")
    List<UUID> getQuoteIdsWIthEmptyClientIds();
}

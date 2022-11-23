package com.dais.ioi.external.service.migration;


import com.dais.ioi.external.config.client.IOIQuoteClient;
import com.dais.ioi.external.repository.ExternalQuoteDataRepository;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class MigrationServiceImpl
      implements MigrationService
{
    @Autowired
    private ExternalQuoteDataRepository externalQuoteDataRepository;

    @Autowired
    private IOIQuoteClient ioiQuoteClient;

    @Autowired
    private EntityManager entityManager;


    @Override
    @Transactional
    public void populateClientIdInExternalQuoteData()
    {
        log.info( "MIGRATION: Started!" );

        List<UUID> quoteIds = externalQuoteDataRepository.getQuoteIdsToUpdateClientIds();
        log.info( "MIGRATION: Found {} rows to update!", quoteIds.size() );

        List<QuoteDto> quotes = ioiQuoteClient.getQuotesByRequestIds( quoteIds );
        log.info( "MIGRATION: IOI Quote Service returned {} quotes!", quotes.size() );

        StringBuilder updateQuery = new StringBuilder( "UPDATE ioi_external_integration.external_quote_data AS eqd SET client_id = c.client_id FROM (values\n" );

        String values = quotes.stream()
                              .map( quote -> "(uuid('" + quote.getRequestId().toString() + "'), uuid('" + quote.getClientId() + "'))" )
                              .collect( Collectors.joining( ",\n" ) );

        updateQuery.append( values ).append( ") AS c(quote_request_id, client_id) WHERE c.quote_request_id = eqd.quote_request_id;" );

        log.info( "MIGRATION: Executing query: {} ", updateQuery );

        final int updatedRows = entityManager.createNativeQuery( updateQuery.toString() ).executeUpdate();

        log.info( "MIGRATION: {} rows updated", updatedRows );
    }
}

package com.dais.ioi.external.service.jm;

import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.entity.jm.JmQuoteOptionEntity;
import com.dais.ioi.external.repository.jm.JmQuoteOptionsRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class JmQuoteOptionsServiceImpl
      implements JmQuoteOptionsService
{

    @Autowired
    private JmQuoteOptionsRepository jmQuoteOptionsRepository;

    @Autowired
    @Qualifier( "primaryObjectMapper" )
    private ObjectMapper objectMapper;


    @Override
    public JmQuoteOptionDto save( final JmQuoteOptionDto quoteOption )
    {
        final UUID clientId = quoteOption.getClientId();
        final UUID lineId = quoteOption.getLineId();

        Optional<JmQuoteOptionEntity> entityOptional = jmQuoteOptionsRepository.getJmQuoteOptionEntityByClientIdAndLineId( clientId, lineId );
        if ( entityOptional.isPresent() )
        {
            JmQuoteOptionEntity original = entityOptional.get();
            JmQuoteOptionEntity updated = objectMapper.convertValue( quoteOption, JmQuoteOptionEntity.class );
            updated.setId( original.getId() );
            jmQuoteOptionsRepository.save( updated );
            return objectMapper.convertValue( updated, JmQuoteOptionDto.class );
        }
        else
        {
            JmQuoteOptionEntity entity = objectMapper.convertValue( quoteOption, JmQuoteOptionEntity.class );
            jmQuoteOptionsRepository.save( entity );
            return objectMapper.convertValue( entity, JmQuoteOptionDto.class );
        }
    }


    @Override
    public JmQuoteOptionDto getById( final UUID id )
    {
        try
        {
            JmQuoteOptionEntity entity = jmQuoteOptionsRepository.getOne( id );
            return objectMapper.convertValue( entity, JmQuoteOptionDto.class );
        }
        catch ( EntityNotFoundException e )
        {
            throw new ResponseStatusException( HttpStatus.NOT_FOUND );
        }
    }


    @Override
    public JmQuoteOptionDto getByClientIdLineId( final UUID clientId,
                                                 final UUID lineId )
    {
        try
        {
            UUID trace = UUID.randomUUID();
            log.info( "(" + trace.toString() + ") IMPORTANT: Begin getQuoteOptions by clientID: " + clientId + " and lineId: " + lineId );
            JmQuoteOptionEntity entity = jmQuoteOptionsRepository.getJmQuoteOptionEntityByClientIdAndLineId( clientId, lineId ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
            log.info( "(" + trace.toString() + ") IMPORTANT: Fetched quoteOptions with Id: " + entity.getId() );
            log.info( "(" + trace.toString() + ") IMPORTANT: returning quoteOptions with Id: " + entity.getId() + " :" + objectMapper.writeValueAsString( entity.getQuoteOption() ) );
            
            return objectMapper.convertValue( entity, JmQuoteOptionDto.class );
        }
        catch ( JsonProcessingException e )
        {
            throw new RuntimeException( e );
        }
    }


    @Override
    public void delete( final UUID id )
    {
        jmQuoteOptionsRepository.deleteById( id );
    }


    @Override
    public void deleteByClientIdLineId( final UUID clientId,
                                        final UUID lineId )
    {

    }
}

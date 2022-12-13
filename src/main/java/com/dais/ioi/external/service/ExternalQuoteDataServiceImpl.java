package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.ExternalQuoteDataDto;
import com.dais.ioi.external.entity.ExternalQuoteDataEntity;
import com.dais.ioi.external.repository.ExternalQuoteDataRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalQuoteDataServiceImpl
      implements ExternalQuoteDataService
{
    @Autowired
    ExternalQuoteDataRepository externalQuoteDataRepository;

    @Qualifier( "mapperFacade" )
    private final MapperFacade mapperFacade;


    @Override
    public ExternalQuoteDataDto create( final ExternalQuoteDataDto externalQuoteData )
    {
        ExternalQuoteDataEntity quoteDataEntity = mapperFacade.map( externalQuoteData, ExternalQuoteDataEntity.class );
        externalQuoteDataRepository.save( quoteDataEntity );
        return mapperFacade.map( quoteDataEntity, ExternalQuoteDataDto.class );
    }


    @Override
    public ExternalQuoteDataDto saveOrUpdate( final ExternalQuoteDataDto externalQuoteData )
    {
        if ( !Objects.isNull( externalQuoteData.getId() ) )
        {
            final ExternalQuoteDataEntity entity = externalQuoteDataRepository.findById( externalQuoteData.getId() ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND ) );
            mapperFacade.map( externalQuoteData, entity );
            externalQuoteDataRepository.save( entity );
            return mapperFacade.map( entity, ExternalQuoteDataDto.class );
        }
        else
        {
            return create( externalQuoteData );
        }
    }


    @Override
    public void deleteExternalQuote( final UUID externalQuoteDataId )
    {
        externalQuoteDataRepository.deleteById( externalQuoteDataId );
    }


    @Override
    public ExternalQuoteDataDto getByExternalQuoteId( String externalQuoteId )
    {
        final ExternalQuoteDataEntity entity = externalQuoteDataRepository.getExternalQuoteDataEntityByExternalQuoteId( externalQuoteId ).orElseThrow( () -> new ResponseStatusException( HttpStatus.NOT_FOUND, "ExternalQuoteId not Found: " + externalQuoteId ) );
        return mapperFacade.map( entity, ExternalQuoteDataDto.class );
    }
}

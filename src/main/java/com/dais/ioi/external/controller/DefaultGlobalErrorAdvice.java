package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.dto.ErrorResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;


@Slf4j
@ControllerAdvice
public class DefaultGlobalErrorAdvice
{

    private static final String GENERIC_ERROR_RESPONSE = "We are unable to provide a response at this time.";

    @Autowired
    private ObjectMapper objectMapper;


    @ExceptionHandler( value = { FeignException.class } )
    public ResponseEntity feignErrorLogger( final FeignException ex )
    {
        log.error( "IMPORTANT: A feign error occurred. {} \nContent: {}", ex, ex.contentUTF8() );

        if ( ex.status() == 400 || ex.status() == 404 )
        {
            ErrorResponseDto errorResponse;
            try
            {
                errorResponse = objectMapper.readValue( ex.contentUTF8(), ErrorResponseDto.class );
            }
            catch ( Exception e )
            {
                log.error( "IMPORTANT: Error while parsing exception content to ErrorResponseDto. Content: {}", ex.contentUTF8() );
                errorResponse = ErrorResponseDto.builder().errorList( Arrays.asList( GENERIC_ERROR_RESPONSE ) ).build();
            }

            final ResponseEntity responseEntity = ResponseEntity.status( HttpStatus.BAD_REQUEST )
                                                                .body( errorResponse );
            log.info( "IMPORTANT: Response: {}", responseEntity );
            return responseEntity;
        }
        else
        {
            final ResponseEntity responseEntity = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR )
                                                                .body( ErrorResponseDto.builder().errorList( Arrays.asList( GENERIC_ERROR_RESPONSE ) ).build() );
            log.info( "IMPORTANT: Response: {}", responseEntity );
            return responseEntity;
        }
    }


    @ExceptionHandler( value = { Exception.class } )
    public ResponseEntity errorLogger( final Exception ex )
    {
        log.error( "IMPORTANT: An error occurred.", ex );
        final ResponseEntity responseEntity = ResponseEntity.status( HttpStatus.INTERNAL_SERVER_ERROR )
                                                            .body( ErrorResponseDto.builder().errorList( Arrays.asList( GENERIC_ERROR_RESPONSE ) ).build() );
        log.info( "IMPORTANT: Response: {}", responseEntity );
        return responseEntity;
    }
}

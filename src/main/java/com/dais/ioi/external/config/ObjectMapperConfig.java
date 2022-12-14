package com.dais.ioi.external.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class ObjectMapperConfig
{
    @Bean( "primaryObjectMapper" )
    public ObjectMapper objectMapper()
    {
        JavaTimeModule module = new JavaTimeModule();

        return new ObjectMapper()
              .configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false )
              .configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false )
              .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )
              .setSerializationInclusion( JsonInclude.Include.NON_NULL )
              .registerModule( module );
    }
}

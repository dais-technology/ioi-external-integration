package com.dais.ioi.external.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;


@Configuration
@Slf4j
@RequiredArgsConstructor
public class MapperConfig
{
    private MapperFactory mapperFactory;


    @PostConstruct
    public void postConstruct()
    {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }


    @Bean
    @Qualifier( "mapperFacade" )
    public MapperFacade getMapper()
    {
        return mapperFactory.getMapperFacade();
    }
}

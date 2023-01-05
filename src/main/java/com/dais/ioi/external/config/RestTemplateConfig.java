package com.dais.ioi.external.config;

import com.dais.ioi.external.service.transunion.RestTemplateWithAuth;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@Slf4j
public class RestTemplateConfig
{
    @Bean
    public RestTemplateWithAuth getRestTemplate()
    {
        return new RestTemplateWithAuth();
    }
}

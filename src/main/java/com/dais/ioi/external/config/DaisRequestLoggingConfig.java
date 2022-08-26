package com.dais.ioi.external.config;

import com.dais.common.logging.filter.DaisRequestLoggingFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DaisRequestLoggingConfig
{
    @Bean
    public DaisRequestLoggingFilter daisRequestLoggingFilter()
    {
        return new DaisRequestLoggingFilter();
    }
}

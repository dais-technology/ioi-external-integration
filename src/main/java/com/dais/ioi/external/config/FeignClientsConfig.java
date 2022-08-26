package com.dais.ioi.external.config;

import feign.RequestInterceptor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * Configuration Class for external APIs' Feign Clients
 */
@Configuration
@EnableFeignClients( basePackages = "com.dais.ioi.external.config.client" )
@ComponentScan(basePackages = { "com.dais.ioi.template" })
public class FeignClientsConfig
{
    @Bean
    RestTemplate restTemplate(final RestTemplateBuilder builder)
    {
        return builder.build();
    }


    @Bean
    RequestInterceptor jwtInterceptor()
    {
        String[] reqHeaders = new String[] { "x-jwt-assertion",
                                             "Authorization" };

        return template -> {
            RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
            if ( requestAttributes instanceof ServletRequestAttributes )
            {
                HttpServletRequest requestServlet = ( (ServletRequestAttributes) requestAttributes ).getRequest();
                for ( String header : reqHeaders )
                {
                    if ( !template.headers().containsKey( header ) && requestServlet.getHeader( header ) != null )
                    {
                        template.header( header, requestServlet.getHeader( header ) );
                    }
                }
            }
        };
    }
}

package com.dais.ioi.external.config;

import feign.Logger;
import feign.RequestInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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
import java.net.URI;
import java.net.URISyntaxException;


/**
 * Configuration Class for external APIs' Feign Clients
 */
@Configuration
@EnableFeignClients( basePackages = "com.dais.ioi.external.config.client" )
@ComponentScan( basePackages = { "com.dais.ioi.external.config.client" } )
@Slf4j
public class FeignClientsConfig
{
    /**
     * NONE: no logging (DEFAULT)
     * BASIC: logs the request method and URL and the response status code and execution time
     * HEADERS: logs the basic information along with the request and response headers
     * FULL: logs the headers, body, and metadata for both requests and responses
     */
    @Value( "${feign.logging.level:BASIC}" )
    private Logger.Level feignLoggingLevel;


    @Bean
    RestTemplate restTemplate( final RestTemplateBuilder builder )
    {
        return builder.build();
    }


    @Bean
    Logger.Level feignLoggerLevel()
    {
        return feignLoggingLevel;
    }


    @Bean
    RequestInterceptor jwtInterceptor()
    {
        String[] reqHeaders = new String[] { "x-jwt-assertion",
                                             "Authorization" };

        return template -> {
            // Only copy over auth headers if the target address is a dais.com service
            if ( isSendingToDaisAddress( template.path() ) )
            {
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
            }
        };
    }


    private Boolean isSendingToDaisAddress( final String path )
    {
        try
        {
            return new URI( path ).getHost().endsWith( ".dais.com" );
        }
        catch ( final URISyntaxException e )
        {
            throw new RuntimeException( "Unable to determine if target address is a Dais address!", e );
        }
    }
}

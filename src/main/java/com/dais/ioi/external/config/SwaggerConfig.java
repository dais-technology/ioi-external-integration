/*
 *  Copyright (C) DAIS TECHNOLOGY, INC - All Rights Reserved
 *  Unauthorized copying of this file, via any medium is strictly prohibited
 *  Proprietary and confidential
 */
package com.dais.ioi.external.config;

import com.google.common.base.Predicates;
import com.google.common.net.HttpHeaders;
import groovy.lang.MetaClass;
import io.swagger.models.auth.In;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static com.dais.common.jwt.constants.DaisJwtConstants.JWT_HEADER_KEY;


/**
 * Configuration Settings for Swagger UI and SwaggerDocs generation
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig
{

    private final String version;

    SwaggerConfig( BuildProperties buildProperties) {
        this.version = buildProperties.getVersion();
    }

    private static final String BLANK_STRING = "";

    @Bean
    public UiConfiguration uiConfig() {
        return UiConfigurationBuilder.builder().build();
    }

    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts())
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.regex("/(external|actuator/health|actuator/info).*"))
                .build()
                .ignoredParameterTypes(MetaClass.class)
                .apiInfo(metadata());
    }

    @Bean
    public List<SecurityScheme> securitySchemes() {
        return Arrays.asList(
                new ApiKey("Access Token", HttpHeaders.AUTHORIZATION, In.HEADER.name()),
                new ApiKey("JWT", JWT_HEADER_KEY, In.HEADER.name()));
    }

    private List<SecurityContext> securityContexts() {
        return Collections.singletonList(SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(Predicates.and(PathSelectors.regex("/(external).*"),
                        Predicates.not(PathSelectors.regex("/(external|actuator/health|actuator/info).*"))))
                .build());
    }

    private List<SecurityReference> defaultAuth() {
        return securitySchemes().stream().map(securityScheme -> new SecurityReference(securityScheme.getName(),
                new AuthorizationScope[0])).collect(Collectors.toList());
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Dais Action Service")
                .version(version)
                .description("Service description")
                .termsOfServiceUrl(BLANK_STRING)
                .contact(new Contact("Dais Technology, Inc.", "http://dais.com", BLANK_STRING))
                .license(
                        "Copyright (C) DAIS TECHNOLOGY, INC - All Rights Reserved " +
                                "Unauthorized copying of this file, via any medium is strictly prohibited. " +
                                "Proprietary and confidential"
                )
                .build();
    }
}

package com.dais.ioi.external.config;

import com.dais.ioi.external.config.client.TokenApiClient;
import com.dais.usermanagement.domain.api.enums.GrantTypeEnum;
import com.dais.usermanagement.domain.dto.AuthRequest;
import com.dais.usermanagement.domain.dto.AuthResult;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
public class CachingConfig
{
    @Value( "${dais.admin.clientId}" )
    private String clientId;

    @Value( "${dais.admin.userPoolId}" )
    private String userPoolId;

    @Value( "${dais.admin.username}" )
    private String adminUsername;

    @Value( "${dais.admin.password}" )
    private String adminPassword;


    @Bean
    public LoadingCache<String, Pair<String, String>> adminCache( @Autowired final TokenApiClient tokenApiClient )
    {
        return CacheBuilder.newBuilder()
                           .maximumSize( 10 )
                           .expireAfterWrite( 55, TimeUnit.MINUTES ) //token expires in 1 hr
                           .build(
                                 new CacheLoader<String, Pair<String, String>>()
                                 {
                                     @Override
                                     public Pair<String, String> load( final String username )
                                     {
                                         final AuthResult authResult = tokenApiClient.getToken( getAdminAuthRequest() );
                                         Pair<String, String> tokens = Pair.of( authResult.getIdToken(), "Bearer " + authResult.getAccessToken() );

                                         return tokens;
                                     }
                                 }
                           );
    }

    private AuthRequest getAdminAuthRequest()
    {
        final AuthRequest authRequest = new AuthRequest();
        authRequest.setGrantType( GrantTypeEnum.PASSWORD );
        authRequest.setPassword( adminPassword );
        authRequest.setUserId( adminUsername );
        authRequest.setClientId( clientId );
        authRequest.setUserPoolId( userPoolId );
        return authRequest;
    }
}

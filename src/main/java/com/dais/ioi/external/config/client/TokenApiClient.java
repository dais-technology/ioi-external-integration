package com.dais.ioi.external.config.client;

import com.dais.usermanagement.domain.api.TokenApi;
import org.springframework.cloud.openfeign.FeignClient;


@FeignClient( name = "user-management",
              contextId = "tokenApiClient")
public interface TokenApiClient
      extends TokenApi
{
}

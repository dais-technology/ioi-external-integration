package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class JMAuthData
{
    private String accessToken;

    private String apiSubscriptionKey;

    private URI baseUri;
}

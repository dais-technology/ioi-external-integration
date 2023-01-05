package com.dais.ioi.external.service.transunion;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;

@Slf4j
public class RestTemplateWithAuth
{

    public RestTemplate authRestTemplate( byte[] certData, String certPassword, byte[] serverCert )
          throws Exception
    {
        char[] password = certPassword.toCharArray();

        byte[] decodedCertificate =
              Base64.decodeBase64( serverCert);

        Certificate cert = CertificateFactory.getInstance( "X509").generateCertificate( new ByteArrayInputStream( decodedCertificate));
        final KeyStore trustStore = KeyStore.getInstance("pkcs12");
        trustStore.load(null);

        trustStore.setCertificateEntry("transunion-issuing-ca", cert);


        SSLContext sslContext = SSLContextBuilder.create()
                                                 .loadKeyMaterial( keyStore( certData, password ), password )
                                                 .loadTrustMaterial( trustStore, new TrustSelfSignedStrategy() ).build();

        HttpClient client = HttpClients.custom().setSSLContext( sslContext ).build();
        RestTemplate restTemplate = new RestTemplateBuilder().requestFactory( () -> new
              HttpComponentsClientHttpRequestFactory( client ) ).build();

        return restTemplate;
    }

    private KeyStore keyStore( byte[] certData,
                               char[] password )
          throws Exception
    {
        KeyStore keyStore = KeyStore.getInstance( "PKCS12" );

        try ( InputStream in = new ByteArrayInputStream( certData) )
        {
            keyStore.load( in, password );
        }
        return keyStore;
    }
}

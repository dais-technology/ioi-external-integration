package com.dais.ioi.external.config;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.dais.file.storage.cms.CmsFiles;
import com.dais.file.storage.cms.s3.webclient.CmsFilesBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class FileStorageConfig
{
    @Bean( "s3" )
    public AmazonS3 s3()
    {
        return AmazonS3ClientBuilder.standard().build();
    }


    @Bean( "cmsFiles" )
    public CmsFiles cmsFiles(
          @Value( "${content-management.ribbon.listOfServers}" ) final String cmsUrl,
          final AmazonS3 s3 )
    {

        return new CmsFilesBuilder()
              .withBaseCmsUrl( cmsUrl )
              .withAmazonS3Client( s3 )
              .build();
    }
}

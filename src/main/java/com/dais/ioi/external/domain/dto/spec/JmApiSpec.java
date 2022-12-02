package com.dais.ioi.external.domain.dto.spec;

import lombok.Data;


@Data
public class JmApiSpec
{
    private String authUrl;

    private String userName;

    private String clientId;

    private String clientSecret;

    private String clientPassword;

    private String apiSubscriptionkey;

    private String baseUrl;

    //document upload
    private String contentId;

    private String fileName;

    private String fileSizeKb;

    private String fileType;

    private String uploadDate;
}

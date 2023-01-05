package com.dais.ioi.external.domain.dto.transunion;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TransUnionCreditVisionAuth
{
    private IntegrationType type;

    private String memberCode;

    private String subscriberPassword;

    private byte[] certData;

    private String certPassword;

    private String industryCode;

    private String subscriberPrefixCode;

    private String productCode;

    private String processingEnv;

    private byte[] serverCert;

    private String url;
}

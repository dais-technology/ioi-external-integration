package com.dais.ioi.external.service.transunion;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckInput;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckResponse;
import com.dais.ioi.external.domain.dto.transunion.TransUnionCreditVisionAuth;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


public interface TransunionService
{
    CreditCheckResponse checkCreditScore( final CreditCheckInput input )
          throws Exception;

    void saveAuth( final TransUnionCreditVisionAuth creditVisionAuth, @RequestParam("p12certFile") final MultipartFile p12certFile )
          throws IOException;

    TransUnionCreditVisionAuth getAuth( final IntegrationType type );

}

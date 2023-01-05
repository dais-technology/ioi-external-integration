package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.TransunionApi;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckInput;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckResponse;
import com.dais.ioi.external.domain.dto.transunion.TransUnionCreditVisionAuth;
import com.dais.ioi.external.service.transunion.TransunionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Slf4j
@RestController
@RequestMapping( "/external/transunion/credit" )
@AllArgsConstructor
public class TransunionController
      implements TransunionApi
{
    private final TransunionService transunionService;


    @Override
    public CreditCheckResponse check( final CreditCheckInput input )
          throws Exception
    {
        return transunionService.checkCreditScore( input );
    }


    @Override
    public void saveAuth( final TransUnionCreditVisionAuth creditVisionAuth,
                          final MultipartFile p12certFile )
          throws IOException
    {
        transunionService.saveAuth( creditVisionAuth, p12certFile );
    }


    @Override
    public TransUnionCreditVisionAuth getAuth( final IntegrationType type )
    {
        return transunionService.getAuth( type );
    }
}

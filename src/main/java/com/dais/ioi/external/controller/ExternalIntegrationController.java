package com.dais.ioi.external.controller;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.domain.api.ExternalIntegrationAPi;
import com.dais.ioi.external.service.ExternalIntegrationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


@Slf4j
@RestController
@RequestMapping( "/pub/v1/external" )
@AllArgsConstructor
public class ExternalIntegrationController implements ExternalIntegrationAPi
{
    private final ExternalIntegrationService externalIntegrationService;
     public TriggerResponseDto fire( @Valid final FiredTriggerDto firedTriggerDto )
    {
        return externalIntegrationService.process( firedTriggerDto );
    }
}

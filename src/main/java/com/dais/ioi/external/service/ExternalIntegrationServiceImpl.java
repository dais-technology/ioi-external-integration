package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.action.domain.dto.pub.TriggerResponseDto;
import com.dais.ioi.external.repository.IntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalIntegrationServiceImpl implements ExternalIntegrationService
{
    @Autowired
    private IntegrationRepository integrationRepository;

   @Autowired
    private JMQuoteServiceImpl jmsQuoteService;
    @Override
    public TriggerResponseDto process( final FiredTriggerDto firedTriggerDto )
    {

       return jmsQuoteService.fire( firedTriggerDto );
    }
}

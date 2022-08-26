package com.dais.ioi.external.service;

import com.dais.ioi.action.domain.dto.FiredTriggerDto;
import com.dais.ioi.external.domain.dto.ExternalInputDto;
import com.dais.ioi.external.repository.ActionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class ExternalIntegrationServiceImpl implements ExternalIntegrationService
{
    private ActionRepository actionRepository;

    @Override
    public void process( final FiredTriggerDto firedTriggerDto )
    {
          //  actionRepository.findByLineId( UUID.fromString( "" ) );
    }
}

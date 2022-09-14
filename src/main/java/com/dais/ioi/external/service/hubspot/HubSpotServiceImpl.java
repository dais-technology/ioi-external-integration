package com.dais.ioi.external.service.hubspot;

import com.dais.ioi.external.config.client.HubspotClient;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.spec.HubspotTrackSpec;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.util.JsonPathPropertiesMapperUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


@Slf4j
@Service
@RequiredArgsConstructor
public class HubSpotServiceImpl
      implements HubSpotService
{

    @Autowired
    private HubspotClient hubspotClient;

    @Autowired
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Autowired
    private ObjectMapper mapper;

    private JsonPathPropertiesMapperUtil propertiesMapper = new JsonPathPropertiesMapperUtil();

    private static final String EVENT_ID_PARAM_KEY = "_n";

    private static final String PORTAL_ID_PARAM_KEY = "_a";

    private static final String API_KEY_PARAM_KEY = "hapikey";


    @Override
    public void trackEvent( final HubspotTrackRequest request )
    {
        try
        {
            IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByOrganizationIdAndType( request.getOrganizationId(), IntegrationType.HUBSPOT_TRACK );
            HubspotTrackSpec spec = mapper.convertValue( integrationEntity.getSpec(), HubspotTrackSpec.class );
            String mappingsAsString = spec.getMappings();
            Map<String, String> mappings = mapper.readValue( mappingsAsString, Map.class );
            Map<String, String> parameters = propertiesMapper.map( mappings, request.getInput() );
            parameters.put( EVENT_ID_PARAM_KEY, spec.getEventId() );
            parameters.put( PORTAL_ID_PARAM_KEY, spec.getPortalId() );
            parameters.put( API_KEY_PARAM_KEY, spec.getApiKey() );
            hubspotClient.trackEvent( parameters );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
            throw new RuntimeException( e );
        }
    }
}

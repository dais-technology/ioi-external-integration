package com.dais.ioi.external.service.hubspot;

import com.dais.ioi.action.domain.dto.internal.enums.ActionType;
import com.dais.ioi.external.config.client.HubspotClient;
import com.dais.ioi.external.domain.dto.LoggingDto;
import com.dais.ioi.external.domain.dto.hubspot.HubspotTrackRequest;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.spec.HubspotTrackSpec;
import com.dais.ioi.external.entity.IntegrationEntity;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.logger.ActivityLoggerService;
import com.dais.ioi.external.util.JsonPathPropertiesMapperUtil;
import com.dais.ioi.log.domain.dto.Category;
import com.dais.ioi.log.domain.dto.LogDto;
import com.dais.ioi.log.domain.dto.LogLevel;
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

    @Autowired
    private final ActivityLoggerService devLog;

    private JsonPathPropertiesMapperUtil propertiesMapper = new JsonPathPropertiesMapperUtil();

    private static final String EVENT_ID_PARAM_KEY = "_n";

    private static final String PORTAL_ID_PARAM_KEY = "_a";


    @Override
    public void trackEvent( final HubspotTrackRequest request )
    {
        try
        {
            log.info( String.format( "Important: Hubspot Track Request Received: %s", mapper.writeValueAsString( request ) ) );
            IntegrationEntity integrationEntity = externalIntegrationRepository.getIntegrationEntityByUsageAndType( request.getUsage(), IntegrationType.HUBSPOT_TRACK );
            HubspotTrackSpec spec = mapper.convertValue( integrationEntity.getSpec(), HubspotTrackSpec.class );
            Map<String, String> mappings = spec.getMappings();
            Map<String, String> parameters = propertiesMapper.map( mappings, request.getInput() );
            parameters.put( EVENT_ID_PARAM_KEY, spec.getEventId() );
            parameters.put( PORTAL_ID_PARAM_KEY, spec.getPortalId() );
            log.info( String.format( "Important: Sending Hubspot Track Request with the folowing parameters: %s", mapper.writeValueAsString( parameters ) ) );
            if ( request.getSource().getOrganizationId() != null )
            {
                LoggingDto loggingDto = LoggingDto.builder()
                                                  .name( "HUBSPOT TRACKING EVENT" )
                                                  .description( "Hubspot request and parameters" )
                                                  .input( mapper.convertValue( request, Map.class ) )
                                                  .output( mapper.convertValue( parameters, Map.class ) )
                                                  .build();

                devLog.logActivity( LogDto.builder()
                                          .organizationId( request.getSource().getOrganizationId() )
                                          .lineId( request.getLineId() )
                                          .category( Category.EXTERNAL_OUTBOUND )
                                          .action( String.valueOf( ActionType.EXTERNAL_INTEGRATION ) )
                                          .trigger( "JM_HUBSPOT" )
                                          .level( LogLevel.INFO )
                                          .message( mapper.convertValue( loggingDto, Map.class ) )
                                          .build() );
            }
            hubspotClient.trackEvent( parameters );
        }
        catch ( Exception e )
        {
            log.error( e.getMessage() );
            throw new RuntimeException( e );
        }
    }
}

package db.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static com.dais.ioi.external.domain.dto.internal.enums.IntegrationType.JM_AUTH;


@Slf4j
public class V1_10__add_jm_auth
      extends BaseJavaMigration
{
    @Override
    public void migrate( final Context context )
          throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        try ( Statement select = context.getConnection().createStatement() )
        {
            try ( ResultSet existingRecord = select.executeQuery( "SELECT * FROM integration where type = 'JM_AUTH'" ) )
            {
                if ( !existingRecord.next() )
                {
                    try ( ResultSet rows = select.executeQuery( "SELECT * FROM integration where type = 'JM_CREATE_ACCOUNT'" ) )
                    {
                        if ( rows.next() )
                        {
                            UUID id = UUID.randomUUID();
                            String lineId = rows.getString( "line_id" );
                            String specString = rows.getString( "spec" );
                            Map<String, Object> spec = objectMapper.readValue( specString, Map.class );

                            Map<String, String> jmAuth = new HashMap<>();
                            jmAuth.put( "authUrl", (String) spec.get( "authUrl" ) );
                            jmAuth.put( "baseUrl", (String) spec.get( "baseUrl" ) );
                            jmAuth.put( "clientId", (String) spec.get( "clientId" ) );
                            jmAuth.put( "userName", (String) spec.get( "userName" ) );
                            jmAuth.put( "clientSecret", (String) spec.get( "clientSecret" ) );
                            jmAuth.put( "clientPassword", (String) spec.get( "clientPassword" ) );
                            jmAuth.put( "apiSubscriptionkey", (String) spec.get( "apiSubscriptionkey" ) );

                            String insertQuery = "INSERT INTO integration(id, line_id, type, spec) VALUES ('" + id + "', '" + lineId + "', '" + JM_AUTH + "', '" + objectMapper.writeValueAsString( jmAuth ).replace( "'", "''" ) + "' )";

                            try ( Statement insert = context.getConnection().createStatement() )
                            {
                                insert.execute( insertQuery );
                                log.info( "Inserting integration with integration type: JM_AUTH" );
                            }
                            catch ( Exception e )
                            {
                                log.error( "Failed query was {} ", insertQuery );
                                throw e;
                            }
                        }
                    }
                }
            }
        }
    }
}

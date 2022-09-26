package db.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;


@Slf4j
public class V1_3__hubspot_spec_mapping_as_json_object
      extends BaseJavaMigration
{
    @Override
    public void migrate( final Context context )
          throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        try ( Statement select = context.getConnection().createStatement() )
        {
            try ( ResultSet rows = select.executeQuery( "SELECT * FROM integration where type = 'HUBSPOT_TRACK'" ) )
            {
                while ( rows.next() )
                {
                    String id = rows.getString( "id" );
                    String specString = rows.getString( "spec" );
                    Map<String, Object> spec = objectMapper.readValue( specString, Map.class );
                    String mappingsAsString = (String) spec.get( "mappings" );
                    Map<String, String> mappingsAsMap = objectMapper.readValue( mappingsAsString, Map.class );
                    spec.put( "mappings", mappingsAsMap );

                    String updateQuery = "UPDATE integration SET spec = '" + objectMapper.writeValueAsString( spec ).replace( "'", "''" ) + "' WHERE id = '" + id + "'";

                    try ( Statement update = context.getConnection().createStatement() )
                    {
                        update.execute( updateQuery );
                        log.info( "Updating integration with id {}", id );
                    }
                    catch ( Exception e )
                    {
                        log.error( "Failed query was {} ", updateQuery );
                        throw e;
                    }
                }
            }
        }
    }
}

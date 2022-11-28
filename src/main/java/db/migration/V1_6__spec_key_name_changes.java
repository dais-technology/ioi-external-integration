package db.migration;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Map;



@Slf4j
public class V1_6__spec_key_name_changes
      extends BaseJavaMigration
{
    @Override
    public void migrate( final Context context )
          throws Exception
    {
        final ObjectMapper objectMapper = new ObjectMapper();
        try ( Statement select = context.getConnection().createStatement() )
        {
            try ( ResultSet rows = select.executeQuery( "SELECT * FROM integration" ) )
            {
                while ( rows.next() )
                {
                    String id = rows.getString( "id" );
                    String specString = rows.getString( "spec" );
                    Map<String, Object> spec = objectMapper.readValue( specString, Map.class );
                    String createAccountUrl = (String) spec.get( "createAccountUrl" );
                    if ( createAccountUrl != null )
                    {
                        String baseUrl = createAccountUrl.replace( "/account/create", "" );
                        spec.put( "baseUrl", baseUrl );
                        spec.remove( "createAccountUrl" );
                    }

                    String submitApplicationUrl = (String) spec.get( "submitApplicationUrl" );
                    if ( submitApplicationUrl != null )
                    {
                        String baseUrl = submitApplicationUrl.replace( "/application/submit", "" );
                        spec.put( "baseUrl", baseUrl );
                        spec.remove( "submitApplicationUrl" );
                    }

                    String updatedQuery = "UPDATE integration SET spec = '" + objectMapper.writeValueAsString( spec ).replace( "'", "''" ) + "' WHERE id = '" + id + "'";
                    try ( Statement update = context.getConnection().createStatement() )
                    {
                        update.execute( updatedQuery );
                        log.info( "Updating integration with id {}", id );
                    }
                    catch ( Exception e )
                    {
                        log.error( "Failed query was {} ", updatedQuery );
                        throw e;
                    }
                }
            }
        }
    }
}

package db.migration;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.sql.ResultSet;
import java.sql.Statement;


@Slf4j
public class V1_3__hubspot_spec_mapping_as_json_object
      extends BaseJavaMigration
{
    @Override
    public void migrate( final Context context )
          throws Exception
    {
        try ( Statement select = context.getConnection().createStatement() )
        {
            try ( ResultSet rows = select.executeQuery( "SELECT * FROM integration where type = 'HUBSPOT_TRACK'" ) )
            {
                while ( rows.next() )
                {
                    String spec = rows.getString( "spec" );
                    spec.size();
                }
            }
        }
    }
}

package db.migration;

import com.dais.common.ioi.dto.answer.ClientAnswerDto;
import com.dais.common.ioi.dto.answer.ClientLoopIterationDto;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.enums.AmountType;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDetailDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoverageDto;
import com.dais.ioi.quote.domain.dto.pub.PubCoveragesDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@Slf4j
public class V1_6__insert_iteration_id_to_addQuote_options
      extends BaseJavaMigration
{

    private ObjectMapper objectMapper = getOjectMapper();


    private ObjectMapper getOjectMapper()
    {
        JavaTimeModule module = new JavaTimeModule();

        return new ObjectMapper()
              .configure( SerializationFeature.FAIL_ON_EMPTY_BEANS, false )
              .configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false )
              .configure( DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false )
              .setSerializationInclusion( JsonInclude.Include.NON_NULL )
              .registerModule( module );
    }


    @Override
    public void migrate( final Context context )
          throws Exception
    {
        try ( Statement select = context.getConnection().createStatement() )
        {
            try ( ResultSet rows = select.executeQuery( "SELECT * FROM jm_quote_option" ) )
            {
                while ( rows.next() )
                {
                    List<ClientLoopIterationDto> jewelryItems = getJeweleryItemIterations( rows );
                    QuoteDto quote = getQuoteOption( rows );
                    String rowId = rows.getString( "id" );
                    log.info( "migrating jm_quote_option id: " + rowId );
                    List<PubCoveragesDto> coverageTypes = quote.getQuoteDetails().getCoverageTypes();
                    for ( PubCoveragesDto coverageType : coverageTypes )
                    {
                        if ( !coverageTypeContainsIterationId( coverageType ) )
                        {
                            try
                            {
                                int itemIndex = coverageTypes.indexOf( coverageType );
                                ClientLoopIterationDto jewelryItemIteration = jewelryItems.get( itemIndex );

                                if ( doesCoverageAndJeweleryItemMatch( coverageType, jewelryItemIteration ) )
                                {
                                    coverageType.getCoverages().forEach( pubCoverageDto -> {
                                        addIterationId( pubCoverageDto, jewelryItemIteration.getIterationId() );
                                    } );
                                }
                                else
                                {
                                    log.warn( "jewelry type/value mismatch for quote option: " + rowId );
                                }
                            }
                            catch ( Exception e )
                            {
                                log.warn( "Error occured adding iterationIds to quoteOption: " + rowId );
                                log.error( e.getMessage(), e );
                            }
                        }
                    }
                    String updateQuery = "UPDATE jm_quote_option SET quote_option = '" + objectMapper.writeValueAsString( quote ).replace( "'", "''" ) + "' WHERE id = '" + rowId + "'";
                    try ( Statement update = context.getConnection().createStatement() )
                    {
                        update.execute( updateQuery );
                        log.info( "Updating integration with id {}", rowId );
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


    private boolean doesCoverageAndJeweleryItemMatch( PubCoveragesDto coverageType,
                                                      ClientLoopIterationDto jewelryItemIteration )
    {
        String quoteJewelryType = coverageType.getType();
        String questionJewelryType = jewelryItemIteration.getAnswers().get( "jewelryType" ).getAnswer();

        Double questionJewelryValue = Double.valueOf( jewelryItemIteration.getAnswers().get( "jewelryValue" ).getAnswer() );
        Double quoteJewelryValue = getJewelryValueFromCoveragesDto( coverageType );

        return quoteJewelryType.equalsIgnoreCase( questionJewelryType ) && questionJewelryValue.equals( quoteJewelryValue );
    }


    private QuoteDto getQuoteOption( ResultSet rows )
          throws SQLException, IOException
    {
        String quote_option = rows.getString( "quote_option" );
        return objectMapper.readValue( quote_option, QuoteDto.class );
    }


    private boolean coverageTypeContainsIterationId( PubCoveragesDto coverageType )
    {
        List<PubCoverageDto> coverages = coverageType.getCoverages();
        for ( PubCoverageDto coverage : coverages )
        {
            if ( coverage.getDetails().containsKey( "iterationId" ) )
            {
                return true;
            }
        }
        return false;
    }


    private void addIterationId( final PubCoverageDto pubCoverageDto,
                                 final UUID iterationId )
    {
        PubCoverageDetailDto pubCoverageDetailDto = PubCoverageDetailDto.builder().amount( iterationId.toString() ).amountType( AmountType.TEXT ).build();
        pubCoverageDto.getDetails().put( "iterationId", Collections.singletonList( pubCoverageDetailDto ) );
    }


    private Double getJewelryValueFromCoveragesDto( final PubCoveragesDto coverageType )
    {
        PubCoverageDto pubCoverageDto = coverageType.getCoverages().get( 0 );
        if ( pubCoverageDto.getDetails().containsKey( "itemValue" ) )
        {
            List<PubCoverageDetailDto> itemValueDetails = pubCoverageDto.getDetails().get( "itemValue" );
            return Double.valueOf( itemValueDetails.get( 0 ).getAmount() );
        }
        return null;
    }


    private List<ClientLoopIterationDto> getJeweleryItemIterations( ResultSet row )
          throws SQLException, IOException
    {
        String intakeAsString = row.getString( "intake_key" );
        TypeReference<HashMap<String, ClientAnswerDto>> typeRef = new TypeReference<HashMap<String, ClientAnswerDto>>() {};
        Map<String, ClientAnswerDto> intake = objectMapper.readValue( intakeAsString, typeRef );
        if ( intake.containsKey( "jewelryItems" ) )
        {
            ClientAnswerDto jewelryItems = intake.get( "jewelryItems" );
            return jewelryItems.getIterations();
        }
        else
        {
            return Collections.emptyList();
        }
    }
}

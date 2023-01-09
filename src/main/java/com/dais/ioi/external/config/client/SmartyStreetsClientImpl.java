package com.dais.ioi.external.config.client;

import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequest;
import com.dais.ioi.external.domain.dto.smarty.InternationalAddressDto;
import com.smartystreets.api.ClientBuilder;
import com.smartystreets.api.StaticCredentials;
import com.smartystreets.api.us_street.Batch;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_street.Client;
import com.smartystreets.api.us_street.Lookup;
import com.smartystreets.api.us_street.MatchType;
import com.smartystreets.api.us_zipcode.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Component
public class SmartyStreetsClientImpl
      implements SmartyStreetsClient
{

    @Value( "${smarty-streets.auth.id}" )
    private String authId;

    @Value( "${smarty-streets.auth.token}" )
    private String authToken;


    @Override
    public List<Candidate> verifyUsAddresses( List<AddressVerificationRequest> addresses )
          throws Exception
    {
        StaticCredentials credentials = new StaticCredentials( authId, authToken );
        Client client = new ClientBuilder( credentials ).buildUsStreetApiClient();

        Batch batch = new Batch();
        for ( AddressVerificationRequest address : addresses )
        {
            Lookup lookup = new Lookup();
            lookup.setInputId( address.getInputId() );
            lookup.setStreet( address.getStreet() );
            lookup.setSecondary( address.getSecondary() );
            lookup.setCity( address.getCity() );
            lookup.setState( address.getState() );
            lookup.setZipCode( address.getZipcode() );
            lookup.setMaxCandidates( 3 );

            if ( "strict".equalsIgnoreCase( address.getMatch() ) )
            {
                lookup.setMatch( MatchType.STRICT );
            }
            else
            {
                lookup.setMatch( MatchType.INVALID );
            }

            batch.add( lookup );
        }

        client.send( batch );

        List<Candidate> results = new ArrayList<>();
        batch.getAllLookups().forEach( lookup -> results.addAll( lookup.getResult() ) );

        return results;
    }


    @Override
    public List<com.smartystreets.api.international_street.Candidate> verifyInternationalAddress( InternationalAddressDto internationalAddressDto )
          throws Exception
    {
        StaticCredentials credentials = new StaticCredentials( authId, authToken );
        com.smartystreets.api.international_street.Client client = new ClientBuilder( credentials ).buildInternationalStreetApiClient();

        com.smartystreets.api.international_street.Lookup lookup = new com.smartystreets.api.international_street.Lookup();
        lookup.setAddress1( internationalAddressDto.getAddress1() );
        lookup.setAddress2( internationalAddressDto.getAddress2() );
        lookup.setLocality( internationalAddressDto.getLocality() );
        lookup.setAdministrativeArea( internationalAddressDto.getAdministrativeArea() );
        lookup.setCountry( internationalAddressDto.getCountry() );
        lookup.setPostalCode( internationalAddressDto.getZipCode() );

        return Arrays.asList( client.send( lookup ) );
    }


    @Override
    public List<com.smartystreets.api.international_street.Candidate> verifyInternationalAddress( final String formattedPostalCode,
                                                                                                  final String country )
          throws Exception
    {
        return verifyInternationalAddress( InternationalAddressDto.builder().zipCode( formattedPostalCode )
                                                                  .country( country )
                                                                  .address1( "address_not_available" )
                                                                  .locality( "locality_not_available" )
                                                                  .administrativeArea( "administrative_area_not_available" )
                                                                  .build() );
    }


    @Override
    public Result getAddressByZipCode( String zipCode )
          throws Exception
    {
        StaticCredentials credentials = new StaticCredentials( authId, authToken );
        com.smartystreets.api.us_zipcode.Client client = new ClientBuilder( credentials ).buildUsZipCodeApiClient();

        com.smartystreets.api.us_zipcode.Lookup lookup = new com.smartystreets.api.us_zipcode.Lookup();
        lookup.setZipCode( zipCode );

        client.send( lookup );

        return lookup.getResult();
    }
}

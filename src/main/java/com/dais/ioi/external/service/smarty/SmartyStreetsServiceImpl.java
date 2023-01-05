package com.dais.ioi.external.service.smarty;

import com.dais.common.exception.BadRequestException;
import com.dais.ioi.external.config.client.SmartyStreetsClient;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequest;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequestDto;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationResponseDto;
import com.dais.ioi.external.domain.dto.smarty.ZipCodeAddressDto;
import com.smartystreets.api.international_street.Candidate;
import com.smartystreets.api.us_zipcode.AlternateCounty;
import com.smartystreets.api.us_zipcode.City;
import com.smartystreets.api.us_zipcode.Result;
import com.smartystreets.api.us_zipcode.ZipCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;


@Slf4j
@Service
@RequiredArgsConstructor
public class SmartyStreetsServiceImpl
      implements SmartyStreetsService
{

    private final SmartyStreetsClient smartyStreetsClient;

    private final MapperFacade mapperFacade;

    private final static Pattern REGEX_US_ZIP = Pattern.compile( "^\\d{5}(?:-\\d{4})?$" );

    private final static Pattern REGEX_CA_ZIP = Pattern.compile( "^(?!.*[DFIOQU])[A-VXY][0-9][A-Z] ?[0-9][A-Z][0-9]$" );


    @Override
    public ZipCodeAddressDto getAddressFromZipCode( @NotEmpty String code )
    {
        log.info( "Getting address from zip/postal code: {}", code );

        String formattedCode = code.trim().toUpperCase().replaceAll( " ", "" );
        if ( REGEX_US_ZIP.matcher( formattedCode ).matches() )
        {
            return getUsAddressFromZipCode( formattedCode );
        }
        if ( REGEX_CA_ZIP.matcher( formattedCode ).matches() )
        {
            return getCaAddressFromZipCode( formattedCode );
        }

        log.debug( "Unrecognized zip/postal code format: {}", formattedCode );
        throw new BadRequestException( "Unrecognized zip/postal code format: " + code );
    }


    private ZipCodeAddressDto getUsAddressFromZipCode( String formattedCode )
    {
        log.debug( "Looking up US zip code {}", formattedCode );

        Result result;
        try
        {
            result = smartyStreetsClient.getAddressByZipCode( formattedCode );
        }
        catch ( Exception e )
        {
            throw new BadRequestException( e );
        }

        String zipCode = null;
        String stateCode = null;
        String zipCodeType = null;
        Set<String> cities = new HashSet<>();
        Set<String> counties = new HashSet<>();

        if ( result.getZipCodes() != null )
        {
            for ( ZipCode zip : result.getZipCodes() )
            {
                if ( StringUtils.isNotBlank( zip.getCountyName() ) )
                {
                    counties.add( zip.getCountyName() );
                }
                if ( zip.getAlternateCounties() != null )
                {
                    for ( AlternateCounty county : zip.getAlternateCounties() )
                    {
                        counties.add( county.getCountyName() );
                    }
                }
                if ( zipCode == null )
                {
                    zipCode = zip.getZipCode();
                }
            }
        }

        if ( result.getCities() != null )
        {
            for ( City city : result.getCities() )
            {
                cities.add( city.getCity() );
                if ( stateCode == null )
                {
                    stateCode = city.getStateAbbreviation();
                }
            }
        }

        if ( result.getZipCodes() != null && result.getZipCodes()[0] != null && result.getZipCodes()[0].getZipCodeType() != null )
        {
            zipCodeType = result.getZipCodes()[0].getZipCodeType();
        }

        return ZipCodeAddressDto.builder()
                                .zipCode( zipCode )
                                .countryCode( "US" )
                                .stateCode( stateCode )
                                .cities( cities )
                                .counties( counties )
                                .zipCodeType( zipCodeType )
                                .build();
    }


    private ZipCodeAddressDto getCaAddressFromZipCode( String formattedCode )
    {
        log.debug( "Looking up CA zip code {}", formattedCode );

        List<Candidate> candidates;
        try
        {
            candidates = smartyStreetsClient.verifyInternationalAddress(
                  formattedCode, "CA", "address_not_available", null, null,
                  "locality_not_available", "administrative_area_not_available" );
        }
        catch ( Exception e )
        {
            throw new BadRequestException( e );
        }

        String zipCode = null;
        String stateCode = null;
        String zipCodeType = "P";
        Set<String> cities = new HashSet<>();
        Set<String> counties = new HashSet<>();

        for ( Candidate candidate : candidates )
        {
            if ( "Partial".equals( candidate.getAnalysis().getVerificationStatus() ) )
            {
                if ( candidate.getComponents().getPostalCode() != null )
                {
                    zipCode = candidate.getComponents().getPostalCode();
                }
                if ( candidate.getComponents().getAdministrativeArea() != null )
                {
                    stateCode = candidate.getComponents().getAdministrativeArea();
                }
                if ( candidate.getComponents().getLocality() != null )
                {
                    cities.add( candidate.getComponents().getLocality() );
                }
            }
        }

        return ZipCodeAddressDto.builder()
                                .zipCode( zipCode )
                                .countryCode( "CA" )
                                .stateCode( stateCode )
                                .cities( cities )
                                .counties( counties )
                                .zipCodeType( zipCodeType )
                                .build();
    }


    @Override
    public List<AddressVerificationResponseDto> verifyFullAddresses( @NotEmpty @Valid List<AddressVerificationRequestDto> addresses )
    {
        log.info( "Verifying {} addresses", addresses.size() );

        List<AddressVerificationRequestDto> usAddressRequests = new ArrayList<>();
        List<AddressVerificationRequestDto> caAddressRequests = new ArrayList<>();
        for ( AddressVerificationRequestDto address : addresses )
        {
            if ( "US".equals( address.getCountry() ) )
            {
                usAddressRequests.add( address );
            }
            else if ( "CA".equals( address.getCountry() ) )
            {
                caAddressRequests.add( address );
            }
            else
            {
                throw new BadRequestException( "Unsupported country: " + address.getCountry() );
            }
        }

        List<AddressVerificationResponseDto> responses = new ArrayList<>();
        if ( !usAddressRequests.isEmpty() )
        {
            responses.addAll( verifyUsAddresses( usAddressRequests ) );
        }
        if ( !caAddressRequests.isEmpty() )
        {
            responses.addAll( verifyCaAddresses( caAddressRequests ) );
        }

        return responses;
    }


    private List<AddressVerificationResponseDto> verifyUsAddresses( List<AddressVerificationRequestDto> addresses )
    {
        log.debug( "Verifying {} US addresses", addresses.size() );

        List<AddressVerificationRequest> apiRequests = mapperFacade.mapAsList( addresses, AddressVerificationRequest.class );
        List<com.smartystreets.api.us_street.Candidate> results;
        try
        {
            results = smartyStreetsClient.verifyUsAddresses( apiRequests );
        }
        catch ( Exception e )
        {
            throw new BadRequestException( e );
        }

        return mapperFacade.mapAsList( results, AddressVerificationResponseDto.class );
    }


    private List<AddressVerificationResponseDto> verifyCaAddresses( List<AddressVerificationRequestDto> addresses )
    {
        log.debug( "Verifying {} CA addresses", addresses.size() );

        List<AddressVerificationResponseDto> responses = new ArrayList<>();
        for ( AddressVerificationRequestDto address : addresses )
        {

            List<Candidate> candidates;
            try
            {
                candidates = smartyStreetsClient.verifyInternationalAddress( address.getZip(), address.getCountry(), address.getAddress1(),
                                                                             address.getAddress2(), null, address.getCity(), address.getState() );
            }
            catch ( Exception e )
            {
                throw new BadRequestException( e );
            }

            Candidate matchedResult = null;
            for ( Candidate candidate : candidates )
            {
                if ( "Verified".equals( candidate.getAnalysis().getVerificationStatus() ) )
                {
                    // Perfect match - don't need to process any more in the loop
                    matchedResult = candidate;
                    break;
                }
                else if ( ( "Partial".equals( candidate.getAnalysis().getVerificationStatus() )
                            || "Ambiguous".equals( candidate.getAnalysis().getVerificationStatus() ) ) &&
                          ( "DeliveryPoint".equals( candidate.getAnalysis().getAddressPrecision() )
                            || "Premise".equals( candidate.getAnalysis().getAddressPrecision() ) ) )
                {
                    // Incomplete match
                    if ( matchedResult == null ||
                         ( "Premise".equals( matchedResult.getAnalysis().getAddressPrecision() )
                           && "DeliveryPoint".equals( candidate.getAnalysis().getAddressPrecision() ) )
                    )
                    {
                        matchedResult = candidate;
                    }
                }
            }

            if ( matchedResult != null )
            {
                AddressVerificationResponseDto response = mapperFacade.map( matchedResult, AddressVerificationResponseDto.class );
                response.setInputId( address.getInputId() );
                response.setCountry( "CA" );
                response.setUpdated( isAddressUpdated( address, response ) );
                responses.add( response );
            }
            else
            {
                responses.add( AddressVerificationResponseDto.builder()
                                                             .inputId( address.getInputId() )
                                                             .found( false )
                                                             .complete( false )
                                                             .country( "CA" )
                                                             .build() );
            }
        }

        return responses;
    }


    private boolean isAddressUpdated( AddressVerificationRequestDto request,
                                      AddressVerificationResponseDto response )
    {
        boolean updated = !request.getAddress1().equalsIgnoreCase( response.getAddress1() );
        if ( !updated && ( StringUtils.isNotBlank( request.getAddress2() ) || StringUtils.isNotBlank( response.getAddress2() ) ) )
        {
            String req = request.getAddress2() == null ? "" : request.getAddress2().trim();
            String res = response.getAddress2() == null ? "" : response.getAddress2().trim();
            updated = !req.equalsIgnoreCase( res );
        }
        updated = updated || !response.getCity().equalsIgnoreCase( request.getCity() );
        updated = updated || !response.getState().equalsIgnoreCase( request.getState() );
        updated = updated || !response.getZip().equalsIgnoreCase( request.getZip() );
        return updated;
    }
}

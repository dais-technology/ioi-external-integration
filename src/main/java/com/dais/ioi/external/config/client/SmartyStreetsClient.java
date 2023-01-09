package com.dais.ioi.external.config.client;

import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequest;
import com.dais.ioi.external.domain.dto.smarty.InternationalAddressDto;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_zipcode.Result;

import java.util.List;


public interface SmartyStreetsClient
{

    List<Candidate> verifyUsAddresses( List<AddressVerificationRequest> addresses )
          throws Exception;

    List<com.smartystreets.api.international_street.Candidate> verifyInternationalAddress( InternationalAddressDto internationalAddressDto )
          throws Exception;

    List<com.smartystreets.api.international_street.Candidate> verifyInternationalAddress( String formattedCode,
                                                                                           String country )
          throws Exception;

    Result getAddressByZipCode( String zipCode )
          throws Exception;
}

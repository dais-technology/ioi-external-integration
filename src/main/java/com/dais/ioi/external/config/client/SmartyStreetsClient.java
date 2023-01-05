package com.dais.ioi.external.config.client;

import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequest;
import com.smartystreets.api.us_street.Candidate;
import com.smartystreets.api.us_zipcode.Result;

import java.util.List;


public interface SmartyStreetsClient
{

    List<Candidate> verifyUsAddresses( List<AddressVerificationRequest> addresses )
          throws Exception;

    List<com.smartystreets.api.international_street.Candidate>
    verifyInternationalAddress(
          String zipCode,
          String country,
          String address1,
          String address2,
          String address3,
          String locality,
          String administrativeArea )
          throws Exception;

    Result getAddressByZipCode( String zipCode )
          throws Exception;
}

package com.dais.ioi.external.service.smarty;


import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequestDto;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationResponseDto;
import com.dais.ioi.external.domain.dto.smarty.ZipCodeAddressDto;

import java.util.List;


public interface SmartyStreetsService
{

    ZipCodeAddressDto getAddressFromZipCode( String code );

    List<AddressVerificationResponseDto> verifyFullAddresses( List<AddressVerificationRequestDto> addresses );
}

package com.dais.ioi.external.domain.api;

import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequestDto;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationResponseDto;
import com.dais.ioi.external.domain.dto.smarty.ZipCodeAddressDto;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface SmartyStreetsApi
{

    @RequestMapping( value = "/address/zip",
                     method = RequestMethod.GET )
    @ApiOperation( "Get address data by zip/postal code (US and CA)" )
    ZipCodeAddressDto getAddressFromZipCode( @RequestParam( name = "code" ) String code );


    @RequestMapping( value = "/address/verify",
                     method = RequestMethod.POST )
    @ApiOperation( value = "Verify a list of addresses",
                   notes = "Currently only US and CA are supported." )
    List<AddressVerificationResponseDto> verifyFullAddresses( @RequestBody List<AddressVerificationRequestDto> addresses );
}

package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.SmartyStreetsApi;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationRequestDto;
import com.dais.ioi.external.domain.dto.smarty.AddressVerificationResponseDto;
import com.dais.ioi.external.domain.dto.smarty.ZipCodeAddressDto;
import com.dais.ioi.external.service.smarty.SmartyStreetsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;


@RestController
@RequestMapping( "/smarty" )
@RequiredArgsConstructor
public class SmartyStreetsController
      implements SmartyStreetsApi
{

    private final SmartyStreetsService addressService;


    @Override
    public ZipCodeAddressDto getAddressFromZipCode( @NotEmpty String code )
    {
        return addressService.getAddressFromZipCode( code );
    }


    @Override
    public List<AddressVerificationResponseDto> verifyFullAddresses( @NotEmpty @Valid List<AddressVerificationRequestDto> addresses )
    {
        return addressService.verifyFullAddresses( addresses );
    }
}

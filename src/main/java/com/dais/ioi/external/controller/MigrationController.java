package com.dais.ioi.external.controller;


import com.dais.ioi.external.domain.api.MigrationApi;
import com.dais.ioi.external.service.migration.MigrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping( "/admin/migrate" )
@RequiredArgsConstructor
public class MigrationController
      implements MigrationApi
{
    private final MigrationService migrationService;


    @Override
    public void populateExternalQuoteDataClientId()
    {
        migrationService.populateExternalQuoteDataClientId();
    }
}
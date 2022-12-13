package com.dais.ioi.external.service.logger;

import com.dais.ioi.log.domain.dto.LogDto;


public interface ActivityLoggerService
{
    void logActivity( LogDto logMessage );
}

package com.dais.ioi.external.service.quartz;


import com.dais.ioi.external.service.CounterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;


@Slf4j
@AllArgsConstructor
public class AggregateCountsJob
      implements Job
{

    private final CounterService counterService;


    @Override
    public void execute( final JobExecutionContext context )
          throws JobExecutionException
    {
        log.info( "Starting Count Aggegation Job..." );
        counterService.aggregate();
        log.info( "Count Aggegation complete" );
    }
}

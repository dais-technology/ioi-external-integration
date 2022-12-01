package com.dais.ioi.external.config;

import com.dais.ioi.external.service.quartz.AggregateCountsJob;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.TimeZone;


@Configuration
public class CounterConfig
{

    @Bean
    public JobDetail aggregateCountsJobDetail()
    {
        return JobBuilder
              .newJob()
              .ofType( AggregateCountsJob.class )
              .storeDurably()
              .withIdentity( "aggregateCounts-job", "counts" )
              .withDescription( "aggregateCounts" )
              .build();
    }


    @Bean
    public Trigger expiredContentRemovalJobDetailTrigger( final JobDetail aggregateCountsJobDetail,
                                                          @Value( "${dais.count.aggregation.cron}" ) final String cron )
    {
        return TriggerBuilder
              .newTrigger()
              .forJob( aggregateCountsJobDetail )
              .withIdentity( "aggregateCounts-trigger", "counts" )
              .withDescription( "Expired Content Removal Trigger" )
              .withSchedule(
                    CronScheduleBuilder
                          .cronSchedule( cron )
                          .inTimeZone( TimeZone.getDefault() )
              )
              .build();
    }
}

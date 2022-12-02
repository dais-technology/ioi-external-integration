package com.dais.ioi.external.controller;

import com.dais.ioi.external.domain.api.CounterControllerApi;
import com.dais.ioi.external.domain.dto.count.CountDto;
import com.dais.ioi.external.service.CounterService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping( "/count" )
@AllArgsConstructor
public class CounterController
      implements CounterControllerApi
{
    private CounterService counterService;


    @Override
    public void count( @Valid CountDto count )
    {
        counterService.count( count );
    }


    @Override
    public void aggregate()
    {
        counterService.aggregate();
    }


    @Override
    public int getCount( final Map<String, ?> key )
    {
        return counterService.getCount( key );
    }
}

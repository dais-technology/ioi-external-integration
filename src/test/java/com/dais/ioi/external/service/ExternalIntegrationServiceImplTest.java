package com.dais.ioi.external.service;

import com.dais.ioi.external.domain.dto.jm.GetQuoteDto;
import com.dais.ioi.external.domain.dto.jm.JmQuoteOptionDto;
import com.dais.ioi.external.repository.ExternalIntegrationRepository;
import com.dais.ioi.external.service.action.jm.JMQuoteServiceImpl;
import com.dais.ioi.external.service.action.jm.JmIntegrationServiceImpl;
import com.dais.ioi.external.service.jm.JmQuoteOptionsService;
import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.utils.test.JsonFileUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.io.InputStream;
import java.time.OffsetDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;


public class ExternalIntegrationServiceImplTest
{

    @Mock
    private ExternalIntegrationRepository externalIntegrationRepository;

    @Mock
    private JMQuoteServiceImpl jmQuoteService;

    @Mock
    private JmIntegrationServiceImpl jmIntegrationService;

    @Mock
    private JmQuoteOptionsService jmQuoteOptionsService;

    @Spy
    @Qualifier( "primaryObjectMapper" )
    private ObjectMapper objectMapper;

    @InjectMocks
    ExternalIntegrationServiceImpl service;


    @BeforeEach
    public void initMocks()
    {
        MockitoAnnotations.initMocks( this );
        objectMapper.registerModule( new JavaTimeModule() );
    }


    @Test
    void quoteRequestedBefore60days_returnCachedQuote()
          throws Exception
    {
        final GetQuoteDto quoteDto = givenGetQuoteDto();
        final JmQuoteOptionDto jmQuoteOptionDto = givenQuoteOption();
        final QuoteDto result = whenServiceIsCalled( quoteDto );
        thenCachedQuoteIsReturned( jmQuoteOptionDto, result );
    }


    @Test
    void quoteRequestBefore60Days_differentIntake_returnsNewQuote()
          throws Exception
    {
        final GetQuoteDto quoteDto = givenGetQuoteDtoWithNewIntake();
        givenQuoteOption();

        final QuoteDto expectedResult = prepareQuickQuoteMock( quoteDto );

        final QuoteDto result = whenServiceIsCalled( quoteDto );
        thenNewQuoteIsReturned( result, expectedResult );
    }


    @Test
    void quoteRequestAfter60Days_returnsNewQuote()
          throws Exception
    {
        final GetQuoteDto quoteDto = givenGetQuoteDto();
        final JmQuoteOptionDto jmQuoteOptionDto = givenQuoteOption();
        jmQuoteOptionDto.setSubmissionDate( OffsetDateTime.parse( "2022-07-09T21:49:00.746Z" ) );

        final QuoteDto expectedResult = prepareQuickQuoteMock( quoteDto );

        final QuoteDto result = whenServiceIsCalled( quoteDto );
        thenNewQuoteIsReturned( result, expectedResult );
    }


    @Test
    void whenNoQuoteOptionReturned_throwsException_returnNewQuote()
          throws Exception
    {
        final GetQuoteDto quoteDto = givenGetQuoteDto();

        prepareGetQuoteOptionMock();
        final QuoteDto expectedResult = prepareQuickQuoteMock( quoteDto );

        final QuoteDto result = whenServiceIsCalled( quoteDto );
        thenNewQuoteIsReturned( result, expectedResult );
    }


    private void prepareGetQuoteOptionMock()
    {
        Mockito.when( jmQuoteOptionsService.getByClientIdLineId( any(), any() ) ).thenThrow( ResponseStatusException.class );
    }


    private QuoteDto prepareQuickQuoteMock( GetQuoteDto quoteDto )
          throws Exception
    {
        final InputStream is = ExternalIntegrationServiceImplTest.class.getClassLoader().getResourceAsStream( "externalIntegrationServiceImpl/cachedQuoteTestData/newQuoteResponse.json" );
        final QuoteDto expectedResponse = objectMapper.readValue( is, QuoteDto.class );

        Mockito.when( jmQuoteService.getQuickQuote( quoteDto ) ).thenReturn( expectedResponse );

        //to avoid nullpointer in the logs
        final JmQuoteOptionDto jmQuoteOptionDto = new JmQuoteOptionDto();
        jmQuoteOptionDto.setId( UUID.randomUUID() );
        Mockito.when( jmQuoteOptionsService.save( any() ) ).thenReturn( jmQuoteOptionDto );

        return expectedResponse;
    }


    private void thenNewQuoteIsReturned(
          final QuoteDto result,
          final QuoteDto expectedResult )
    {
        assertEquals( expectedResult, result );
    }


    private GetQuoteDto givenGetQuoteDtoWithNewIntake()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "externalIntegrationServiceImpl/cachedQuoteTestData/getQuoteDtoWithDifferentIntake.json", GetQuoteDto.class );
    }


    private void thenCachedQuoteIsReturned( JmQuoteOptionDto jmQuoteOptionDto,
                                            QuoteDto result )
    {
        final QuoteDto quoteOption = jmQuoteOptionDto.getQuoteOption();
        assertEquals( result, quoteOption );
    }


    private QuoteDto whenServiceIsCalled( GetQuoteDto quoteDto )
          throws Exception
    {
        return service.getCachedQuickQuote( quoteDto );
    }


    private JmQuoteOptionDto givenQuoteOption()
          throws IOException
    {
        final InputStream is = ExternalIntegrationServiceImplTest.class.getClassLoader().getResourceAsStream( "externalIntegrationServiceImpl/cachedQuoteTestData/quoteOptionDto.json" );
        final JmQuoteOptionDto jmQuoteOptionDto = objectMapper.readValue( is, JmQuoteOptionDto.class );
        Mockito.when( jmQuoteOptionsService.getByClientIdLineId( any(), any() ) ).thenReturn( jmQuoteOptionDto );
        return jmQuoteOptionDto;
    }


    private GetQuoteDto givenGetQuoteDto()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "externalIntegrationServiceImpl/cachedQuoteTestData/getQuoteDto.json", GetQuoteDto.class );
    }
}

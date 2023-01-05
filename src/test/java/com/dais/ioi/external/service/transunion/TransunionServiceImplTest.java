package com.dais.ioi.external.service.transunion;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckInput;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckResponse;
import com.dais.ioi.external.domain.dto.transunion.TransUnionCreditVisionAuth;
import com.dais.ioi.external.repository.TransunionCreditRepository;
import com.dais.utils.test.JsonFileUtils;
import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;


public class TransunionServiceImplTest
{

    @Mock
    TransunionCreditRepository repository;

    @Mock
    MapperFacade mapperFacade;

    @Mock
    private RestTemplateWithAuth restTemplateWithAuth;

    @InjectMocks
    TransunionServiceImpl service;


    @BeforeEach
    public void initMocks()
    {
        MockitoAnnotations.initMocks( this );
    }


    @Test
    void testTransunionCreditCheckWithHighScore()
          throws Exception
    {
        CreditCheckInput creditCheckInput = givenATransunionIntake();
        TransUnionCreditVisionAuth transUnionCreditVisionAuth = givenAuth();
        prepareMock( "transunion/creditWithHighScoreResponse.xml", transUnionCreditVisionAuth );

        CreditCheckResponse creditCheckResponse = whenTheServiceIsCalled( service, creditCheckInput );
        thenCreditReportWithHighScoreIsReturned( creditCheckResponse );
    }


    @Test
    void testTransunionCreditCheckWithConsumerFileNotFound()
          throws Exception
    {
        CreditCheckInput creditCheckInput = givenATransunionIntake();
        TransUnionCreditVisionAuth transUnionCreditVisionAuth = givenAuth();
        prepareMock( "transunion/creditWithConsumerFileNotFound.xml", transUnionCreditVisionAuth );

        CreditCheckResponse creditCheckResponse = whenTheServiceIsCalled( service, creditCheckInput );
        thenCreditReportNotFoundReturned( creditCheckResponse );
    }


    @Test
    void testTransunionCreditWithError()
          throws Exception
    {
        CreditCheckInput creditCheckInput = givenATransunionIntake();
        TransUnionCreditVisionAuth transUnionCreditVisionAuth = givenAuth();
        prepareMock( "transunion/creditScoreWithError.xml", transUnionCreditVisionAuth );

        CreditCheckResponse creditCheckResponse = whenTheServiceIsCalled( service, creditCheckInput );
        thenCreditReportWithErrorReturned( creditCheckResponse );
    }


    @Test
    void testTransunionCreditInsufficientCredit()
          throws Exception
    {
        CreditCheckInput creditCheckInput = givenATransunionIntake();
        TransUnionCreditVisionAuth transUnionCreditVisionAuth = givenAuth();
        prepareMock( "transunion/creditReportWithInsufficientCredit.xml", transUnionCreditVisionAuth );

        CreditCheckResponse creditCheckResponse = whenTheServiceIsCalled( service, creditCheckInput );
        thenCreditReportWithInsufficientCreditReturned( creditCheckResponse );
    }


    @Test
    void testTransunionCreditReportWithMissingScore()
          throws Exception
    {
        CreditCheckInput creditCheckInput = givenATransunionIntake();
        TransUnionCreditVisionAuth transUnionCreditVisionAuth = givenAuth();
        prepareMock( "transunion/creditReportWithMissingScore.xml", transUnionCreditVisionAuth );

        CreditCheckResponse creditCheckResponse = whenTheServiceIsCalled( service, creditCheckInput );
        thenCreditReportWithMissingScoreReturned( creditCheckResponse );
    }


    private void thenCreditReportWithMissingScoreReturned( final CreditCheckResponse creditCheckResponse )
    {
        assertEquals( creditCheckResponse.getCreditScore(), "0" );
        assertEquals( creditCheckResponse.getCreditStatus(), "001" );
        assertEquals( creditCheckResponse.getCreditDescription(), "Local System Error" );
    }


    private void thenCreditReportWithInsufficientCreditReturned( final CreditCheckResponse creditCheckResponse )
    {
        assertEquals( creditCheckResponse.getCreditScore(), "0" );
        assertEquals( creditCheckResponse.getCreditStatus(), "304" );
        assertEquals( creditCheckResponse.getCreditDescription(), "Insufficient Credit" );
    }


    private void thenCreditReportWithErrorReturned( final CreditCheckResponse creditCheckResponse )
    {
        assertEquals( creditCheckResponse.getCreditScore(), "0" );
        assertEquals( creditCheckResponse.getCreditStatus(), "101" );
        assertEquals( creditCheckResponse.getCreditDescription(), "Invalid Request Format" );
    }



    private void thenCreditReportNotFoundReturned( final CreditCheckResponse creditCheckResponse )
    {
        assertEquals( creditCheckResponse.getCreditScore(), "0" );
        assertEquals( creditCheckResponse.getCreditStatus(), "301" );
        assertEquals( creditCheckResponse.getCreditDescription(), "Match Not Found" );
    }


    private void prepareMock( final String filePath,
                              final TransUnionCreditVisionAuth transUnionCreditVisionAuth )
          throws Exception
    {
        RestTemplate restTemplate = mock( RestTemplate.class );
        Mockito.when( service.getAuth( any() ) ).thenReturn( transUnionCreditVisionAuth );
        Mockito.when( restTemplateWithAuth.authRestTemplate( any(), any(), any() ) ).thenReturn( restTemplate );
        ResponseEntity responseEntity = new ResponseEntity<>( JsonFileUtils.loadResourceAs( filePath, String.class ), HttpStatus.OK );

        Mockito.when( restTemplate.exchange( eq( "url" ), eq( HttpMethod.POST ), any(), eq( String.class ) ) ).thenReturn( responseEntity );
    }


    private void thenCreditReportWithHighScoreIsReturned( final CreditCheckResponse creditCheckResponse )
    {
        assertEquals( creditCheckResponse.getCreditScore(), "877" );
        assertEquals( creditCheckResponse.getCreditStatus(), "200" );
        assertEquals( creditCheckResponse.getCreditDescription(), "OK" );
    }


    private CreditCheckResponse whenTheServiceIsCalled( final TransunionServiceImpl transunionService,
                                                        final CreditCheckInput creditCheckInput )
          throws Exception
    {
        return transunionService.checkCreditScore( creditCheckInput );
    }


    private TransUnionCreditVisionAuth givenAuth()
    {
        return TransUnionCreditVisionAuth.builder()
                                         .type( IntegrationType.TRANSUNION_AUTH )
                                         .memberCode( "001" )
                                         .subscriberPassword( "passw0rd" )
                                         .certData( "cert".getBytes() )
                                         .certPassword( "password" )
                                         .industryCode( "001" )
                                         .subscriberPrefixCode( "001" )
                                         .productCode( "07000" )
                                         .processingEnv( "env" )
                                         .url( "url" )
                                         .build();
    }


    private CreditCheckInput givenATransunionIntake()
    {
        Map<String, Object> requestQIDs = new HashMap<>();
        requestQIDs.put( QIDs.FIRST_NAME, "BARBARA" );
        requestQIDs.put( QIDs.LAST_NAME, "CLEMONS" );
        requestQIDs.put( QIDs.DOB, "1985-02-01" );
        requestQIDs.put( QIDs.SOCIAL_SECURITY_NUMBER, "123-45-6789" );
        requestQIDs.put( QIDs.ADDRESS_CLIENT_STREET_1, "13 Street lorem ipsum" );
        requestQIDs.put( QIDs.ADDRESS_CLIENT_CITY, "BERTHOUD" );
        requestQIDs.put( QIDs.ADDRESS_CLIENT_ZIPCODE, "80513" );
        requestQIDs.put( QIDs.ADDRESS_CLIENT_STATE, "CO" );

        return CreditCheckInput.builder()
                               .requestId( UUID.randomUUID() )
                               .intake( requestQIDs )
                               .build();
    }
}

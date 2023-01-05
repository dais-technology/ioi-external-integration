package com.dais.ioi.external.service.transunion;

import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.dais.ioi.external.domain.dto.transunion.AddressDto;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckInput;
import com.dais.ioi.external.domain.dto.transunion.InputDto;
import com.dais.ioi.external.domain.dto.transunion.CreditCheckResponse;
import com.dais.ioi.external.domain.dto.transunion.LocationDto;
import com.dais.ioi.external.domain.dto.transunion.NameDto;
import com.dais.ioi.external.domain.dto.transunion.OptionsDto;
import com.dais.ioi.external.domain.dto.transunion.PermissiblePurposeDto;
import com.dais.ioi.external.domain.dto.transunion.PersonDto;
import com.dais.ioi.external.domain.dto.transunion.ProductDto;
import com.dais.ioi.external.domain.dto.transunion.ResponseInstructionDto;
import com.dais.ioi.external.domain.dto.transunion.SocialSecurityDto;
import com.dais.ioi.external.domain.dto.transunion.StreetDto;
import com.dais.ioi.external.domain.dto.transunion.SubjectDto;
import com.dais.ioi.external.domain.dto.transunion.SubjectIndicativeDto;
import com.dais.ioi.external.domain.dto.transunion.SubjectRecordDto;
import com.dais.ioi.external.domain.dto.transunion.SubscriberDto;
import com.dais.ioi.external.domain.dto.transunion.TransUnionCreditVisionAuth;
import com.dais.ioi.external.domain.dto.transunion.TransactionControlDto;
import com.dais.ioi.external.entity.TransunionAuthEntity;
import com.dais.ioi.external.repository.TransunionCreditRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.time.LocalDate;
import java.util.Map;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class TransunionServiceImpl
      implements TransunionService
{
    @Autowired
    private TransunionCreditRepository repository;

    @Autowired
    @Qualifier( "mapperFacade" )
    private MapperFacade mapperFacade;

    @Autowired
    private RestTemplateWithAuth restTemplateWithAuth;


    @Override
    public CreditCheckResponse checkCreditScore( final CreditCheckInput input )
          throws Exception
    {
        try
        {
            TransUnionCreditVisionAuth auth = getAuth( IntegrationType.TRANSUNION_AUTH );
            Map<String, Object> intake = input.getIntake();

            InputDto inputDto = new InputDto();
            TransactionControlDto transactionControlDto = new TransactionControlDto();
            transactionControlDto.setUserRefNumber( input.getRequestId() );

            SubscriberDto subscriber = new SubscriberDto();
            subscriber.setIndustryCode( auth.getIndustryCode() );
            subscriber.setMemberCode( auth.getMemberCode() );
            subscriber.setInquirySubscriberPrefixCode( auth.getSubscriberPrefixCode() );
            subscriber.setPassword( auth.getSubscriberPassword() );
            transactionControlDto.setSubscriber( subscriber );

            OptionsDto optionsDto = new OptionsDto();
            optionsDto.setProcessingEnvironment( auth.getProcessingEnv() );
            transactionControlDto.setOptions( optionsDto );

            ProductDto productDto = new ProductDto();
            productDto.setCode( auth.getProductCode() );

            SubjectIndicativeDto indicativeDto = new SubjectIndicativeDto();
            NameDto nameDto = new NameDto();
            PersonDto personDto = new PersonDto();
            personDto.setFirstName( (String) intake.get( QIDs.FIRST_NAME ) );
            personDto.setLastName( (String) intake.get( QIDs.LAST_NAME ) );

            nameDto.setPerson( personDto );

            String streetAddress = (String) intake.get( QIDs.ADDRESS_CLIENT_STREET_1 );
            final String[] splitAddress = StringUtils.split( streetAddress, " ", 2 );
            if ( splitAddress.length != 2 )
            {
                throw new IllegalArgumentException( String.format( "Unknown street address format! Could not split " + streetAddress + " into 2 parts!" ) );
            }

            StreetDto streetDto = new StreetDto();
            streetDto.setStreetNumber( splitAddress[0] );
            streetDto.setStreetName( splitAddress[1] );

            AddressDto addressDto = new AddressDto();
            addressDto.setStreet( streetDto );

            LocationDto locationDto = new LocationDto();
            locationDto.setCity( (String) intake.get( QIDs.ADDRESS_CLIENT_CITY ) );
            locationDto.setState( (String) intake.get( QIDs.ADDRESS_CLIENT_STATE ) );
            locationDto.setZipCode( (String) intake.get( QIDs.ADDRESS_CLIENT_ZIPCODE ) );

            addressDto.setLocation( locationDto );

            SocialSecurityDto socialSecurityDto = new SocialSecurityDto();
            socialSecurityDto.setSocialNumber( ( (String) intake.get( QIDs.SOCIAL_SECURITY_NUMBER ) ).replace( "-", "" ) );

            indicativeDto.setSocialSecurity( socialSecurityDto );
            indicativeDto.setName( nameDto );
            indicativeDto.setAddress( addressDto );
            indicativeDto.setDateOfBirth( LocalDate.parse( (String) intake.get( QIDs.DOB ) ) );

            SubjectRecordDto subjectRecordDto = new SubjectRecordDto();
            subjectRecordDto.setIndicative( indicativeDto );

            SubjectDto subjectDto = new SubjectDto();
            subjectDto.setSubjectRecord( subjectRecordDto );

            productDto.setSubject( subjectDto );
            ResponseInstructionDto responseInstructionDto = new ResponseInstructionDto();
            productDto.setResponseInstructions( responseInstructionDto );
            PermissiblePurposeDto permissiblePurposeDto = new PermissiblePurposeDto();
            productDto.setPermissiblePurpose( permissiblePurposeDto );

            inputDto.setProduct( productDto );
            inputDto.setTransactionControl( transactionControlDto );
            String transunionRequest = buildTransunionRequest( inputDto );


            HttpHeaders headers = new HttpHeaders();
            headers.setContentType( MediaType.APPLICATION_XML );
            HttpEntity<String> entity = new HttpEntity<>( transunionRequest, headers );
            RestTemplate restTemplate = restTemplateWithAuth.authRestTemplate( auth.getCertData(), auth.getCertPassword(), auth.getServerCert() );

            ResponseEntity<String> responseEntity = restTemplate.exchange( auth.getUrl(), HttpMethod.POST, entity, String.class );
            return parseResponse( responseEntity.getBody(), input.getRequestId() );

        } catch ( Exception e )
        {
           log.info( "Transunion credit check call for request id :" + input.getRequestId() + " failed with exception: " + e);
           throw e;
        }
    }


    @Override
    public void saveAuth( final TransUnionCreditVisionAuth creditVisionAuth,
                          final MultipartFile p12certFile )
          throws IOException
    {
        creditVisionAuth.setCertData( p12certFile.getBytes() );
        TransunionAuthEntity authEntity = mapperFacade.map( creditVisionAuth, TransunionAuthEntity.class );
        repository.saveAndFlush( authEntity );
    }


    @Override
    public TransUnionCreditVisionAuth getAuth( final IntegrationType type )
    {
        TransunionAuthEntity authEntity = repository.getTransunionAuthEntitiesByType( type );
        return mapperFacade.map( authEntity, TransUnionCreditVisionAuth.class );
    }


    private String buildTransunionRequest( final InputDto inputDto )
          throws JAXBException
    {

        final JAXBContext jaxbContext = JAXBContext.newInstance( InputDto.class );
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        final StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal( inputDto, sw );
        return sw.toString();
    }


    private CreditCheckResponse parseResponse( final String response,
                                               final UUID requestId )
    {
        String creditScore = "0";
        CreditStatus status = CreditStatus.SYSTEM_ERROR;

        try
        {
            final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setFeature( XMLConstants.FEATURE_SECURE_PROCESSING, true );
            factory.setNamespaceAware( true );

            final DocumentBuilder builder = factory.newDocumentBuilder();
            final InputStream targetStream = new ByteArrayInputStream( response.getBytes() );
            final Document doc = builder.parse( targetStream );

            final NodeList errorsList = doc.getElementsByTagName( "error" );
            final NodeList addOnProducts = doc.getElementsByTagName( "addOnProduct" );

            if ( errorsList.getLength() > 0 )
            {
                final Element errorElement = (Element) errorsList.item( 0 );
                final Element errorCode = (Element) errorElement.getElementsByTagName( "code" ).item( 0 );
                final Element errorDescription = (Element) errorElement.getElementsByTagName( "description" ).item( 0 );
                status = errorToCreditStatus( errorCode.getTextContent(), errorDescription.getTextContent() );
            }
            else if ( addOnProducts.getLength() > 0 )
            {
                for ( int i = 0; i < addOnProducts.getLength(); i++ )
                {
                    final Element addOnProduct = (Element) addOnProducts.item( i );

                    final Element results = traverse( addOnProduct, "scoreModel/score/results" );
                    final String rawScore = results.getTextContent();

                    if ( "+".equalsIgnoreCase( rawScore ) )
                    {
                        final String noScoreReason = traverse( addOnProduct, "scoreModel/score/noScoreReason" ).getTextContent();

                        if ( "insufficientCredit".equalsIgnoreCase( noScoreReason ) )
                        {
                            status = CreditStatus.INSUFFICIENT_CREDIT;
                        }
                        else
                        {
                            log.warn( String.format( "[%s] Unknown Credit Status Reason: %s", requestId, noScoreReason ) );
                            status = CreditStatus.UNAVAILABLE;
                        }
                    }
                    else
                    {
                        final int rawScoreAsInt = Integer.parseInt( rawScore );

                        if ( rawScoreAsInt >= 300 && rawScoreAsInt <= 900 )
                        {
                            creditScore = rawScore.replace( "+", "" );
                            status = CreditStatus.OK;
                        }
                        else
                        {
                            status = specialScoreToCreditStatus( rawScoreAsInt );
                        }
                    }

                    log.info( String.format( "[%s] Credit Vision Credit Score: [%s] -> [%s] %s", requestId, rawScore, creditScore, status.getDescription() ) );
                    break;
                }
            }
        }
        catch ( final Exception e )
        {
            status = CreditStatus.SYSTEM_ERROR_LOCAL;
            log.error( String.format( "[%s] Error while parsing response! %s", requestId, e.getClass().getSimpleName() ) );
        }

        CreditCheckResponse creditCheckResponse = new CreditCheckResponse();
        creditCheckResponse.setCreditScore( creditScore );
        creditCheckResponse.setCreditStatus( status.getStatus() );
        creditCheckResponse.setCreditDescription( status.getDescription() );

        return creditCheckResponse;
    }


    private CreditStatus errorToCreditStatus( final String code,
                                              final String description )
    {
        log.warn( "Error from TransUnion, code: {}, description: {}", code, description );
        switch ( code.charAt( 0 ) )
        {
            case '0':
                return CreditStatus.SYSTEM_ERROR_REMOTE;
            case '1':
            case '9':
                return CreditStatus.INVALID_REQUEST_FORMAT;
            case '2':
            case '3':
                return CreditStatus.INVALID_REQUEST_CONFIGURATION;
            case '4':
                return CreditStatus.INVALID_REQUEST_DATA;
            default:
                return CreditStatus.UNKNOWN_DATA_ERROR;
        }
    }


    private CreditStatus specialScoreToCreditStatus( final int creditScoreResult )
    {
        switch ( creditScoreResult )
        {
            case 0:
                return CreditStatus.DECEASED;
            case 1:
                return CreditStatus.NOT_FOUND;
            case 2:
                return CreditStatus.RESTRICTED;
            default:
                log.warn( "TU special score: {} not recognized!", creditScoreResult );
                return CreditStatus.UNAVAILABLE;
        }
    }


    private Element getFirstElementByTag( final Element root,
                                          final String tag )
    {
        final NodeList elementsByTagName = root.getElementsByTagName( tag );
        return ( elementsByTagName.getLength() > 0 ) ? (Element) elementsByTagName.item( 0 ) : null;
    }


    private Element traverse( final Element root,
                              final String path )
    {
        Element currentElement = root;

        for ( final String pathSegment : path.split( "/" ) )
        {
            currentElement = getFirstElementByTag( currentElement, pathSegment );

            if ( currentElement == null )
            {
                final String notFoundWarning = String.format( "Element [%s] of path [%s] not found in Element [%s]", pathSegment, path, currentElement.getTagName() );
                log.warn( notFoundWarning );
                throw new NullPointerException( notFoundWarning );
            }
        }

        return currentElement;
    }
}

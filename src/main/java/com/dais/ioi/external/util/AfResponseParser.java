package com.dais.ioi.external.util;

import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.enums.ContentScopeType;
import com.dais.ioi.quote.domain.dto.pub.PubMessageDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumDto;
import com.dais.ioi.quote.domain.dto.pub.PubQuoteDetailsDto;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Slf4j
public class AfResponseParser
{

    public QuoteDto parseResponse( String response )
          throws ParserConfigurationException, IOException, SAXException
    {
        final DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        final InputStream targetStream = new ByteArrayInputStream( response.getBytes() );
        final Document doc = builder.parse( targetStream );
        final QuoteDto quoteDto = new QuoteDto();
        final PubQuoteDetailsDto pubQuoteDetailsDto = new PubQuoteDetailsDto();
        final List<PubMessageDto> pubMessageDto = new ArrayList<>();

        String statusCd = doc.getElementsByTagName( "StatusCd" ).item( 0 ).getTextContent();
        pubMessageDto.add( PubMessageDto.builder().type( ContentScopeType.CONSUMER )
                                        .message( "status code : " + statusCd ).build() );

        if ( doc.getElementsByTagName( "Desc" ).item( 0 ) != null )
        {
            String desc = doc.getElementsByTagName( "Desc" ).item( 0 ).getTextContent();
            pubMessageDto.add( PubMessageDto.builder().type( ContentScopeType.CONSUMER )
                                            .message( "status description : " + desc ).build() );
        }

        try
        {
            String premium = doc.getElementsByTagName( "Amt" ).item( 0 ).getTextContent();
            PubPremiumDto pubPremiumDto = PubPremiumDto.builder()
                                                       .amount( new BigDecimal( premium ) )
                                                       .build();
            pubQuoteDetailsDto.setPremium( pubPremiumDto );
        }
        catch ( Exception e )
        {
            log.info( "Af quote failed" );
            pubQuoteDetailsDto.setPremium( PubPremiumDto.builder().amount( BigDecimal.ONE.negate() ).build() );
        }

        quoteDto.setMessages( pubMessageDto );
        quoteDto.setQuoteDetails( pubQuoteDetailsDto );

        return quoteDto;
    }
}

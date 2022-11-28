package com.dais.ioi.external.util;

import com.dais.ioi.quote.domain.dto.QuoteDto;
import com.dais.ioi.quote.domain.dto.pub.PubMessageDto;
import com.dais.ioi.quote.domain.dto.pub.PubPremiumDto;
import com.dais.utils.test.JsonFileUtils;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AfResponseParserTest
{

    @Test
    public void quoteReturnsPremium_parsePremium()
          throws IOException, ParserConfigurationException, SAXException
    {
        String response = givenAfResponse();
        AfResponseParser parser = givenAfResponseParser();
        QuoteDto quoteDto = whenParserIsCalled( parser, response );
        thenPremiumIsReturned( quoteDto );
    }


    @Test
    public void quoteReturnsNoPremium_returnQuoteDtoWithNoPremium()
          throws IOException, ParserConfigurationException, SAXException
    {
        String response = givenAfResponseWithNoPremium();
        AfResponseParser parser = givenAfResponseParser();
        QuoteDto quoteDto = whenParserIsCalled( parser, response );
        thenNoPremiumIsReturned( quoteDto );
    }


    private void thenNoPremiumIsReturned( final QuoteDto quoteDto )
    {
        PubPremiumDto premium = quoteDto.getQuoteDetails().getPremium();
        List<PubMessageDto> messageDto = quoteDto.getMessages();

        assertEquals( BigDecimal.ONE.negate(), premium.getAmount() );
        assertEquals( "status code : DECLINE", messageDto.get( 0 ).getMessage() );
        assertEquals( "status description : Level of Touch=No", messageDto.get( 1 ).getMessage() );
    }


    private String givenAfResponseWithNoPremium()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "util/AfResponseParserTestData/responseWithNoPremium.xml", String.class );
    }


    private void thenPremiumIsReturned( final QuoteDto quoteDto )
    {
        PubPremiumDto premium = quoteDto.getQuoteDetails().getPremium();
        List<PubMessageDto> messageDto = quoteDto.getMessages();

        assertEquals( new BigDecimal( "43283.00" ), premium.getAmount() );
        assertEquals( "status code : QUOTED", messageDto.get( 0 ).getMessage() );
    }


    private QuoteDto whenParserIsCalled( final AfResponseParser parser,
                                         final String response )
          throws ParserConfigurationException, IOException, SAXException
    {
        return parser.parseResponse( response );
    }


    private AfResponseParser givenAfResponseParser()
    {
        return new AfResponseParser();
    }


    private String givenAfResponse()
          throws IOException
    {
        return JsonFileUtils.loadResourceAs( "util/AfResponseParserTestData/response.xml", String.class );
    }
}

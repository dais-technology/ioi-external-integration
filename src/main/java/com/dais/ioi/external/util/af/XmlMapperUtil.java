package com.dais.ioi.external.util.af;

import com.dais.ioi.external.domain.dto.af.QuoteDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;


public class XmlMapperUtil
{
    private XmlMapper mapper = new XmlMapper();


    public String buildXml( final QuoteDto quoteDto )
          throws JsonProcessingException
    {
        mapper.setSerializationInclusion( JsonInclude.Include.NON_EMPTY );
        mapper.registerModule( new JaxbAnnotationModule() );
        mapper.registerModule( new JavaTimeModule() );
        mapper.configure( SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false );
        mapper.configure( ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true );

        return mapper.writeValueAsString( quoteDto );
    }
}

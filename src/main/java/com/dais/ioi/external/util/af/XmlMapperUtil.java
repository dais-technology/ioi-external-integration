package com.dais.ioi.external.util.af;

import com.dais.ioi.external.domain.dto.af.ACORD;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;


public class XmlMapperUtil
{
    public String buildXml( final ACORD acord )
          throws JAXBException
    {

        final JAXBContext jaxbContext = JAXBContext.newInstance( ACORD.class );
        final Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE );
        final StringWriter sw = new StringWriter();
        jaxbMarshaller.marshal( acord, sw );
        return sw.toString();
    }
}

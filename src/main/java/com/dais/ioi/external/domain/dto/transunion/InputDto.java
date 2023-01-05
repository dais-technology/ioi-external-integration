package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement( name = "creditBureau" )
@XmlAccessorType( XmlAccessType.FIELD)
public class InputDto
      implements Serializable
{
    @XmlAttribute
    @Builder.Default
    private String xmlns = "http://www.transunion.com/namespace";

    @XmlAttribute( name = "xsi:schemaLocation")
    @Builder.Default
    private String schemaLocation = "http://www.transunion.com/namespace";

    @XmlAttribute( name = "xmlns:xsi")
    @Builder.Default
    private String xsi = "http://www.w3.org/2001/XMLSchema-instance";

    @Builder.Default
    private String document = "request";

    @Builder.Default
    private String version = "2.31";

    private TransactionControlDto transactionControl;

    private ProductDto product;
}

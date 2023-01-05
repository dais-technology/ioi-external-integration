package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType( XmlAccessType.FIELD)
public class StreetDto
{
    @XmlElement( name = "number" )
    private String streetNumber;

    @XmlElement( name = "name" )
    private String streetName;
}

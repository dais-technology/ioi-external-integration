package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommunicationsDto
{
    @JacksonXmlProperty( localName = "PhoneInfo" )
    private PhoneDto phoneDto;

    @JacksonXmlProperty( localName = "EmailInfo" )
    private EmailDto emailDto;

    @JacksonXmlProperty( localName = "WebsiteInfo" )
    private WebsiteDto websiteDto;
}

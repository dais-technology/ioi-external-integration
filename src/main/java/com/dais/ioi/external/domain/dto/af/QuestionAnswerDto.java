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
public class QuestionAnswerDto
{
    @JacksonXmlProperty( localName = "QuestionCd" )
    private String questionCd;

    @JacksonXmlProperty( localName = "YesNoCd" )
    private String responseCd;

    @JacksonXmlProperty( localName = "Explanation" )
    private String explanation;
}

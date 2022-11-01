package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClassCodeQuestionDto
{
    @JacksonXmlProperty( localName = "QuestionId" )
    private String questionId;

    @JacksonXmlProperty( localName = "QuestionCd" )
    private String questionCd;

    @JacksonXmlProperty( localName = "ResponseInd" )
    private String responseInd;

    @JacksonXmlProperty( localName = "PercentageAnswerValue" )
    private Integer percentageAnswerValue;

    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "OptionResponse" )
    private List<OptionResponseDto> optionResponseDto;
}

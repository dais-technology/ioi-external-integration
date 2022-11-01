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
public class IneligibilityDto
{
    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "QuestionAnswer" )
    private List<QuestionAnswerDto> questionAnswerDto;
}

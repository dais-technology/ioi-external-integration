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
public class ClassCodeQuestionsDto
{
    @JacksonXmlElementWrapper( useWrapping = false )
    @JacksonXmlProperty( localName = "ClassCodeQuestion" )
    private List<ClassCodeQuestionDto> classCodeQuestionDto;
}

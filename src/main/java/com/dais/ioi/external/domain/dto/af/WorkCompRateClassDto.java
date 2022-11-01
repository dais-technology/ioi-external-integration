package com.dais.ioi.external.domain.dto.af;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkCompRateClassDto
{
    @JacksonXmlProperty( localName = "RatingClassificationCd" )
    private Integer ratingClassificationCd;

    @JacksonXmlProperty( localName = "RatingClassificationLetter" )
    private String ratingClassificationLetter;

    @JacksonXmlProperty( localName = "RatingClassificationSubCd" )
    private String ratingClassificationSubCd;

    @JacksonXmlProperty( localName = "Exposure" )
    private BigDecimal payrollAmount;

    @JacksonXmlProperty( localName = "ClassCodeQuestions" )
    private ClassCodeQuestionsDto classCodeQuestionsDto;
}

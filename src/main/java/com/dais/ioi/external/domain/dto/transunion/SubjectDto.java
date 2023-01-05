package com.dais.ioi.external.domain.dto.transunion;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubjectDto
{
    @Builder.Default
    private String number = "1";

    private SubjectRecordDto subjectRecord;
}

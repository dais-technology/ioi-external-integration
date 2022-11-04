package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadAppraisalResponse
{
    private String id;

    private String description;

    private Integer pageNumber;

    private Integer version;

    private Boolean isFileSafe;
}

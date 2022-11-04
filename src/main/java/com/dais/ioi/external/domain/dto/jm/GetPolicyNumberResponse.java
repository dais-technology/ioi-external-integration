package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetPolicyNumberResponse
{
    private String policyNumber;

    private Boolean tryAnotherGet;

    private Integer status;

    private List<String> errorList;
}

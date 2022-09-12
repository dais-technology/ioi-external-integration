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
public class CreateAccountResponse
{
    private String accountNumber;

    private Boolean canCollectPayment;

    private List<String> errorList;

}

package com.dais.ioi.external.domain.dto.jm;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CreateAccountResponse
{
    private String accountNumber;

    private Boolean canCollectPayment;

    private List<String> errorList;

}

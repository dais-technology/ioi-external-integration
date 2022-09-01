package com.dais.ioi.external.domain.dto.jm;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class CreateAccountRequest
{

    private UUID quoteId;

}

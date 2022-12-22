package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.external.domain.dto.BaseSourceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateAccountRequest
      extends BaseSourceDto
{
    //JM quoteId
    @NonNull
    private UUID quoteId;

}

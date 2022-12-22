package com.dais.ioi.external.domain.dto.jm;

import com.dais.ioi.external.domain.dto.BaseSourceDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DownloadApplicationRequest
      extends BaseSourceDto
{
    @NonNull
    private String accountNumber;

    @NonNull
    private String lastName;

    @NonNull
    private String postalCode;
}

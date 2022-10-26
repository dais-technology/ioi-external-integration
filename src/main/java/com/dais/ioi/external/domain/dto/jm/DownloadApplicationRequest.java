package com.dais.ioi.external.domain.dto.jm;

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
{
    @NonNull
    private String accountNumber;

    @NonNull
    private String lastName;

    @NonNull
    private String postalCode;
}

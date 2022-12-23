package com.dais.ioi.external.domain.dto.jm;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class DownloadApplicationRequest extends JmBaseDto
{
    @NonNull
    private String accountNumber;

    @NonNull
    private String lastName;

    @NonNull
    private String postalCode;
}

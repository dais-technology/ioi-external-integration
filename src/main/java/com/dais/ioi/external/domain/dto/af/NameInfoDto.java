package com.dais.ioi.external.domain.dto.af;

import com.dais.ioi.external.domain.dto.internal.enums.af.LegalEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NameInfoDto
{
    private String id;

    private PersonNameDto personNameDto;

    private CommlNameDto commlNameDto;

    private LegalEntity legalEntityCd;

    private TaxIdentityDto taxIdentityDto;
}

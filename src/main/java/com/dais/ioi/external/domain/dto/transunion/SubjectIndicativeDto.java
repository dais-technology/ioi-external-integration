package com.dais.ioi.external.domain.dto.transunion;

import com.dais.ioi.external.util.LocalDateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlAccessorType( XmlAccessType.FIELD)
public class SubjectIndicativeDto
{
    private NameDto name;

    private AddressDto address;

    private SocialSecurityDto socialSecurity;

    @XmlJavaTypeAdapter( value = LocalDateAdapter.class )
    private LocalDate dateOfBirth;

    @Builder.Default
    private String driversLicense = "";
}

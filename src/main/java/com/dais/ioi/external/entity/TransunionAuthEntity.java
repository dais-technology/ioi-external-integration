package com.dais.ioi.external.entity;

import com.dais.common.persistence.entity.base.BaseIdEntity;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table( name = "transunion_auth" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@EqualsAndHashCode( callSuper = false )
public class TransunionAuthEntity
      extends BaseIdEntity
{
    @Column( name = "type" )
    @Enumerated( EnumType.STRING )
    @NotNull
    private IntegrationType type;

    @Column( name = "member_code" )
    @NotNull
    private String memberCode;

    @Column( name = "subscriber_password" )
    @NotNull
    private String subscriberPassword;

    @Column( name = "cert_data" )
    @NotNull
    private byte[] certData;

    @Column( name = "cert_password" )
    @NotNull
    private String certPassword;

    @Column( name = "industry_code" )
    @NotNull
    private String industryCode;

    @Column( name = "subscriber_prefix_code" )
    @NotNull
    private String subscriberPrefixCode;

    @Column( name = "product_code" )
    @NotNull
    private String productCode;

    @Column( name = "env" )
    @NotNull
    private String processingEnv;

    @Column( name = "server_cert" )
    @NotNull
    private byte[] serverCert;

    @Column( name = "url" )
    @NotNull
    private String url;
}

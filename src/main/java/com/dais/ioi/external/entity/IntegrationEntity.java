package com.dais.ioi.external.entity;

import com.dais.common.persistence.entity.base.BaseIdEntity;
import com.dais.ioi.external.domain.dto.internal.enums.IntegrationType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;


@Entity
@Table( name = "integration" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@TypeDef( name = "jsonb",
          typeClass = JsonBinaryType.class )
@EqualsAndHashCode( callSuper = false )
public class IntegrationEntity
      extends BaseIdEntity
{
    @Column( name = "line_id" )
    @NotNull
    private UUID lineId;

    @Column( name = "type" )
    @Enumerated( EnumType.STRING )
    @NotNull
    private IntegrationType type;

    @Column( name = "usage" )
    private String usage;

    @Column( name = "description" )
    private String description;

    @Column( name = "spec",
             columnDefinition = "jsonb" )
    @Type( type = "jsonb" )
    private Map<String, ?> spec;
}
package com.dais.ioi.external.entity;

import com.dais.common.persistence.entity.base.BaseIdEntity;
import com.dais.ioi.external.domain.dto.internal.enums.CounterType;
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


@Entity
@Table( name = "count" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@TypeDef( name = "jsonb",
          typeClass = JsonBinaryType.class )
@EqualsAndHashCode( callSuper = true )
public class CountEntity
      extends BaseIdEntity
{
    @Column( name = "type" )
    @Enumerated( EnumType.STRING )
    @NotNull
    private CounterType type;

    @Column( name = "key",
             columnDefinition = "jsonb" )
    @Type( type = "jsonb" )
    private Map<String, ?> key;
}

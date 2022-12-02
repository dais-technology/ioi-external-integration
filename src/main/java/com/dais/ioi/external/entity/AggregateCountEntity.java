package com.dais.ioi.external.entity;

import com.dais.common.persistence.entity.base.BaseIdEntity;
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
import javax.persistence.Table;
import java.util.Map;


@Entity
@Table( name = "aggregate_count" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@TypeDef( name = "jsonb",
          typeClass = JsonBinaryType.class )
@EqualsAndHashCode( callSuper = false )
public class AggregateCountEntity
      extends BaseIdEntity
{
    @Column( name = "key",
             columnDefinition = "jsonb" )
    @Type( type = "jsonb" )
    private Map<String, ?> key;

    @Column( name = "count" )
    private int count;
}

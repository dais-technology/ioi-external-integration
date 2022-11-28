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
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;


@Entity
@Table( name = "external_quote_data" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@TypeDef( name = "jsonb",
          typeClass = JsonBinaryType.class )
@EqualsAndHashCode( callSuper = false )
public class ExternalQuoteDataEntity
      extends BaseIdEntity
{
    @Column( name = "external_quote_id" )
    @NotNull
    private String externalQuoteId;

    @Column( name = "quote_request_id" )
    //ioi-quote-service requestId;
    private UUID quoteId;

    @Column( name = "quote_data",
             columnDefinition = "jsonb" )
    @Type( type = "jsonb" )
    private Map<String, ?> quoteData;

    @Column( name = "client_id" )
    private UUID clientId;
}

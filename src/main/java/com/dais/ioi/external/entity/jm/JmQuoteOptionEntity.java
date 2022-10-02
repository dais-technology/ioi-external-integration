package com.dais.ioi.external.entity.jm;

import com.dais.common.persistence.entity.base.BaseIdEntity;
import com.dais.ioi.quote.domain.dto.QuoteDto;
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
import java.time.OffsetDateTime;
import java.util.UUID;


@Entity
@Table( name = "jm_quote_option" )
@NoArgsConstructor
@Data
@Builder
@AllArgsConstructor
@TypeDef( name = "jsonb",
          typeClass = JsonBinaryType.class )
@EqualsAndHashCode( callSuper = false )
public class JmQuoteOptionEntity
      extends BaseIdEntity
{
    @Column( name = "line_id" )
    @NotNull
    private UUID lineId;

    @Column( name = "client_id" )
    @NotNull
    private UUID clientId;

    @Type( type = "jsonb" )
    @Column( name = "quote_option",
             columnDefinition = "jsonb" )
    private QuoteDto quoteOption;

    @Column( name = "intake_key",
             columnDefinition = "TEXT" )
    @NotNull
    private String intakeKey;

    @Column( name = "submission_ts",
             columnDefinition = "timestamp with time zone",
             nullable = false )
    @NotNull
    @Type( type = "java.time.OffsetDateTime" )
    private OffsetDateTime submissionDate;
}

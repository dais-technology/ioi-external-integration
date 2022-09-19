CREATE TABLE external_quote_data (
    id                UUID PRIMARY KEY,
    external_quote_id char varying(255)        NOT NULL,
    quote_request_id  uuid,
    quote_data        jsonb,
    
    app_id            char varying(255),
    tenant_id         uuid,
    created_by        uuid,
    modified_by       uuid,
    created_ts        timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts        timestamp with time zone NOT NULL DEFAULT now( ),
    
    
    UNIQUE ( external_quote_id )
);
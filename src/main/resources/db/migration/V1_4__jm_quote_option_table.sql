CREATE TABLE jm_quote_option (
    line_id       uuid                     NOT NULL,
    client_id     uuid                     NOT NULL,
    quote_option  jsonb                    NOT NULL,
    intake_key    text                     NOT NULL,
    submission_ts timestamp with time zone,
    
    id            UUID PRIMARY KEY,
    app_id        char varying(255),
    tenant_id     uuid,
    created_by    uuid,
    modified_by   uuid,
    created_ts    timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts    timestamp with time zone NOT NULL DEFAULT now( ),
    
    
    UNIQUE ( line_id, client_id )
);
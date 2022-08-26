CREATE TABLE integration (
    id              UUID PRIMARY KEY,
    organization_id uuid                     NOT NULL,
    type            char varying(65)         NOT NULL,
    spec            jsonb,
    
    app_id          char varying(255),
    tenant_id       uuid,
    created_by      uuid,
    modified_by     uuid,
    created_ts      timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts      timestamp with time zone NOT NULL DEFAULT now( ),
    
    
    UNIQUE ( organization_id, type )
);
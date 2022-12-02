CREATE TABLE count (
    id          UUID PRIMARY KEY,
    type        char varying(65)         NOT NULL,
    key         jsonb                    NOT NULL,
    
    app_id      char varying(255),
    tenant_id   uuid,
    created_by  uuid,
    modified_by uuid,
    created_ts  timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts  timestamp with time zone NOT NULL DEFAULT now( )
);

CREATE TABLE aggregate_count (
    id          UUID PRIMARY KEY,
    count       integer                  NOT NULL,
    key         jsonb                    NOT NULL,
    
    app_id      char varying(255),
    tenant_id   uuid,
    created_by  uuid,
    modified_by uuid,
    created_ts  timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts  timestamp with time zone NOT NULL DEFAULT now( )
);
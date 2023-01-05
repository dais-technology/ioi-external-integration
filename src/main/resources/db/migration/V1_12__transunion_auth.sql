CREATE TABLE transunion_auth (
    id UUID PRIMARY KEY,
    type char varying(65) NOT NULL,
    member_code char varying(65) NOT NULL,
    subscriber_password char varying(255) NOT NULL,
    cert_data bytea NOT NULL,
    cert_password char varying(255) NOT NULL,
    industry_code char varying(65) NOT NULL,
    subscriber_prefix_code char varying(65) NOT NULL,
    product_code char varying(65) NOT NULL,
    env char varying(65) NOT NULL,
    server_cert bytea NOT NULL,
    url char varying(255) NOT NULL,

    app_id            char varying(255),
    tenant_id         uuid,
    created_by        uuid,
    modified_by       uuid,
    created_ts        timestamp with time zone NOT NULL DEFAULT now( ),
    updated_ts        timestamp with time zone NOT NULL DEFAULT now( )
    
);
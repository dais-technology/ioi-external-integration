ALTER TABLE integration
    ADD COLUMN usage char varying(128) NULL,
    ADD COLUMN description char varying(1024) NULL,
    DROP CONSTRAINT integration_organization_id_type_key,
    ADD CONSTRAINT integration_organization_id_usage_type_key UNIQUE ( organization_id, usage, type );

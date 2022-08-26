--wrap in transaction
BEGIN
TRANSACTION;

--drop existing schema (and tables) if they exist
DROP SCHEMA IF EXISTS ${SCHEMA} CASCADE;

--reproduce schema creation and authorization laid out in README of template
CREATE SCHEMA ${SCHEMA} AUTHORIZATION ${DB_OWNER};
ALTER
SCHEMA
${SCHEMA}
OWNER
TO
${DB_OWNER};
ALTER
ROLE
${DB_OWNER}
SET
search_path
TO
'${SCHEMA}',
'public';

COMMIT TRANSACTION;

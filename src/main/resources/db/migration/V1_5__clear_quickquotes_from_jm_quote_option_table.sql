delete
from jm_quote_option
where line_id in ( SELECT organization_id
                   FROM integration i
                   where i."type" = 'JM_QUICKQUOTE' );
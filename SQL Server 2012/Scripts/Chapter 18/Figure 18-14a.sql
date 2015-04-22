SELECT name, principal_id, is_fixed_role
FROM sys.server_principals
WHERE type = 'R';
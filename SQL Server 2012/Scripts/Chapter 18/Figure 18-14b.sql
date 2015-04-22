SELECT member_principal_id, name
FROM sys.server_role_members AS srm
JOIN sys.server_principals AS sp
  ON srm.member_principal_id = sp.principal_id
WHERE srm.role_principal_id = 267;
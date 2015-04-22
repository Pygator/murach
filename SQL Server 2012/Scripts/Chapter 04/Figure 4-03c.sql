-- This creates a linked server named DBServer 
-- using the SQL Native Client OLE DB provider (SQLNCLI).
-- on an instance of SQL Server Express
-- that's running on the local computer

USE master;

EXEC sp_addlinkedserver   
   @server='DBServer', 
   @srvproduct='',
   @provider='SQLNCLI', 
   @datasrc='localhost\SqlExpress';


/*
Be sure you log in using your Windows account
before running this script.
*/

USE AP;

-- Clean up test users and roles
DROP APPLICATION ROLE AppInvoiceQuery;
DROP USER TestAppRole;
DROP LOGIN TestAppRole;
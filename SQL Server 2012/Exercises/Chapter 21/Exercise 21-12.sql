USE AP;

-- drop the stored procedure
IF OBJECT_ID('GetTop10Vendors') IS NOT NULL
    DROP PROC GetTop10Vendors;

-- drop the assembly
IF ASSEMBLYPROPERTY('ApClrObjects', 'SimpleName') IS NOT NULL
    DROP ASSEMBLY ApClrObjectsEx;
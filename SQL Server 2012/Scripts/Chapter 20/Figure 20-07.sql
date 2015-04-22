USE master;

-- if necessary, drop the MusicStore database
IF EXISTS(SELECT * FROM sys.databases WHERE name = 'MusicStore')
    DROP DATABASE MusicStore;

CREATE DATABASE MusicStore
ON PRIMARY
(
    NAME = MusicStore,
    FILENAME = 'C:\Murach\SQL Server 2012\Databases\MusicStore.mdf'
),
FILEGROUP FileStreamImages CONTAINS FILESTREAM DEFAULT
(
    NAME = MusicStoreImages,
    FILENAME = 'C:\Murach\SQL Server 2012\Databases\MusicStore_images'
);
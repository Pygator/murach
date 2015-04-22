USE MusicStore;

-- Drop table and recreate it so it's ready for new data

IF OBJECT_ID('ProductImages') IS NOT NULL
    DROP TABLE ProductImages;

CREATE TABLE ProductImages
(
    ImageID int PRIMARY KEY IDENTITY,
    ProductID int NOT NULL,
    RowID uniqueidentifier ROWGUIDCOL NOT NULL UNIQUE DEFAULT NEWID(), 
    ProductImage varbinary(max) FILESTREAM NOT NULL
);

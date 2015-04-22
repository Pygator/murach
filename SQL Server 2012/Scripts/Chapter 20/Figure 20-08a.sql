USE MusicStore;

IF OBJECT_ID('ProductImages') IS NOT NULL
    DROP TABLE ProductImages;

CREATE TABLE ProductImages
(
    ImageID int PRIMARY KEY IDENTITY,
    ProductID int NOT NULL,
    RowID uniqueidentifier ROWGUIDCOL NOT NULL UNIQUE DEFAULT NEWID(), 
    ProductImage varbinary(max) FILESTREAM NOT NULL
);

INSERT INTO ProductImages (ProductID, ProductImage)
VALUES (1, 0);

INSERT INTO ProductImages 
VALUES (2, NEWID(), 0);

INSERT INTO ProductImages 
VALUES (3, NEWID(), CAST('0123456789ABC' AS varbinary(max)));

SELECT * FROM ProductImages;
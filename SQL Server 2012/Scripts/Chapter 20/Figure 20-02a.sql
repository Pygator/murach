USE Examples;

-- if necessary, drop the ProductImages table
IF OBJECT_ID('ProductImages') IS NOT NULL
    DROP TABLE ProductImages;

-- create the ProductImages table
CREATE TABLE ProductImages
(
    ImageID int PRIMARY KEY IDENTITY,
    ProductID int NOT NULL,
    ProductImage varbinary(max)
);

INSERT INTO ProductImages VALUES (1, NULL);

INSERT INTO ProductImages VALUES (2, 0);

INSERT INTO ProductImages 
VALUES (3, CAST('0123456789ABCDEF' AS varbinary(max)));

INSERT INTO ProductImages 
VALUES (4, NULL);

UPDATE ProductImages
SET ProductImage = 0
WHERE ImageID = 4;

DELETE FROM ProductImages
WHERE ImageID = 4;

SELECT * FROM ProductImages;
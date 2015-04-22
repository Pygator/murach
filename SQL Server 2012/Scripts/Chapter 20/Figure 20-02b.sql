USE Examples;

-- Drop table and recreate it so it's ready for new data

IF OBJECT_ID('ProductImages') IS NOT NULL
    DROP TABLE ProductImages;

CREATE TABLE ProductImages
(
    ImageID int PRIMARY KEY IDENTITY,
    ProductID int NOT NULL,
    ProductImage varbinary(max) NOT NULL
);

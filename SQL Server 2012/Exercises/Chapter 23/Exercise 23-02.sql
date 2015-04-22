CREATE TABLE Parts(
    PartID int NOT NULL IDENTITY PRIMARY KEY,
    PartNumber varchar(20) NOT NULL,
    Description varchar(50) NOT NULL,
    WarehouseLocation warehouselocation NOT NULL);
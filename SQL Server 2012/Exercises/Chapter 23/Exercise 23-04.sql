USE AP;

SELECT PartNumber, Description, WarehouseLocation.Rack AS Rack, 
    WarehouseLocation.Shelf AS Shelf, WarehouseLocation.Bin AS Bin
FROM Parts;
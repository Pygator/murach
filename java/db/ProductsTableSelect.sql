CONNECT 'jdbc:derby:MurachDB';

SELECT ProductCode, Description, Price 
FROM Products
WHERE Price > 50
ORDER BY ProductCode ASC;

SELECT * FROM Products;

SELECT p.ProductCode, p.Price, li.Quantity, 
       p.Price * li.Quantity AS Total
FROM Products p
   INNER JOIN LineItems li
   ON p.ProductCode = li.ProductCode
WHERE p.Price > 50
ORDER BY p.ProductCode ASC;

SELECT p.ProductCode, p.Price, li.Quantity, 
       p.Price * li.Quantity AS Total
FROM Products p, LineItems li
WHERE p.ProductCode = li.ProductCode AND p.Price > 50
ORDER BY p.ProductCode ASC;

DISCONNECT;
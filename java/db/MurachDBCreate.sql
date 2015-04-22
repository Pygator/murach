CONNECT 'jdbc:derby:MurachDB;create=true';

-- drop tables (ignore errors if they don't exist)
DROP TABLE Products;
DROP TABLE LineItems;

-- create Products table
CREATE TABLE Products
(
    ProductCode VARCHAR(10), 
	Description VARCHAR(40), 
	Price DOUBLE
);

-- insert data into Products table
INSERT INTO Products VALUES
('bvbn', 'Murach''s Beginning Visual Basic .NET', 49.50);   	

INSERT INTO Products VALUES
('cshp', 'Murach''s C#', 49.50);

INSERT INTO Products VALUES
('java', 'Murach''s Beginning Java', 49.50);

INSERT INTO Products VALUES
('jsps', 'Murach''s Java Servlets and JSP', 49.50);

INSERT INTO Products VALUES
('mcb2', 'Murach''s Mainframe COBOL', 59.50);

INSERT INTO Products VALUES
('sqls', 'Murach''s SQL for SQL Server', 49.50);

INSERT INTO Products VALUES
('zjcl', 'Murach''s OS/390 and z/OS JCL', 62.50);

-- view data in Products table
SELECT * FROM Products;

-- create LineItems table
CREATE TABLE LineItems
(
    LineItemID INT, 
	InvoiceID INT, 
	ProductCode VARCHAR(10),
	Quantity INT
);

-- insert data into LineItems table
INSERT INTO LineItems VALUES
(1, 1, 'java', 5);

INSERT INTO LineItems VALUES
(2, 1, 'jsps', 5);

INSERT INTO LineItems VALUES
(3, 2, 'mcb2', 1);

INSERT INTO LineItems VALUES
(7, 4, 'cshp', 1);

INSERT INTO LineItems VALUES
(8, 4, 'zjcl', 2);

INSERT INTO LineItems VALUES
(9, 6, 'sqls', 1);

INSERT INTO LineItems VALUES
(10, 6, 'java', 1);

INSERT INTO LineItems VALUES
(11, 7, 'mcb2', 5);

-- view data in LineItems table
SELECT * FROM LineItems;

DISCONNECT;
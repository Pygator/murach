CONNECT 'jdbc:derby:MurachDB;create=true';

-- drop Products table (ignore errors if it doesn't exist)
DROP TABLE Products;

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

DISCONNECT;
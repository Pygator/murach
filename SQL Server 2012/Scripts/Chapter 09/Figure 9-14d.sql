USE AP;

SELECT TermsDescription, 
    NTILE(2) OVER (ORDER BY TermsID) AS Tile2, 
    NTILE(3) OVER (ORDER BY TermsID) AS Tile3, 
    NTILE(4) OVER (ORDER BY TermsID) AS Tile4 
FROM Terms;

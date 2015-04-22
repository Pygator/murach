USE Examples;

SELECT Name,
    LEFT(Name, CHARINDEX(' ', Name) - 1) AS First,
    RIGHT(Name, LEN(Name) - CHARINDEX(' ', Name) ) AS Last
FROM StringSample;

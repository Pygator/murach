USE Examples;

SELECT ID, R, CAST(R AS decimal(9,3)) AS R_decimal,
    CAST(CAST(R AS decimal(9,3)) AS varchar(9)) AS R_varchar,
    LEN(CAST(CAST(R AS decimal(9,3)) AS varchar(9))) AS R_LEN,
    SPACE(9 - LEN(CAST(CAST(R AS decimal(9,3)) AS varchar(9)))) +
        CAST(CAST(R AS decimal(9,3)) AS varchar(9)) AS R_Formatted
FROM RealSample;

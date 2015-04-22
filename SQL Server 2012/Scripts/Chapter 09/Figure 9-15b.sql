USE Examples;

SELECT RepID, SalesYear, SalesTotal AS CurrentSales,
    LAG(SalesTotal, 1, 0) OVER (PARTITION BY RepID ORDER BY SalesYear)
        AS LastSales,
    SalesTotal - LAG(SalesTotal, 1, 0)
        OVER (PARTITION BY REPID ORDER BY SalesYear) AS Change
FROM SalesTotals;

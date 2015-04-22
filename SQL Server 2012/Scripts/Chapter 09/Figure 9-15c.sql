USE Examples;

SELECT SalesYear, RepID, SalesTotal,
    PERCENT_RANK() OVER (PARTITION BY SalesYear ORDER BY SalesTotal)
        AS PctRank,
    CUME_DIST() OVER (PARTITION BY SalesYear ORDER BY SalesTotal)
        AS CumeDist,
    PERCENTILE_CONT(.5) WITHIN GROUP (ORDER BY SalesTotal) 
        OVER (PARTITION BY SalesYear) AS PercentileCont,
    PERCENTILE_DISC(.5) WITHIN GROUP (ORDER BY SalesTotal) 
        OVER (PARTITION BY SalesYear) AS PercentileDisc
FROM SalesTotals;

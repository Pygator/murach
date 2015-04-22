USE Examples;

SELECT SalesYear, RepFirstName + ' ' + RepLastName AS RepName, SalesTotal,
    FIRST_VALUE(RepFirstName + ' ' + RepLastName)
        OVER (PARTITION BY SalesYear ORDER BY SalesTotal DESC)
        AS HighestSales,
    LAST_VALUE(RepFirstName + ' ' + RepLastName)
        OVER (PARTITION BY SalesYear ORDER BY SalesTotal DESC
              RANGE BETWEEN UNBOUNDED PRECEDING AND UNBOUNDED FOLLOWING)
        AS LowestSales
FROM SalesTotals JOIN SalesReps
  ON SalesTotals.RepID = SalesReps.RepID;

USE Examples;

SELECT * FROM DateSample
WHERE StartDate >= '09:00:00' AND
    StartDate < '12:59:59:999';

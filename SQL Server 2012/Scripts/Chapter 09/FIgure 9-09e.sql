USE Examples;

SELECT * FROM DateSample
WHERE CONVERT(datetime, CONVERT(char(12), StartDate, 8)) >= '09:00:00' AND
      CONVERT(datetime, CONVERT(char(12), StartDate, 8)) < '12:59:59:999';

USE Examples;

SELECT * FROM DateSample
WHERE CAST(CAST(StartDate AS char(11)) AS datetime) = '2011-10-28';


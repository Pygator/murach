USE Examples;

INSERT INTO ColorSample (ColorNumber)
VALUES (606);

INSERT INTO ColorSample (ColorName)
VALUES ('Yellow');

INSERT INTO ColorSample
VALUES (DEFAULT, 'Orange');

INSERT INTO ColorSample
VALUES (808, NULL);

INSERT INTO ColorSample
VALUES (DEFAULT, NULL);

INSERT INTO ColorSample
DEFAULT VALUES;

SELECT * FROM ColorSample;

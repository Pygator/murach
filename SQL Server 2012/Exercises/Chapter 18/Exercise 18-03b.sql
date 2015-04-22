USE AP;

DECLARE @DynamicSQL varchar(256),
        @LoginName varchar(128),
        @TempPassword char(8);

DECLARE Login_Cursor CURSOR
DYNAMIC
FOR
  SELECT DISTINCT *
  FROM NewLogins;

OPEN Login_Cursor;
FETCH NEXT FROM Login_Cursor
  INTO @LoginName;
WHILE @@FETCH_STATUS = 0
  BEGIN
    SET @TempPassword = LEFT(@LoginName, 4) + '9999';
    SET @DynamicSQL = 'CREATE LOGIN ' + @LoginName + ' ' +
                      'WITH PASSWORD = ''' + @TempPassword + ''', ' +
                      'DEFAULT_DATABASE = AP';
    EXEC (@DynamicSQL);
    SET @DynamicSQL = 'CREATE USER ' + @LoginName + ' ' +
                      'FOR LOGIN ' + @LoginName;
    EXEC (@DynamicSQL);
    SET @DynamicSQL = 'ALTER ROLE PaymentEntry ADD MEMBER ' +
                      @LoginName;
    EXEC (@DynamicSQL);
    FETCH NEXT FROM Login_Cursor
      INTO @LoginName;
  END;
CLOSE Login_Cursor;

DEALLOCATE Login_Cursor;

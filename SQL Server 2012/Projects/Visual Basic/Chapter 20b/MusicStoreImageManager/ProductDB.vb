Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports System.IO

Public Class ProductDB

    ' The directory for the images
    Shared imagesPath As String = "C:/Murach/SQL Server 2012/Images/"

    Protected Shared Function GetConnection() As SqlConnection
        Dim connection As SqlConnection = New SqlConnection()
        connection.ConnectionString =
            "Data Source=localhost\SqlExpress;" &
            "Initial Catalog=MusicStore;Integrated Security=True"
        Return connection
    End Function

    Public Shared Sub WriteImage(ByVal productID As Integer, ByVal imageName As String)
        Dim connection As SqlConnection = Nothing
        Dim transaction As SqlTransaction = Nothing
        Try
            ' 1. Set up the input stream from the image file
            Dim filepath As String = imagesPath + imageName
            If File.Exists(filepath) = False Then
                Throw New Exception("File Not Found: " + filepath)
            End If

            Dim sourceStream As FileStream = New FileStream(
                filepath,
                FileMode.Open,
                FileAccess.Read)

            ' 2. Initialize the row in the table
            connection = GetConnection()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.CommandText =
                "INSERT INTO ProductImages " &
                "VALUES (@ProductID, " &
                "        CAST(@RowID AS uniqueidentifier), 0)"

            Dim rowID As Guid = Guid.NewGuid()
            command.Parameters.AddWithValue("@ProductID", productID)
            command.Parameters.AddWithValue("@RowID", rowID)

            connection.Open()
            command.ExecuteNonQuery()

            ' 3. Get a reference to the BLOB
            transaction = connection.BeginTransaction()
            command.Transaction = transaction
            command.CommandText =
                "SELECT ProductImage.PathName(), " &
                "       GET_FILESTREAM_TRANSACTION_CONTEXT() " &
                "FROM ProductImages " &
                "WHERE RowID = CAST(@RowID AS uniqueidentifier)"
            command.Parameters.Clear()
            command.Parameters.AddWithValue("@RowID", rowID)

            Dim reader As SqlDataReader = command.ExecuteReader()
            If reader.Read() = False Then
                Throw New Exception("Unable to get path and context for BLOB.")
            End If
            Dim path As String = reader(0)
            Dim context As Byte() = reader(1)
            reader.Close()

            ' 4. Set up the output stream to the database
            Dim targetStream As SqlFileStream =
                New SqlFileStream(path, context, FileAccess.Write)

            ' 5. Read from file and write to database
            Dim blockSize As Integer = 1024 * 512
            Dim buffer(blockSize) As Byte

            Dim bytesRead As Integer = sourceStream.Read(buffer, 0, buffer.Length)
            While bytesRead > 0
                targetStream.Write(buffer, 0, bytesRead)
                bytesRead = sourceStream.Read(buffer, 0, buffer.Length)
            End While

            targetStream.Close()
            sourceStream.Close()
            transaction.Commit()
        Catch e As Exception
            If Not IsDBNull(transaction) Then
                transaction.Rollback()
            End If
            Throw e
        Finally
            If Not IsDBNull(connection) Then
                connection.Close()
            End If
        End Try
    End Sub

    Public Shared Function ReadImage(ByVal imageID As Integer) As Byte()
        Dim connection As SqlConnection = Nothing
        Dim transaction As SqlTransaction = Nothing
        Try
            connection = GetConnection()
            connection.Open()
            transaction = connection.BeginTransaction()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.Transaction = transaction
            command.CommandText =
                "SELECT ProductImage.PathName(), " &
                "       GET_FILESTREAM_TRANSACTION_CONTEXT() " &
                "FROM ProductImages " &
                "WHERE ImageID = @ImageID"
            command.Parameters.AddWithValue("@ImageID", imageID)

            Dim reader As SqlDataReader = command.ExecuteReader()
            If reader.Read() = False Then
                Throw New Exception("Unable to get path and context for BLOB.")
            End If
            Dim path As String = reader(0)
            Dim context As Byte() = reader(1)
            reader.Close()

            ' Set up the input stream from the database
            Dim sourceStream As SqlFileStream =
                New SqlFileStream(path, context, FileAccess.Read)

            Dim blockSize As Integer = 1024 * 512
            Dim buffer(blockSize) As Byte
            Dim imageBytes As List(Of Byte) = New List(Of Byte)
            Dim bytesRead As Integer = sourceStream.Read(buffer, 0, buffer.Length)
            While (bytesRead > 0)
                bytesRead = sourceStream.Read(buffer, 0, buffer.Length)
                For Each b As Byte In buffer
                    imageBytes.Add(b)
                Next
            End While
            sourceStream.Close()

            Return imageBytes.ToArray()
        Catch e As Exception
            Throw e
        Finally
            If Not IsDBNull(connection) Then
                connection.Close()
            End If
        End Try
    End Function


    Public Shared Function GetImageIDList() As List(Of Integer)
        Dim connection As SqlConnection = Nothing
        Try
            connection = GetConnection()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.CommandText =
                "SELECT ImageID FROM ProductImages " &
                "ORDER BY ImageID"

            connection.Open()
            Dim reader As SqlDataReader = command.ExecuteReader()

            Dim imageIDList As List(Of Integer) = New List(Of Integer)
            While reader.Read()
                Dim imageID As Integer = reader(0)
                imageIDList.Add(imageID)
            End While
            reader.Close()

            Return imageIDList
        Catch e As Exception
            Throw e
        Finally
            If IsDBNull(connection) Then
                connection.Close()
            End If
        End Try
    End Function

End Class

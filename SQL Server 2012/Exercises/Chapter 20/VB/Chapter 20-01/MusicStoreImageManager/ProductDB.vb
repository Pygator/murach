Imports System.Data.SqlClient
Imports System.IO

Public Class ProductDB

    ' The directory for the images
    Shared imagesPath As String = "C:/Murach/SQL Server 2012/Images/"

    Protected Shared Function GetConnection() As SqlConnection
        Dim connection As SqlConnection = New SqlConnection()
        connection.ConnectionString =
            "Data Source=localhost\SqlExpress;" &
            "Initial Catalog=Examples;Integrated Security=True"
        Return connection
    End Function

    Public Shared Sub WriteImage(ByVal productID As Integer, ByVal imageName As String)
        Dim connection As SqlConnection = Nothing
        Try
            ' 1. Read image from file
            Dim filepath = imagesPath + imageName
            If File.Exists(filepath) = False Then
                Throw New Exception("File Not Found: " + filepath)
            End If
            Dim sourceStream As New FileStream(
                filepath,
                FileMode.Open,
                FileAccess.Read)

            Dim streamLength As Integer = sourceStream.Length
            Dim productImage(0 To streamLength) As Byte
            sourceStream.Read(productImage, 0, streamLength)
            sourceStream.Close()

            ' 2. Write image to database
            connection = GetConnection()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.CommandText =
                "INSERT INTO ProductImages " &
                "VALUES (@ProductID, @ProductImage)"
            command.Parameters.AddWithValue("@ProductID", productID)
            command.Parameters.AddWithValue("@ProductImage", productImage)

            connection.Open()
            command.ExecuteNonQuery()
        Catch e As Exception
            Throw e
        Finally
            If Not IsDBNull(connection) Then
                connection.Close()
            End If
        End Try
    End Sub


    Public Shared Sub ReadImage(ByVal imageID As Integer,
        ByVal pictureBox As PictureBox)

        Dim connection As SqlConnection = Nothing
        Try
            connection = GetConnection()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.CommandText =
                "SELECT ProductImage " &
                "FROM ProductImages " &
                "WHERE ImageID = @ImageID"
            command.Parameters.AddWithValue("@ImageID", imageID)

            connection.Open()
            Dim reader As SqlDataReader = command.ExecuteReader()

            Dim imageByteArray As Byte()
            If reader.Read() = False Then
                Throw New Exception("Unable to read image.")
            End If
            imageByteArray = reader(0)
            reader.Close()

            Dim ms As MemoryStream = New MemoryStream(imageByteArray)
            pictureBox.Image = System.Drawing.Image.FromStream(ms)
            ms.Close()
        Catch e As Exception
            Throw e
        Finally
            If IsDBNull(connection) Then
                connection.Close()
            End If
        End Try
    End Sub


    Public Shared Function GetImageIDList() As List(Of Integer)
        Dim connection As SqlConnection = Nothing
        Try
            connection = GetConnection()
            connection.Open()

            Dim command As SqlCommand = New SqlCommand()
            command.Connection = connection
            command.CommandText =
                "SELECT ImageID FROM ProductImages " &
                "ORDER BY ImageID"
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

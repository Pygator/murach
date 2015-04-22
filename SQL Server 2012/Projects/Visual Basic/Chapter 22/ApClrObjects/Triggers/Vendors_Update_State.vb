Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class Triggers
    <Microsoft.SqlServer.Server.SqlTrigger(
        Target:="Vendors",
        Event:="AFTER INSERT, UPDATE")> _
    Public Shared Sub Vendors_Update_State()
        ' Open the Connection object for the context
        Dim connection As New SqlConnection("Context connection=true")
        connection.Open()

        ' Create the Command object
        Dim command As New SqlCommand()
        command.Connection = connection

        ' Create a string that defines the SQL statement
        Dim sql As String =
            "UPDATE Vendors " &
            "SET VendorState = UPPER(VendorState) " &
            "WHERE VendorID IN (SELECT VendorID FROM Inserted)"
        command.CommandText = sql

        ' Execute the Command object
        command.ExecuteNonQuery()

        ' Close the connection
        connection.Close()
    End Sub
End Class

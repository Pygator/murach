Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server


Partial Public Class Triggers
    <Microsoft.SqlServer.Server.SqlTrigger(
        Target:="Database",
        Event:="AFTER CREATE_TABLE, DROP_TABLE")> _
    Public Shared Sub Database_CreateTable_DropTable()
        Dim tc As SqlTriggerContext = SqlContext.TriggerContext
        If tc.TriggerAction = TriggerAction.CreateTable Then
            SqlContext.Pipe.Send("A new table has been created.")
        ElseIf tc.TriggerAction = TriggerAction.DropTable Then
            SqlContext.Pipe.Send("A table has been dropped.")
        End If
        Dim eventData As String = tc.EventData.Value
        SqlContext.Pipe.Send(eventData)
    End Sub
End Class

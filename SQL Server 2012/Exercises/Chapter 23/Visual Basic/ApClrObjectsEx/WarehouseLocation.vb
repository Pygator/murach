Imports System
Imports System.Data
Imports System.Data.SqlClient
Imports System.Data.SqlTypes
Imports Microsoft.SqlServer.Server

<Serializable()> _
<Microsoft.SqlServer.Server.SqlUserDefinedType(
    Format.UserDefined,
    MaxByteSize:=5)> _
Public Structure WarehouseLocation
    Implements INullable, IBinarySerialize

    Private m_isNull As Boolean
    Private m_location As String

    Public Overrides Function ToString() As String
        Return m_location
    End Function

    Public ReadOnly Property IsNull() As Boolean Implements INullable.IsNull
        Get
            Return m_isNull
        End Get
    End Property

    Public Shared ReadOnly Property Null() As WarehouseLocation
        Get
            Dim location As New WarehouseLocation
            location.m_isNull = True
            Return location
        End Get
    End Property

    Public ReadOnly Property Location() As SqlString
        Get
            Return m_location
        End Get
    End Property

    Public ReadOnly Property Rack() As SqlString
        Get
            Return m_location.Substring(0, 1)
        End Get
    End Property

    Public ReadOnly Property Shelf() As SqlString
        Get
            Return m_location.Substring(1, 1)
        End Get
    End Property

    Public ReadOnly Property Bin() As SqlString
        Get
            Return m_location.Substring(2)
        End Get
    End Property

    Public Shared Function Parse(ByVal s As SqlString) As WarehouseLocation
        If s.IsNull Then
            Return Null
        End If

        Validate(s)

        Dim location As New WarehouseLocation
        location.m_location = s.ToString
        Return location
    End Function

    Private Shared Sub Validate(ByVal str As SqlString)
        Dim s As String = str.Value
        Dim message As String = "Invalid location: " & s & ". "

        Dim rack As Char = s(0)
        If Not Char.IsLetter(rack) Then
            Throw New ApplicationException(message &
                "The rack must be alphabetic.")
        End If

        Try
            Dim shelf As Integer = Convert.ToInt32(s.Substring(1, 1))
            If shelf < 1 OrElse shelf > 5 Then
                Throw New ApplicationException(message &
                    "The shelf must be between 1 and 5.")
            End If
        Catch ex As FormatException
            Throw New ApplicationException(message &
                "The shelf must be an integer.")
        End Try

        Try
            Dim bin As Integer = Convert.ToInt32(s.Substring(2))
            If bin < 1 OrElse bin > 50 Then
                Throw New ApplicationException(message &
                    "The bin must be between 1 and 50.")
            End If
        Catch ex As FormatException
            Throw New ApplicationException(message &
                "The bin must be an integer.")
        End Try

    End Sub

    Public Sub Read(ByVal r As System.IO.BinaryReader) _
            Implements Microsoft.SqlServer.Server.IBinarySerialize.Read
        m_location = r.ReadString
    End Sub

    Public Sub Write(ByVal w As System.IO.BinaryWriter) _
            Implements Microsoft.SqlServer.Server.IBinarySerialize.Write
        w.Write(m_location)
    End Sub

End Structure


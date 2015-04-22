Public Class Validator
    Private Shared m_Title As String = "Entry Error"

    Public Shared Property Title() As String
        Get
            Return m_Title
        End Get
        Set(ByVal value As String)
            m_Title = value
        End Set
    End Property

    Public Shared Function IsPresent(ByVal control As Control) As Boolean
        If control.GetType.ToString = "System.Windows.Forms.TextBox" Then
            Dim textBox As TextBox = CType(control, TextBox)
            If textBox.Text = "" Then
                MessageBox.Show(textBox.Tag.ToString & " is a required field.", Title)
                textBox.Select()
                Return False
            Else
                Return True
            End If
        ElseIf control.GetType.ToString = "System.Windows.Forms.ComboBox" Then
            Dim comboBox As ComboBox = CType(control, ComboBox)
            If comboBox.SelectedIndex = -1 Then
                MessageBox.Show(comboBox.Tag.ToString & " is a required field.", Title)
                comboBox.Select()
                Return False
            Else
                Return True
            End If
        End If
        Return True
    End Function

    Public Shared Function IsInt32(ByVal textBox As TextBox) As Boolean
        Try
            Convert.ToInt32(textBox.Text)
            Return True
        Catch ex As FormatException
            MessageBox.Show(textBox.Tag.ToString & " must be an integer value.", Title)
            textBox.Select()
            textBox.SelectAll()
            Return False
        End Try
    End Function

End Class

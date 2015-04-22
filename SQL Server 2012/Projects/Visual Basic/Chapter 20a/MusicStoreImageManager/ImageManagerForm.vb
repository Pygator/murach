Imports System.IO

Public Class ImageManagerForm

    Dim imageIDList As List(Of Integer)

    Private Sub ImageManagerForm_Load(
        ByVal sender As System.Object, ByVal e As System.EventArgs) _
        Handles MyBase.Load

        ' initialize data if no data exists
        imageIDList = ProductDB.GetImageIDList()
        If imageIDList.Count = 0 Then
            ' upload images
            ProductDB.WriteImage(1, "8601_cover.jpg")
            ProductDB.WriteImage(2, "pf01_cover.jpg")
            ProductDB.WriteImage(3, "jr01_cover.jpg")
        End If

        ' load combo box
        Me.LoadImageIDComboBox()
        imageIDComboBox_SelectedIndexChanged(sender, e)

    End Sub

    Private Sub LoadImageIDComboBox()
        imageIDList = ProductDB.GetImageIDList()
        For Each i As Integer In imageIDList
            imageIDComboBox.Items.Add(i)
        Next

    End Sub

    Private Sub imageIDComboBox_SelectedIndexChanged(
        ByVal sender As System.Object, ByVal e As System.EventArgs) _
        Handles imageIDComboBox.SelectedIndexChanged

        Try
            Dim imageID As Integer = Convert.ToInt32(imageIDComboBox.Text)

            ' read image bytes from the database and display in picture box
            Dim imageByteArray As Byte() = ProductDB.ReadImage(imageID)
            Dim ms As MemoryStream = New MemoryStream(imageByteArray)
            imagePictureBox.Image = System.Drawing.Image.FromStream(ms)
            ms.Close()
        Catch ex As Exception
            MessageBox.Show(Me, ex.Message, "Error")
        End Try

    End Sub

    Private Sub uploadButton_Click(
        ByVal sender As System.Object, ByVal e As System.EventArgs) _
        Handles uploadButton.Click

        Try
            Dim productID As Integer = Convert.ToInt32(productIDTextBox.Text)
            Dim filename As String = filenameTextBox.Text
            ProductDB.WriteImage(productID, filename)
            MessageBox.Show(Me, "Image upload was successful!",
                "Upload Confirmation")

            ' refresh combo box
            imageIDComboBox.Items.Clear()
            Me.LoadImageIDComboBox()
        Catch ex As Exception
            MessageBox.Show(Me, ex.Message, "Error")
        End Try

    End Sub

End Class

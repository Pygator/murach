Public Class frmVendorDisplay

    Dim vendor As Vendor

    Private Sub btnGetVendor_Click(sender As System.Object, e As System.EventArgs) Handles btnGetVendor.Click
        If Validator.IsPresent(txtVendorID) AndAlso
           Validator.IsInt32(txtVendorID) Then
            Dim vendorID As Integer = CInt(txtVendorID.Text)
            Me.GetVendor(vendorID)
        End If
    End Sub

    Private Sub GetVendor(vendorID As Integer)
        vendor = VendorDB.GetVendor(vendorID)
        If vendor Is Nothing Then
            MessageBox.Show("No vendor found with this ID. Please try again.",
                            "Vendor Not Found")
        Else
            Me.DisplayVendor()
        End If
    End Sub

    Private Sub DisplayVendor()
        txtName.Text = vendor.VendorName
        txtAddressLine1.Text = vendor.VendorAddress1
        txtAddressLine2.Text = vendor.VendorAddress2
        txtCity.Text = vendor.VendorCity
        txtState.Text = vendor.VendorState
        txtZipCode.Text = vendor.VendorZipCode
    End Sub

    Private Sub btnExit_Click(ByVal sender As System.Object, _
            ByVal e As System.EventArgs) Handles btnExit.Click
        Me.Close()
    End Sub

End Class

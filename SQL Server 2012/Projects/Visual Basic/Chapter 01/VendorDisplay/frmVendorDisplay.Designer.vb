<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class frmVendorDisplay
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        If disposing AndAlso components IsNot Nothing Then
            components.Dispose()
        End If
        MyBase.Dispose(disposing)
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.txtState = New System.Windows.Forms.TextBox()
        Me.btnExit = New System.Windows.Forms.Button()
        Me.lblZipCode = New System.Windows.Forms.Label()
        Me.lblState = New System.Windows.Forms.Label()
        Me.txtZipCode = New System.Windows.Forms.TextBox()
        Me.lblCity = New System.Windows.Forms.Label()
        Me.txtCity = New System.Windows.Forms.TextBox()
        Me.lblAddress = New System.Windows.Forms.Label()
        Me.txtAddressLine2 = New System.Windows.Forms.TextBox()
        Me.txtAddressLine1 = New System.Windows.Forms.TextBox()
        Me.lblName = New System.Windows.Forms.Label()
        Me.txtName = New System.Windows.Forms.TextBox()
        Me.Label1 = New System.Windows.Forms.Label()
        Me.txtVendorID = New System.Windows.Forms.TextBox()
        Me.btnGetVendor = New System.Windows.Forms.Button()
        Me.SuspendLayout()
        '
        'txtState
        '
        Me.txtState.Location = New System.Drawing.Point(77, 153)
        Me.txtState.Name = "txtState"
        Me.txtState.ReadOnly = True
        Me.txtState.Size = New System.Drawing.Size(48, 20)
        Me.txtState.TabIndex = 11
        '
        'btnExit
        '
        Me.btnExit.Location = New System.Drawing.Point(330, 196)
        Me.btnExit.Name = "btnExit"
        Me.btnExit.Size = New System.Drawing.Size(75, 23)
        Me.btnExit.TabIndex = 14
        Me.btnExit.Text = "E&xit"
        '
        'lblZipCode
        '
        Me.lblZipCode.Location = New System.Drawing.Point(149, 153)
        Me.lblZipCode.Name = "lblZipCode"
        Me.lblZipCode.Size = New System.Drawing.Size(66, 24)
        Me.lblZipCode.TabIndex = 12
        Me.lblZipCode.Text = "Zip Code:"
        Me.lblZipCode.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'lblState
        '
        Me.lblState.Location = New System.Drawing.Point(7, 153)
        Me.lblState.Name = "lblState"
        Me.lblState.Size = New System.Drawing.Size(66, 24)
        Me.lblState.TabIndex = 10
        Me.lblState.Text = "State:"
        Me.lblState.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'txtZipCode
        '
        Me.txtZipCode.Location = New System.Drawing.Point(221, 153)
        Me.txtZipCode.Name = "txtZipCode"
        Me.txtZipCode.ReadOnly = True
        Me.txtZipCode.Size = New System.Drawing.Size(112, 20)
        Me.txtZipCode.TabIndex = 13
        '
        'lblCity
        '
        Me.lblCity.Location = New System.Drawing.Point(7, 129)
        Me.lblCity.Name = "lblCity"
        Me.lblCity.Size = New System.Drawing.Size(66, 24)
        Me.lblCity.TabIndex = 8
        Me.lblCity.Text = "City:"
        Me.lblCity.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'txtCity
        '
        Me.txtCity.Location = New System.Drawing.Point(77, 129)
        Me.txtCity.Name = "txtCity"
        Me.txtCity.ReadOnly = True
        Me.txtCity.Size = New System.Drawing.Size(328, 20)
        Me.txtCity.TabIndex = 9
        '
        'lblAddress
        '
        Me.lblAddress.Location = New System.Drawing.Point(5, 81)
        Me.lblAddress.Name = "lblAddress"
        Me.lblAddress.Size = New System.Drawing.Size(66, 24)
        Me.lblAddress.TabIndex = 5
        Me.lblAddress.Text = "Address:"
        Me.lblAddress.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'txtAddressLine2
        '
        Me.txtAddressLine2.Location = New System.Drawing.Point(77, 105)
        Me.txtAddressLine2.Name = "txtAddressLine2"
        Me.txtAddressLine2.ReadOnly = True
        Me.txtAddressLine2.Size = New System.Drawing.Size(328, 20)
        Me.txtAddressLine2.TabIndex = 7
        '
        'txtAddressLine1
        '
        Me.txtAddressLine1.Location = New System.Drawing.Point(77, 81)
        Me.txtAddressLine1.Name = "txtAddressLine1"
        Me.txtAddressLine1.ReadOnly = True
        Me.txtAddressLine1.Size = New System.Drawing.Size(328, 20)
        Me.txtAddressLine1.TabIndex = 6
        '
        'lblName
        '
        Me.lblName.Location = New System.Drawing.Point(5, 52)
        Me.lblName.Name = "lblName"
        Me.lblName.Size = New System.Drawing.Size(66, 24)
        Me.lblName.TabIndex = 3
        Me.lblName.Text = "Name:"
        Me.lblName.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'txtName
        '
        Me.txtName.Location = New System.Drawing.Point(77, 55)
        Me.txtName.Name = "txtName"
        Me.txtName.ReadOnly = True
        Me.txtName.Size = New System.Drawing.Size(328, 20)
        Me.txtName.TabIndex = 4
        '
        'Label1
        '
        Me.Label1.AutoSize = True
        Me.Label1.Location = New System.Drawing.Point(15, 18)
        Me.Label1.Name = "Label1"
        Me.Label1.Size = New System.Drawing.Size(58, 13)
        Me.Label1.TabIndex = 0
        Me.Label1.Text = "Vendor ID:"
        Me.Label1.TextAlign = System.Drawing.ContentAlignment.MiddleRight
        '
        'txtVendorID
        '
        Me.txtVendorID.Location = New System.Drawing.Point(80, 15)
        Me.txtVendorID.Name = "txtVendorID"
        Me.txtVendorID.Size = New System.Drawing.Size(50, 20)
        Me.txtVendorID.TabIndex = 1
        Me.txtVendorID.Tag = "Vendor ID"
        '
        'btnGetVendor
        '
        Me.btnGetVendor.Location = New System.Drawing.Point(136, 13)
        Me.btnGetVendor.Name = "btnGetVendor"
        Me.btnGetVendor.Size = New System.Drawing.Size(75, 23)
        Me.btnGetVendor.TabIndex = 2
        Me.btnGetVendor.Text = "Get Vendor"
        Me.btnGetVendor.UseVisualStyleBackColor = True
        '
        'frmVendorDisplay
        '
        Me.AcceptButton = Me.btnGetVendor
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.CancelButton = Me.btnExit
        Me.ClientSize = New System.Drawing.Size(419, 231)
        Me.Controls.Add(Me.btnGetVendor)
        Me.Controls.Add(Me.txtVendorID)
        Me.Controls.Add(Me.Label1)
        Me.Controls.Add(Me.txtName)
        Me.Controls.Add(Me.txtState)
        Me.Controls.Add(Me.btnExit)
        Me.Controls.Add(Me.lblZipCode)
        Me.Controls.Add(Me.lblState)
        Me.Controls.Add(Me.txtZipCode)
        Me.Controls.Add(Me.lblCity)
        Me.Controls.Add(Me.txtCity)
        Me.Controls.Add(Me.lblAddress)
        Me.Controls.Add(Me.txtAddressLine2)
        Me.Controls.Add(Me.txtAddressLine1)
        Me.Controls.Add(Me.lblName)
        Me.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedSingle
        Me.MaximizeBox = False
        Me.MinimizeBox = False
        Me.Name = "frmVendorDisplay"
        Me.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen
        Me.Text = "Vendor Display"
        Me.ResumeLayout(False)
        Me.PerformLayout()

    End Sub
    Friend WithEvents txtState As System.Windows.Forms.TextBox
    Friend WithEvents btnExit As System.Windows.Forms.Button
    Friend WithEvents lblZipCode As System.Windows.Forms.Label
    Friend WithEvents lblState As System.Windows.Forms.Label
    Friend WithEvents txtZipCode As System.Windows.Forms.TextBox
    Friend WithEvents lblCity As System.Windows.Forms.Label
    Friend WithEvents txtCity As System.Windows.Forms.TextBox
    Friend WithEvents lblAddress As System.Windows.Forms.Label
    Friend WithEvents txtAddressLine2 As System.Windows.Forms.TextBox
    Friend WithEvents txtAddressLine1 As System.Windows.Forms.TextBox
    Friend WithEvents lblName As System.Windows.Forms.Label
    Friend WithEvents txtName As System.Windows.Forms.TextBox
    Friend WithEvents Label1 As System.Windows.Forms.Label
    Friend WithEvents txtVendorID As System.Windows.Forms.TextBox
    Friend WithEvents btnGetVendor As System.Windows.Forms.Button

End Class

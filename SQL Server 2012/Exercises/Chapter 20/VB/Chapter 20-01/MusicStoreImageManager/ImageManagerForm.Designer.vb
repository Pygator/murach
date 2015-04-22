<Global.Microsoft.VisualBasic.CompilerServices.DesignerGenerated()> _
Partial Class ImageManagerForm
    Inherits System.Windows.Forms.Form

    'Form overrides dispose to clean up the component list.
    <System.Diagnostics.DebuggerNonUserCode()> _
    Protected Overrides Sub Dispose(ByVal disposing As Boolean)
        Try
            If disposing AndAlso components IsNot Nothing Then
                components.Dispose()
            End If
        Finally
            MyBase.Dispose(disposing)
        End Try
    End Sub

    'Required by the Windows Form Designer
    Private components As System.ComponentModel.IContainer

    'NOTE: The following procedure is required by the Windows Form Designer
    'It can be modified using the Windows Form Designer.  
    'Do not modify it using the code editor.
    <System.Diagnostics.DebuggerStepThrough()> _
    Private Sub InitializeComponent()
        Me.groupBox2 = New System.Windows.Forms.GroupBox()
        Me.label4 = New System.Windows.Forms.Label()
        Me.uploadButton = New System.Windows.Forms.Button()
        Me.productIDTextBox = New System.Windows.Forms.TextBox()
        Me.label3 = New System.Windows.Forms.Label()
        Me.label2 = New System.Windows.Forms.Label()
        Me.filenameTextBox = New System.Windows.Forms.TextBox()
        Me.groupBox1 = New System.Windows.Forms.GroupBox()
        Me.imagePictureBox = New System.Windows.Forms.PictureBox()
        Me.label1 = New System.Windows.Forms.Label()
        Me.imageIDComboBox = New System.Windows.Forms.ComboBox()
        Me.groupBox2.SuspendLayout()
        Me.groupBox1.SuspendLayout()
        CType(Me.imagePictureBox, System.ComponentModel.ISupportInitialize).BeginInit()
        Me.SuspendLayout()
        '
        'groupBox2
        '
        Me.groupBox2.Controls.Add(Me.label4)
        Me.groupBox2.Controls.Add(Me.uploadButton)
        Me.groupBox2.Controls.Add(Me.productIDTextBox)
        Me.groupBox2.Controls.Add(Me.label3)
        Me.groupBox2.Controls.Add(Me.label2)
        Me.groupBox2.Controls.Add(Me.filenameTextBox)
        Me.groupBox2.Location = New System.Drawing.Point(12, 223)
        Me.groupBox2.Name = "groupBox2"
        Me.groupBox2.Size = New System.Drawing.Size(440, 140)
        Me.groupBox2.TabIndex = 8
        Me.groupBox2.TabStop = False
        Me.groupBox2.Text = "Upload new images"
        '
        'label4
        '
        Me.label4.AutoSize = True
        Me.label4.Location = New System.Drawing.Point(23, 116)
        Me.label4.Name = "label4"
        Me.label4.Size = New System.Drawing.Size(394, 13)
        Me.label4.TabIndex = 9
        Me.label4.Text = "Note: The image file must be in the C:/Murach/SQL Server 2012/Images directory"
        '
        'uploadButton
        '
        Me.uploadButton.Location = New System.Drawing.Point(26, 79)
        Me.uploadButton.Name = "uploadButton"
        Me.uploadButton.Size = New System.Drawing.Size(75, 23)
        Me.uploadButton.TabIndex = 8
        Me.uploadButton.Text = "Upload"
        Me.uploadButton.UseVisualStyleBackColor = True
        '
        'productIDTextBox
        '
        Me.productIDTextBox.Location = New System.Drawing.Point(101, 48)
        Me.productIDTextBox.Name = "productIDTextBox"
        Me.productIDTextBox.Size = New System.Drawing.Size(51, 20)
        Me.productIDTextBox.TabIndex = 7
        Me.productIDTextBox.Text = "4"
        '
        'label3
        '
        Me.label3.AutoSize = True
        Me.label3.Location = New System.Drawing.Point(23, 51)
        Me.label3.Name = "label3"
        Me.label3.Size = New System.Drawing.Size(61, 13)
        Me.label3.TabIndex = 6
        Me.label3.Text = "Product ID:"
        '
        'label2
        '
        Me.label2.AutoSize = True
        Me.label2.Location = New System.Drawing.Point(23, 22)
        Me.label2.Name = "label2"
        Me.label2.Size = New System.Drawing.Size(52, 13)
        Me.label2.TabIndex = 5
        Me.label2.Text = "Filename:"
        '
        'filenameTextBox
        '
        Me.filenameTextBox.Location = New System.Drawing.Point(101, 19)
        Me.filenameTextBox.Name = "filenameTextBox"
        Me.filenameTextBox.Size = New System.Drawing.Size(214, 20)
        Me.filenameTextBox.TabIndex = 4
        Me.filenameTextBox.Text = "pf02_cover.jpg"
        '
        'groupBox1
        '
        Me.groupBox1.Controls.Add(Me.imagePictureBox)
        Me.groupBox1.Controls.Add(Me.label1)
        Me.groupBox1.Controls.Add(Me.imageIDComboBox)
        Me.groupBox1.Location = New System.Drawing.Point(12, 14)
        Me.groupBox1.Name = "groupBox1"
        Me.groupBox1.Size = New System.Drawing.Size(378, 203)
        Me.groupBox1.TabIndex = 7
        Me.groupBox1.TabStop = False
        Me.groupBox1.Text = "Display images"
        '
        'imagePictureBox
        '
        Me.imagePictureBox.Location = New System.Drawing.Point(181, 14)
        Me.imagePictureBox.Name = "imagePictureBox"
        Me.imagePictureBox.Size = New System.Drawing.Size(180, 180)
        Me.imagePictureBox.TabIndex = 4
        Me.imagePictureBox.TabStop = False
        '
        'label1
        '
        Me.label1.AutoSize = True
        Me.label1.Location = New System.Drawing.Point(23, 30)
        Me.label1.Name = "label1"
        Me.label1.Size = New System.Drawing.Size(53, 13)
        Me.label1.TabIndex = 2
        Me.label1.Text = "Image ID:"
        '
        'imageIDComboBox
        '
        Me.imageIDComboBox.FormattingEnabled = True
        Me.imageIDComboBox.Location = New System.Drawing.Point(101, 27)
        Me.imageIDComboBox.Name = "imageIDComboBox"
        Me.imageIDComboBox.Size = New System.Drawing.Size(51, 21)
        Me.imageIDComboBox.TabIndex = 1
        Me.imageIDComboBox.Text = "1"
        '
        'ImageManagerForm
        '
        Me.AutoScaleDimensions = New System.Drawing.SizeF(6.0!, 13.0!)
        Me.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font
        Me.ClientSize = New System.Drawing.Size(479, 377)
        Me.Controls.Add(Me.groupBox2)
        Me.Controls.Add(Me.groupBox1)
        Me.Name = "ImageManagerForm"
        Me.Text = "Product Image Manager"
        Me.groupBox2.ResumeLayout(False)
        Me.groupBox2.PerformLayout()
        Me.groupBox1.ResumeLayout(False)
        Me.groupBox1.PerformLayout()
        CType(Me.imagePictureBox, System.ComponentModel.ISupportInitialize).EndInit()
        Me.ResumeLayout(False)

    End Sub
    Private WithEvents groupBox2 As System.Windows.Forms.GroupBox
    Private WithEvents label4 As System.Windows.Forms.Label
    Private WithEvents uploadButton As System.Windows.Forms.Button
    Private WithEvents productIDTextBox As System.Windows.Forms.TextBox
    Private WithEvents label3 As System.Windows.Forms.Label
    Private WithEvents label2 As System.Windows.Forms.Label
    Private WithEvents filenameTextBox As System.Windows.Forms.TextBox
    Private WithEvents groupBox1 As System.Windows.Forms.GroupBox
    Private WithEvents imagePictureBox As System.Windows.Forms.PictureBox
    Private WithEvents label1 As System.Windows.Forms.Label
    Private WithEvents imageIDComboBox As System.Windows.Forms.ComboBox

End Class

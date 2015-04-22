namespace VendorDisplay
{
    partial class VendorDisplayForm
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnGetVendor = new System.Windows.Forms.Button();
            this.txtVendorID = new System.Windows.Forms.TextBox();
            this.Label1 = new System.Windows.Forms.Label();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtState = new System.Windows.Forms.TextBox();
            this.btnExit = new System.Windows.Forms.Button();
            this.lblZipCode = new System.Windows.Forms.Label();
            this.lblState = new System.Windows.Forms.Label();
            this.txtZipCode = new System.Windows.Forms.TextBox();
            this.lblCity = new System.Windows.Forms.Label();
            this.txtCity = new System.Windows.Forms.TextBox();
            this.lblAddress = new System.Windows.Forms.Label();
            this.txtAddress2 = new System.Windows.Forms.TextBox();
            this.txtAddress1 = new System.Windows.Forms.TextBox();
            this.lblName = new System.Windows.Forms.Label();
            this.SuspendLayout();
            // 
            // btnGetVendor
            // 
            this.btnGetVendor.Location = new System.Drawing.Point(140, 11);
            this.btnGetVendor.Name = "btnGetVendor";
            this.btnGetVendor.Size = new System.Drawing.Size(75, 23);
            this.btnGetVendor.TabIndex = 17;
            this.btnGetVendor.Text = "Get Vendor";
            this.btnGetVendor.UseVisualStyleBackColor = true;
            this.btnGetVendor.Click += new System.EventHandler(this.btnGetVendor_Click);
            // 
            // txtVendorID
            // 
            this.txtVendorID.Location = new System.Drawing.Point(84, 13);
            this.txtVendorID.Name = "txtVendorID";
            this.txtVendorID.Size = new System.Drawing.Size(50, 20);
            this.txtVendorID.TabIndex = 16;
            this.txtVendorID.Tag = "Vendor ID";
            // 
            // Label1
            // 
            this.Label1.AutoSize = true;
            this.Label1.Location = new System.Drawing.Point(19, 16);
            this.Label1.Name = "Label1";
            this.Label1.Size = new System.Drawing.Size(58, 13);
            this.Label1.TabIndex = 15;
            this.Label1.Text = "Vendor ID:";
            this.Label1.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(81, 53);
            this.txtName.Name = "txtName";
            this.txtName.ReadOnly = true;
            this.txtName.Size = new System.Drawing.Size(328, 20);
            this.txtName.TabIndex = 19;
            // 
            // txtState
            // 
            this.txtState.Location = new System.Drawing.Point(81, 151);
            this.txtState.Name = "txtState";
            this.txtState.ReadOnly = true;
            this.txtState.Size = new System.Drawing.Size(48, 20);
            this.txtState.TabIndex = 26;
            // 
            // btnExit
            // 
            this.btnExit.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnExit.Location = new System.Drawing.Point(334, 194);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(75, 23);
            this.btnExit.TabIndex = 29;
            this.btnExit.Text = "E&xit";
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // lblZipCode
            // 
            this.lblZipCode.Location = new System.Drawing.Point(153, 151);
            this.lblZipCode.Name = "lblZipCode";
            this.lblZipCode.Size = new System.Drawing.Size(66, 24);
            this.lblZipCode.TabIndex = 27;
            this.lblZipCode.Text = "Zip Code:";
            this.lblZipCode.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // lblState
            // 
            this.lblState.Location = new System.Drawing.Point(11, 151);
            this.lblState.Name = "lblState";
            this.lblState.Size = new System.Drawing.Size(66, 24);
            this.lblState.TabIndex = 25;
            this.lblState.Text = "State:";
            this.lblState.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtZipCode
            // 
            this.txtZipCode.Location = new System.Drawing.Point(225, 151);
            this.txtZipCode.Name = "txtZipCode";
            this.txtZipCode.ReadOnly = true;
            this.txtZipCode.Size = new System.Drawing.Size(112, 20);
            this.txtZipCode.TabIndex = 28;
            // 
            // lblCity
            // 
            this.lblCity.Location = new System.Drawing.Point(11, 127);
            this.lblCity.Name = "lblCity";
            this.lblCity.Size = new System.Drawing.Size(66, 24);
            this.lblCity.TabIndex = 23;
            this.lblCity.Text = "City:";
            this.lblCity.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtCity
            // 
            this.txtCity.Location = new System.Drawing.Point(81, 127);
            this.txtCity.Name = "txtCity";
            this.txtCity.ReadOnly = true;
            this.txtCity.Size = new System.Drawing.Size(328, 20);
            this.txtCity.TabIndex = 24;
            // 
            // lblAddress
            // 
            this.lblAddress.Location = new System.Drawing.Point(9, 79);
            this.lblAddress.Name = "lblAddress";
            this.lblAddress.Size = new System.Drawing.Size(66, 24);
            this.lblAddress.TabIndex = 20;
            this.lblAddress.Text = "Address:";
            this.lblAddress.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // txtAddress2
            // 
            this.txtAddress2.Location = new System.Drawing.Point(81, 103);
            this.txtAddress2.Name = "txtAddress2";
            this.txtAddress2.ReadOnly = true;
            this.txtAddress2.Size = new System.Drawing.Size(328, 20);
            this.txtAddress2.TabIndex = 22;
            // 
            // txtAddress1
            // 
            this.txtAddress1.Location = new System.Drawing.Point(81, 79);
            this.txtAddress1.Name = "txtAddress1";
            this.txtAddress1.ReadOnly = true;
            this.txtAddress1.Size = new System.Drawing.Size(328, 20);
            this.txtAddress1.TabIndex = 21;
            // 
            // lblName
            // 
            this.lblName.Location = new System.Drawing.Point(9, 50);
            this.lblName.Name = "lblName";
            this.lblName.Size = new System.Drawing.Size(66, 24);
            this.lblName.TabIndex = 18;
            this.lblName.Text = "Name:";
            this.lblName.TextAlign = System.Drawing.ContentAlignment.MiddleRight;
            // 
            // VendorDisplayForm
            // 
            this.AcceptButton = this.btnGetVendor;
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.CancelButton = this.btnExit;
            this.ClientSize = new System.Drawing.Size(425, 230);
            this.Controls.Add(this.btnGetVendor);
            this.Controls.Add(this.txtVendorID);
            this.Controls.Add(this.Label1);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.txtState);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.lblZipCode);
            this.Controls.Add(this.lblState);
            this.Controls.Add(this.txtZipCode);
            this.Controls.Add(this.lblCity);
            this.Controls.Add(this.txtCity);
            this.Controls.Add(this.lblAddress);
            this.Controls.Add(this.txtAddress2);
            this.Controls.Add(this.txtAddress1);
            this.Controls.Add(this.lblName);
            this.MaximizeBox = false;
            this.MinimizeBox = false;
            this.Name = "VendorDisplayForm";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Vendor Display";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        internal System.Windows.Forms.Button btnGetVendor;
        internal System.Windows.Forms.TextBox txtVendorID;
        internal System.Windows.Forms.Label Label1;
        internal System.Windows.Forms.TextBox txtName;
        internal System.Windows.Forms.TextBox txtState;
        internal System.Windows.Forms.Button btnExit;
        internal System.Windows.Forms.Label lblZipCode;
        internal System.Windows.Forms.Label lblState;
        internal System.Windows.Forms.TextBox txtZipCode;
        internal System.Windows.Forms.Label lblCity;
        internal System.Windows.Forms.TextBox txtCity;
        internal System.Windows.Forms.Label lblAddress;
        internal System.Windows.Forms.TextBox txtAddress2;
        internal System.Windows.Forms.TextBox txtAddress1;
        internal System.Windows.Forms.Label lblName;

    }
}


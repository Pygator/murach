using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using System.Data.SqlClient;

namespace VendorDisplay
{
    public partial class VendorDisplayForm : Form
    {
        public VendorDisplayForm()
        {
            InitializeComponent();
        }

        Vendor vendor;

        private void btnGetVendor_Click(object sender, EventArgs e)
        {
            if (Validator.IsPresent(txtVendorID) &&
                Validator.IsInt32(txtVendorID))
            {
                int vendorID = Convert.ToInt32(txtVendorID.Text);
                this.GetVendor(vendorID);
            }
        }

        private void GetVendor(int vendorID)
        {
            vendor = VendorDB.GetVendor(vendorID);
            if (vendor == null)
                MessageBox.Show("No vendor found with this ID. Please try again.",
                    "Vendor Not Found");
            else
                this.DisplayVendor();
        }

        private void DisplayVendor()
        {
            txtName.Text = vendor.VendorName;
            txtAddress1.Text = vendor.VendorAddress1;
            txtAddress2.Text = vendor.VendorAddress2;
            txtCity.Text = vendor.VendorCity;
            txtState.Text = vendor.VendorState;
            txtZipCode.Text = vendor.VendorZipCode;
        }

        private void btnExit_Click(object sender, EventArgs e)
        {
            this.Close();
        }
    }
}
using System;
using System.Collections.Generic;
using System.Windows.Forms;

using System.IO;

namespace MusicStoreImageManager
{
    public partial class ImageManagerForm : Form
    {
        public ImageManagerForm()
        {
            InitializeComponent();
        }

        private void LoadImageIDComboBox()
        {
            // load the combo box
            List<int> imageIDList = ProductDB.GetImageIDList();
            foreach (int i in imageIDList)
                imageIDComboBox.Items.Add(i);
        }

        private void ImageManagerForm_Load(object sender, EventArgs e)
        {
            this.LoadImageIDComboBox();
            imageIDComboBox_SelectedIndexChanged(sender, e);
        }

        private void imageIDComboBox_SelectedIndexChanged(
            object sender, EventArgs e)
        {
            try
            {
                int imageID = Convert.ToInt32(imageIDComboBox.Text);

                // read image bytes from the database and display in picture box
                Byte[] imageByteArray = ProductDB.ReadImage(imageID);
                MemoryStream ms = new MemoryStream(imageByteArray);
                imagePictureBox.Image = System.Drawing.Image.FromStream(ms);
                ms.Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show(this, ex.Message, "Error");
            }               
        }

        private void uploadButton_Click(object sender, EventArgs e)
        {
            try
            {
                int productID = Convert.ToInt32(productIDTextBox.Text);
                string filename = filenameTextBox.Text;
                ProductDB.WriteImage(productID, filename);
                MessageBox.Show(this, "Image upload was successful!",
                    "Upload Confirmation");

                // refresh combo box
                imageIDComboBox.Items.Clear();
                this.LoadImageIDComboBox();

            }
            catch (Exception ex)
            {
                MessageBox.Show(this, ex.Message, "Error");
            }
        }
    }
}

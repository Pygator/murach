using System;
using System.Collections.Generic;
using System.Windows.Forms;

namespace MusicStoreImageManager
{   
    static class Program
    {
        /// <summary>
        /// The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);

            // initialize data if no data exists
            List<int> imageIDList = ProductDB.GetImageIDList();
            if (imageIDList.Count == 0)
            {
                // upload images
                ProductDB.WriteImage(1, "8601_cover.jpg");
                ProductDB.WriteImage(2, "pf01_cover.jpg");
                ProductDB.WriteImage(3, "jr01_cover.jpg");
            }

            Application.Run(new ImageManagerForm());
        }
    }
}
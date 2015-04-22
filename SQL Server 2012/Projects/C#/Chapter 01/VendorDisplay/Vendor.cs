using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace VendorDisplay
{
    public class Vendor
    {
        public Vendor()
        {
        }

        public int VendorID { get; set; }

        public string VendorName { get; set; }

        public string VendorAddress1 { get; set; }

        public string VendorAddress2 { get; set; }

        public string VendorCity { get; set; }

        public string VendorState { get; set; }

        public string VendorZipCode { get; set; }
    }
}

//------------------------------------------------------------------------------
// <copyright file="CSSqlTrigger.cs" company="Microsoft">
//     Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
//------------------------------------------------------------------------------
using System;
using System.Data;
using System.Data.SqlClient;
using Microsoft.SqlServer.Server;

public partial class Triggers
{        
    [Microsoft.SqlServer.Server.SqlTrigger (Target="Invoices", Event="AFTER INSERT, UPDATE")]
    public static void Invoices_Update_Shipping ()
    {
        // open the Connection object for the context
        SqlConnection connection =
            new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;

        // create SqlTriggerContext object
        SqlTriggerContext tc = SqlContext.TriggerContext;

        // create a string that defines the sql statement
        String sql = "";
        if (tc.TriggerAction == TriggerAction.Insert)
            sql = "INSERT ShippingLabels " +
                "SELECT VendorName, VendorAddress1, VendorAddress2, " +
                "VendorCity, VendorState, VendorZipCode " +
                "FROM Vendors JOIN Inserted " +
                "ON Vendors.VendorID = (SELECT VendorID FROM Inserted) " +
                "WHERE Inserted.InvoiceTotal = Inserted.PaymentTotal";
        else
            sql = "INSERT ShippingLabels " +
                "SELECT VendorName, VendorAddress1, VendorAddress2, " +
                "VendorCity, VendorState, VendorZipCode " +
                "FROM Vendors JOIN Inserted " +
                "ON Vendors.VendorID = (SELECT VendorID FROM Inserted) " +
                "WHERE Inserted.InvoiceTotal - Inserted.PaymentTotal - " +
                "Inserted.CreditTotal = 0";
        command.CommandText = sql;

        // execute the Command object
        command.ExecuteNonQuery();

        // close the Connection object
        connection.Close();
    }
}


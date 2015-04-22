//------------------------------------------------------------------------------
// <copyright file="CSSqlStoredProcedure.cs" company="Microsoft">
//     Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
//------------------------------------------------------------------------------
using System;
using System.Data;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using Microsoft.SqlServer.Server;

public partial class StoredProcedures
{
    [Microsoft.SqlServer.Server.SqlProcedure]
    public static void GetInvoiceReport ()
    {
        // open the Connection object for the context
        SqlConnection connection =
            new SqlConnection("Context connection=true");
        connection.Open();

        // create a string that defines the select statement
        string selectStatement =
            "SELECT VendorName, InvoiceNumber, InvoiceDate, InvoiceTotal " +
            "FROM Invoices JOIN Vendors " +
            "ON Invoices.VendorID = Vendors.VendorID " +
            "WHERE InvoiceTotal - CreditTotal - PaymentTotal > 0";

        // create the Command object
        SqlCommand selectCommand =
            new SqlCommand(selectStatement, connection);

        // use the SqlPipe object to return the data
        SqlPipe pipe = SqlContext.Pipe;
        pipe.ExecuteAndSend(selectCommand);

        // close the Connection object
        connection.Close();
    }
}

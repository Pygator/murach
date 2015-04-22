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
    public static void GetTop10Vendors ()
    {
        SqlConnection connection =
            new SqlConnection("Context connection=true");
        connection.Open();

        string selectStatement =
            "SELECT TOP 10 VendorName, SUM(InvoiceTotal) " +
            "AS InvoiceTotal " +
            "FROM Invoices JOIN Vendors " +
            "ON Invoices.VendorID = Vendors.VendorID " +
            "GROUP BY VendorName " +
            "ORDER BY SUM(InvoiceTotal) DESC";

        SqlCommand selectCommand =
            new SqlCommand(selectStatement, connection);

        SqlPipe pipe = SqlContext.Pipe;
        pipe.ExecuteAndSend(selectCommand);

        connection.Close();
    }
}

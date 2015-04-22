//------------------------------------------------------------------------------
// <copyright file="CSSqlFunction.cs" company="Microsoft">
//     Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
//------------------------------------------------------------------------------
using System;
using System.Data;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using Microsoft.SqlServer.Server;

public partial class UserDefinedFunctions
{
    [Microsoft.SqlServer.Server.SqlFunction(DataAccess = DataAccessKind.Read)]
    public static SqlInt32 GetLargestInvoice()
    {
        // open the Connection object for the context
        SqlConnection connection = new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;
        command.CommandText =
            "SELECT InvoiceID " +
            "FROM Invoices " +
            "WHERE InvoiceTotal = " +
            "(SELECT MAX(InvoiceTotal) FROM Invoices)";

        // execute the query
        int invoiceID = (int)command.ExecuteScalar();

        // close the Connection object
        connection.Close();

        // return the value
        return invoiceID;
    }
}

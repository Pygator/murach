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
    public static void GetInvoiceTotalSum(
        out SqlMoney invoiceTotalSum,
        SqlDateTime startDate,
        SqlString vendorName)
    {
        // open the Connection object for the context
        SqlConnection connection = new SqlConnection(
            "Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;

        // create a string that defines the SELECT statement
        string sql =
            "SELECT SUM(InvoiceTotal) " +
            "FROM Invoices JOIN Vendors " +
            "    ON Invoices.VendorID = Vendors.VendorID " +
            "WHERE ((InvoiceDate >= @StartDate) AND " +
            "       (VendorName LIKE @VendorName))";

        // add the query to the Command object
        command.CommandText = sql;

        // add new parameters to the Parameters collection
        SqlParameter param = new SqlParameter(
            "@StartDate", SqlDbType.DateTime);
        param.Value = startDate;
        command.Parameters.Add(param);

        param = new SqlParameter(
            "@VendorName", SqlDbType.VarChar);
        param.Value = vendorName;
        command.Parameters.Add(param);

        // assign a value to the output parameter
        try
        {
            decimal scalarValue = (decimal)command.ExecuteScalar();
            invoiceTotalSum = (SqlMoney)scalarValue;
        }
        catch  // if a null value is returned
        {
            invoiceTotalSum = 0;
        }

        // close the Connection object
        connection.Close();
    }
}

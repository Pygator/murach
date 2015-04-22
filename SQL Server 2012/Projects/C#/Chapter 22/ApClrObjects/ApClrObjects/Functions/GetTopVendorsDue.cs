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

// add this namespace
using System.Collections;

public partial class UserDefinedFunctions
{
    [Microsoft.SqlServer.Server.SqlFunction(
        TableDefinition="VendorName nvarchar(50), TotalDue money",
        FillRowMethodName="FillRow",
        DataAccess=DataAccessKind.Read)]
    public static IEnumerable GetTopVendorsDue(SqlMoney cutOff)
    {
        // open the Connection object for the context
        SqlConnection connection = new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;
        command.CommandText =
            "SELECT VendorName, SUM(InvoiceTotal) As TotalDue " +
            "FROM Vendors " +
            "    JOIN Invoices ON Vendors.VendorID = Invoices.VendorID " +
            "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0 " +
            "GROUP BY VendorName " +
            "HAVING SUM(InvoiceTotal) >= @CutOff";

        // add the parameter to the Command object
        SqlParameter param = new SqlParameter("@CutOff", SqlDbType.Money);
        param.Value = cutOff;
        command.Parameters.Add(param);

        // get the DataSet object and return the rows from the first table
        SqlDataAdapter adapter = new SqlDataAdapter(command);
        DataSet dataSet = new DataSet();
        adapter.Fill(dataSet);
        DataRowCollection rows = dataSet.Tables[0].Rows;

        // close the connection and return the rows
        connection.Close();
        return rows;
    }

    private static void FillRow(object rowObject, out SqlString vendorName,
    out SqlMoney totalDue)
    {
        DataRow row = (DataRow)rowObject;
        vendorName = (string)row["VendorName"];
        totalDue = (decimal)row["TotalDue"];
    }

}

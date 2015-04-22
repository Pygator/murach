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
    [Microsoft.SqlServer.Server.SqlFunction(DataAccess=DataAccessKind.Read)]
    public static SqlMoney GetBalanceDueSum()
    {
        // Put your code here
        // open the Connection object for the context
        SqlConnection connection = new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;
        command.CommandText =
            "SELECT SUM(InvoiceTotal - PaymentTotal - CreditTotal) " +
            "FROM Invoices " +
            "WHERE InvoiceTotal - PaymentTotal - CreditTotal > 0";

        // execute the query
        decimal balanceDueSum = Convert.ToDecimal(command.ExecuteScalar());

        // close the Connection object
        connection.Close();

        // return the value
        return balanceDueSum;
    }
}

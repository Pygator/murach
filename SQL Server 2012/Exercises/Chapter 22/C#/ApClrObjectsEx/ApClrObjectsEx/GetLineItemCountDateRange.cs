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
    public static void GetLineItemCountDateRange (
        out SqlInt32 lineItemCount,
        SqlDateTime startDate,
        SqlDateTime endDate)
    {
        if (startDate.IsNull)
            throw new ApplicationException("Invalid start date. " +
                "You must specify a start date.");
        if (startDate > DateTime.Today)
            throw new ApplicationException("Invalid start date. " +
                "The start date can't be in the future.");
        if (endDate.IsNull)
            endDate = DateTime.Today;
        if (endDate < startDate)
            throw new ApplicationException("Invalid end date. " +
                "The end date can't be before the start date.");
        SqlConnection connection = new SqlConnection("Context connection=true");
        connection.Open();

        String sql =
            "SELECT COUNT(*) " +
            "FROM InvoiceLineItems JOIN Invoices " +
            "ON InvoiceLineItems.InvoiceID = Invoices.InvoiceID " +
            "WHERE ((InvoiceDate >= @StartDate) AND " +
            "       (InvoiceDate <= @EndDate))";

        SqlCommand command = new SqlCommand(sql, connection);

        SqlParameter param = new SqlParameter("@StartDate", SqlDbType.DateTime);
        param.Value = startDate;
        command.Parameters.Add(param);

        param = new SqlParameter("@EndDate", SqlDbType.DateTime);
        param.Value = endDate;
        command.Parameters.Add(param);

        try
        {
            int scalarValue = (int)command.ExecuteScalar();
            lineItemCount = (SqlInt32)scalarValue;
        }
        catch
        {
            lineItemCount = 0;
        }

        connection.Close();
    }
}

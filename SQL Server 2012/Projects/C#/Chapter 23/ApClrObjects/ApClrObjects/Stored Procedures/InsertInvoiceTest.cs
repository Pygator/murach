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
    public static SqlInt32 InsertInvoiceTest(SqlString invoiceNumber)
    {
        // validate the invoiceNumber parameter
        if (invoiceNumber.IsNull || invoiceNumber == "")
        {
            throw new ApplicationException("Invalid InvoiceNumber. " +
                "You must specify an InvoiceNumber.");
        }

        // create and return a test invoice ID
        int newInvoiceID = 115;
        return (SqlInt32)newInvoiceID;
    }
}

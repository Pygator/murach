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
    [Microsoft.SqlServer.Server.SqlTrigger (Target="Vendors", Event="AFTER INSERT, UPDATE")]
    public static void Vendors_Update_State ()
    {
        // open the Connection object for the context
        SqlConnection connection =
            new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;

        // create a string that defines the sql statement
        string sql =
            "UPDATE Vendors " +
            "SET VendorState = UPPER(VendorState) " +
            "WHERE VendorID IN (SELECT VendorID FROM Inserted)";
        command.CommandText = sql;

        // execute the Command object
        command.ExecuteNonQuery();

        // close the Connection object
        connection.Close();
    }
}


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
    [Microsoft.SqlServer.Server.SqlTrigger (Target="Database", Event="AFTER CREATE_TABLE, DROP_TABLE")]
    public static void Database_CreateTable_DropTable ()
    {
        SqlTriggerContext tc = SqlContext.TriggerContext;
        if (tc.TriggerAction == TriggerAction.CreateTable)
        {
            SqlContext.Pipe.Send("A new table has been created.");
        }
        else if (tc.TriggerAction == TriggerAction.DropTable)
        {
            SqlContext.Pipe.Send("A table has been dropped.");
        }
        string eventData = tc.EventData.Value;
        SqlContext.Pipe.Send(eventData);
    }
}


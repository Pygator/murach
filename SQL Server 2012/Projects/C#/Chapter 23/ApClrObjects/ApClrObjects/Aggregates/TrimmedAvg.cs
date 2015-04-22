//------------------------------------------------------------------------------
// <copyright file="CSSqlAggregate.cs" company="Microsoft">
//     Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
//------------------------------------------------------------------------------
using System;
using System.Data;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using Microsoft.SqlServer.Server;

[Serializable]
[Microsoft.SqlServer.Server.SqlUserDefinedAggregate(Format.Native)]
public struct TrimmedAvg
{
    // declare four private fields (all value types)
    private SqlInt32 count;
    private SqlMoney total;
    private SqlMoney min;
    private SqlMoney max;

    public void Init()
    {
        count = 0;
        total = 0;
        min = SqlMoney.MaxValue;
        max = SqlMoney.MinValue;
    }

    public void Accumulate(SqlMoney Value)
    {
        if (!Value.IsNull)
        {
            count += 1;
            total += Value;
            if (Value < min)
                min = Value;
            if (Value > max)
                max = Value;
        }
    }

    public void Merge (TrimmedAvg Group)
    {
        count += Group.count;
        total += Group.total;
        if (Group.min < min)
            min = Group.min;
        if (Group.max > max)
            max = Group.max;
    }

    public SqlMoney Terminate ()
    {
        if (count <= 2)
            return (SqlMoney.Null);

        count -= 2;
        total -= min;
        total -= max;
        SqlMoney trimmedAvg = total / count;
        return trimmedAvg;
    }
}

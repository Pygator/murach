//------------------------------------------------------------------------------
// <copyright file="CSSqlUserDefinedType.cs" company="Microsoft">
//     Copyright (c) Microsoft Corporation.  All rights reserved.
// </copyright>
//------------------------------------------------------------------------------
using System;
using System.Data;
using System.Data.SqlClient;
using System.Data.SqlTypes;
using Microsoft.SqlServer.Server;


[Serializable]
[Microsoft.SqlServer.Server.SqlUserDefinedType(Format.Native)]
public struct MyInt32: INullable
{
    private bool isNull;
    private SqlInt32 number;
    
    public bool IsNull
    {
        get
        {
            return isNull;
        }
    }
    
    public static MyInt32 Null
    {
        get
        {
            MyInt32 h = new MyInt32();
            h.isNull = true;
            return h;
        }
    }
    
    public static MyInt32 Parse(SqlString s)
    {
        if (s.IsNull)
            return Null;
        MyInt32 u = new MyInt32();
        u.number = s.ToSqlInt32();
        return u;
    }

    public override string ToString()
    {
        return number.ToString();
    }
}
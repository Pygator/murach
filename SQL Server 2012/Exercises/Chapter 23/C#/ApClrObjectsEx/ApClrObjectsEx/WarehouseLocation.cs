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
[Microsoft.SqlServer.Server.SqlUserDefinedType(
    Format.UserDefined,
    MaxByteSize = 5)]
public struct WarehouseLocation : INullable, IBinarySerialize
{
    private bool isNull;
    private string location;

    public override string ToString()
    {
        return location;
    }
    
    public bool IsNull
    {
        get
        {
            return isNull;
        }
    }
    
    public static WarehouseLocation Null
    {
        get
        {
            WarehouseLocation warehouseLocation = new WarehouseLocation();
            warehouseLocation.isNull = true;
            return warehouseLocation;
        }
    }

    public SqlString Location
    {
        get
        {
            return location;
        }
    }

    public SqlString Rack
    {
        get
        {
            return location.Substring(0, 1);
        }

    }

    public SqlString Shelf
    {
        get
        {
            return location.Substring(1, 1);
        }
    }

    public SqlString Bin
    {
        get
        {
            return location.Substring(2);
        }
    }

    public static WarehouseLocation Parse(SqlString s)
    {
        if (s.IsNull)
            return Null;

        Validate(s);

        WarehouseLocation warehouseLocation = new WarehouseLocation();
        warehouseLocation.location = s.ToString();
        return warehouseLocation;
    }

    // user-defined data validation method

    private static void Validate(SqlString str)
    {
        string s = str.Value;
        string message = "Invalid email: " + s + ". ";

        // check that the rack is a letter
        Char rack = s[0];
        if (!Char.IsLetter(rack))
            throw new ApplicationException(message +
                "The rack must be alphabetic.");

        // check that the shelf is an integer between 1 and 5
        try
        {
            int shelf = Convert.ToInt32(s.Substring(1, 1));
            if (shelf < 1 || shelf > 5)
                throw new ApplicationException(message +
                    "The shelf must be between 1 and 5.");
        }
        catch (FormatException)
        {
            throw new ApplicationException(message +
                "The shelf must be an integer.");
        }

        // check that the bin is an integer between 1 and 50
        try
        {
            int bin = Convert.ToInt32(s.Substring(2));
            if (bin < 1 || bin > 50)
                throw new ApplicationException(message +
                    "The bin must be between 1 and 50.");
        }
        catch (FormatException)
        {
            throw new ApplicationException(message +
                "The bin must be an integer.");
        }

    }
    
    public void Read(System.IO.BinaryReader r)
    {
        location = r.ReadString();
    }

    public void Write(System.IO.BinaryWriter w)
    {
        w.Write(location);
    }
}
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
    MaxByteSize = 51,
    IsByteOrdered = true,
    IsFixedLength = true)]
public struct Email : INullable, IBinarySerialize
{
    private bool isNull;
    private string address;
    
    // required properties for handling null values

    public bool IsNull
    {
        get
        {
            return isNull;
        }
    }
    
    public static Email Null
    {
        get
        {
            Email email = new Email();
            email.isNull = true;
            return email;
        }
    }

    // user-defined, read-only properties

    public SqlString Address
    {
        get
        {
            return address;
        }
    }

    public SqlString Username
    {
        get
        {
            int atIndex = address.IndexOf("@");
            string username = address.Substring(0, atIndex);
            return username;
        }
    }

    public SqlString Domain
    {
        get
        {
            int atIndex = address.IndexOf("@");
            int length = address.Length - atIndex - 1;
            string domain = address.Substring(atIndex + 1, length);
            return domain;
        }
    }

    // required data conversion methods

    public override string ToString()
    {
        return address;
    }
    
    public static Email Parse(SqlString s)
    {
        if (s.IsNull)
            return Null;

        Validate(s);

        Email email = new Email();
        email.address = (string)s;
        return email;
    }

    // user-defined data validation method

    private static void Validate(SqlString str)
    {
        string s = str.Value;
        string message = "Invalid email: " + s + ". ";

        // check for valid @ symbol
        int atIndex = s.IndexOf("@");
        if (atIndex == -1)
            throw new ApplicationException(message +=
                "The Email type must contain an @ symbol.");
        if (atIndex == 0)
            throw new ApplicationException(message +=
                "The Email type must contain text before the @ symbol.");

        // check for valid domain name
        int periodIndex = s.IndexOf(".", atIndex);
        if (periodIndex == -1)
            throw new ApplicationException(message +=
                "The Email type must contain a period after the @ symbol.");

        // add more validation code here

    }

    public void Write(System.IO.BinaryWriter w)
    {
        address = address.PadRight(50, ' ');
        w.Write(address);
    }

    public void Read(System.IO.BinaryReader r)
    {
        address = r.ReadString();
        address = address.Trim();
    }
}
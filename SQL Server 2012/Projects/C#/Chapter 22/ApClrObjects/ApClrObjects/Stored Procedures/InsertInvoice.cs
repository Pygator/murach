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
    public static SqlInt32 InsertInvoice (
        SqlInt32 vendorID,
        SqlString invoiceNumber,
        SqlDateTime invoiceDate,
        SqlMoney invoiceTotal,
        SqlMoney paymentTotal,
        SqlMoney creditTotal,
        SqlInt32 termsID,
        SqlDateTime invoiceDueDate)
    {
        // validate any parameters that need to be validated
        if (invoiceNumber.IsNull || invoiceNumber == "")
            throw new ApplicationException("Invalid InvoiceNumber. " +
                "You must specify an InvoiceNumber.");
        if (invoiceDate.IsNull)
            throw new ApplicationException("Invalid InvoiceDate. " +
                "You must specify an InvoiceDate.");
        if (invoiceDate > DateTime.Today)
            throw new ApplicationException("Invalid InvoiceDate. " +
                "The InvoiceDate cannot be in the future.");
        if (invoiceTotal.IsNull)
            throw new ApplicationException("Invalid InvoiceTotal. " +
                "You must specify an InvoiceTotal.");
        if (invoiceTotal <= 0)
            throw new ApplicationException("Invalid InvoiceTotal. " +
                "InvoiceTotal must be greater than zero.");
        if (paymentTotal.IsNull)
            paymentTotal = 0;
        if (creditTotal.IsNull)
            creditTotal = 0;

        // if necessary, validate other parameters here

        // open the Connection object for the context
        SqlConnection connection =
            new SqlConnection("Context connection=true");
        connection.Open();

        // create the Command object
        SqlCommand command = new SqlCommand();
        command.Connection = connection;

        // validate the VendorID
        string sql = "SELECT * FROM Vendors " +
                     "WHERE VendorID = @VendorID";
        command.CommandText = sql;
        SqlParameter param = new SqlParameter("@VendorID", SqlDbType.Int);
        param.Value = vendorID;
        command.Parameters.Add(param);
        SqlDataReader reader = command.ExecuteReader();
        if (reader.Read() == false)
        {
            reader.Close();
            throw new ApplicationException("Invalid VendorID. " +
                "VendorID does not exist.");
        }
        else
        {
            reader.Close();
        }

        // if necessary, perform any other validation 
        // that requires a database lookup here

        // create the Insert query
        sql = "INSERT Invoices " +
              "VALUES (" +
                  "@VendorID, @InvoiceNumber, @InvoiceDate, " +
                  "@InvoiceTotal, @PaymentTotal, @CreditTotal, " +
                  "@TermsID, @InvoiceDueDate, NULL)";
        command.CommandText = sql;

        // clear the Parameters collection
        command.Parameters.Clear();

        // add all parameters to the Parameters collection
        param = new SqlParameter("@VendorID", SqlDbType.Int);
        param.Value = vendorID;
        command.Parameters.Add(param);

        param = new SqlParameter("@InvoiceNumber", SqlDbType.VarChar);
        param.Value = invoiceNumber;
        command.Parameters.Add(param);

        param = new SqlParameter("@InvoiceDate", SqlDbType.DateTime);
        param.Value = invoiceDate;
        command.Parameters.Add(param);

        param = new SqlParameter("@InvoiceTotal", SqlDbType.Money);
        param.Value = invoiceTotal;
        command.Parameters.Add(param);

        param = new SqlParameter("@PaymentTotal", SqlDbType.Money);
        param.Value = paymentTotal;
        command.Parameters.Add(param);

        param = new SqlParameter("@CreditTotal", SqlDbType.Money);
        param.Value = creditTotal;
        command.Parameters.Add(param);

        param = new SqlParameter("@TermsID", SqlDbType.Int);
        param.Value = termsID;
        command.Parameters.Add(param);

        param = new SqlParameter("@InvoiceDueDate", SqlDbType.DateTime);
        param.Value = invoiceDueDate;
        command.Parameters.Add(param);

        // execute the query
        command.ExecuteNonQuery();

        // get the new invoice ID
        sql = "SELECT MAX(IDENT_CURRENT('Invoices')) AS InvoiceID " +
              "FROM Invoices";
        command.CommandText = sql;
        command.Parameters.Clear();
        int newInvoiceID = Convert.ToInt32(command.ExecuteScalar());

        // close the Connection object
        connection.Close();

        // return the invoice ID
        return (SqlInt32)newInvoiceID;
    }

    // a method that provides for default values
    [Microsoft.SqlServer.Server.SqlProcedure]
    public static SqlInt32 InsertInvoiceWithDefaultValues(
        int vendorID,
        string invoiceNumber,
        DateTime invoiceDate,
        decimal invoiceTotal)
    {
        // assign default values
        decimal paymentTotal = 0;
        decimal creditTotal = 0;
        int termsID = 3;             // or look up default termsID 
        // for specified vendorID
        DateTime invoiceDueDate =
            invoiceDate.AddDays(30); // or add the number of days 
        // specified by the termsID

        // send all values to the InsertInvoice method
        SqlInt32 invoiceID = InsertInvoice(vendorID, invoiceNumber,
            invoiceDate, invoiceTotal, paymentTotal,
            creditTotal, termsID, invoiceDueDate);

        return invoiceID;
    }

}

package murach.http;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.io.*;
import java.sql.*;
import java.util.zip.*;

import murach.data.ConnectionPool;

@WebServlet("/userTableGZIP")
public class UserTableGZIPServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        String encodingString = request.getHeader("accept-encoding");
        PrintWriter out;
        if (encodingString != null && encodingString.indexOf("gzip") > -1) {
            OutputStream outputStream = response.getOutputStream();
            out = new PrintWriter(
                    new GZIPOutputStream(outputStream), false);
            response.setHeader("content-encoding", "gzip");
            // System.out.println("User table encoded with gzip");
        } else {
            out = response.getWriter();
            // System.out.println("User table not encoded with gzip");
        }

        String query = "SELECT * FROM User ORDER BY UserID";
        String d = "\t";
        StringBuilder report = new StringBuilder("The User table\n\n"
                + "UserID" + d
                + "LastName" + d
                + "FirstName" + d
                + "Email" + "\n");
        try
        {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next())
            {
                String row = results.getInt("UserID") + d
                        + results.getString("LastName")+ d
                        + results.getString("FirstName") + d
                        + results.getString("Email") + "\n";
                report.append(row);
            }
            results.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e)
        {
            this.log(e.toString());
        }        

        response.setContentType("text/tab-separated-values");
        response.setHeader("content-disposition", 
                "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");

        out.println(report);
        out.close();
    }
}
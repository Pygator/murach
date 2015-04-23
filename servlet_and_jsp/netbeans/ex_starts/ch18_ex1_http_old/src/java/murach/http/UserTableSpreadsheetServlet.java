package murach.http;

import murach.data.ConnectionPool;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.sql.*;

@WebServlet("/userTableSpreadsheet")
public class UserTableSpreadsheetServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        String query = "SELECT * FROM User ORDER BY UserID";
        String d = "\t";
        StringBuilder report = new StringBuilder("The User table\n\n"
                + "UserID" + d
                + "LastName" + d
                + "FirstName" + d
                + "Email" + "\n");
        try {
            ConnectionPool pool = ConnectionPool.getInstance();
            Connection connection = pool.getConnection();
            Statement statement = connection.createStatement();
            ResultSet results = statement.executeQuery(query);
            while (results.next()) {
                String row = results.getInt("UserID") + d
                        + results.getString("LastName") + d
                        + results.getString("FirstName") + d
                        + results.getString("Email") + "\n";
                report.append(row);
            }
            results.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            this.log(e.toString());
        }

        response.setContentType("text/tab-separated-values");
        response.setHeader("content-disposition", 
                "attachment; filename=users.xls");
        response.setHeader("cache-control", "no-cache");

        PrintWriter out = response.getWriter();
        out.println(report);
    }
}
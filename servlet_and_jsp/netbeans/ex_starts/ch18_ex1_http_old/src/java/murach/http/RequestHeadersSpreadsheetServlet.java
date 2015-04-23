package murach.http;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import java.util.*;

@WebServlet("/headersSpreadsheet")
public class RequestHeadersSpreadsheetServlet extends HttpServlet
{
    @Override
    public void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException
    {
        StringBuilder returnString = new StringBuilder();
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()){
            String name = (String) headerNames.nextElement();
            String value = request.getHeader(name);
            String headerLine = name + "\t" + value + "\n";
            returnString.append(headerLine);
        }

        response.setContentType("text/tab-separated-values");
        response.setHeader("content-disposition", 
                "attachment; filename=request_headers.xls");
        response.setHeader("cache-control", "no-cache");

        PrintWriter out = response.getWriter();
        out.println(returnString);
    }
}
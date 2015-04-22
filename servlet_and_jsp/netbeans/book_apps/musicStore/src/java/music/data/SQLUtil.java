package music.data;

import java.sql.*;

public class SQLUtil {

    public static String getHtmlRows(ResultSet results)
            throws SQLException {
        StringBuilder htmlRows = new StringBuilder();
        ResultSetMetaData metaData = results.getMetaData();
        int columnCount = metaData.getColumnCount();

        htmlRows.append("<tr>");
        String cell;
        for (int i = 1; i <= columnCount; i++) {
            cell = "<th>" + metaData.getColumnName(i) + "</th>";
            htmlRows.append(cell);
        }
        htmlRows.append("</tr>");

        while (results.next()) {
            htmlRows.append("<tr>");
            for (int i = 1; i <= columnCount; i++) {
                cell = "<td>" + results.getString(i) + "</td>";
                htmlRows.append(cell);
            }
        }
        htmlRows.append("</tr>");

        return htmlRows.toString();
    }

    public static String encode(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length(); i++) {
            char ch = sb.charAt(i);
            if (ch == 39) {  // 39 is the ASCII code for an apostrophe
                sb.insert(i++, "'");
            }
        }
        return sb.toString();
    }
}
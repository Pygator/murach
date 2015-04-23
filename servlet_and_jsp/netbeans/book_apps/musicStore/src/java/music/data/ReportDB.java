package music.data;

import java.sql.*;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReportDB {

    public static Workbook getUserEmail() {

        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("User Email Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The User Email report");

        // create the header row
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("LastName");
        row.createCell(1).setCellValue("FirstName");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("CompanyName");
        row.createCell(4).setCellValue("Address1");
        row.createCell(5).setCellValue("Address2");
        row.createCell(6).setCellValue("City");
        row.createCell(7).setCellValue("State");
        row.createCell(8).setCellValue("Zip");
        row.createCell(9).setCellValue("Country");
        row.createCell(10).setCellValue("UserID");

        // create the data rows
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String query = "SELECT * FROM User "
                + "ORDER BY LastName";
        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int i = 3;
            while (rs.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rs.getString("LastName"));
                row.createCell(1).setCellValue(rs.getString("FirstName"));
                row.createCell(2).setCellValue(rs.getString("Email"));
                row.createCell(3).setCellValue(rs.getString("CompanyName"));
                row.createCell(4).setCellValue(rs.getString("Address1"));
                row.createCell(5).setCellValue(rs.getString("Address2"));
                row.createCell(6).setCellValue(rs.getString("City"));
                row.createCell(7).setCellValue(rs.getString("State"));
                row.createCell(8).setCellValue(rs.getString("Zip"));
                row.createCell(9).setCellValue(rs.getString("Country"));
                row.createCell(10).setCellValue(rs.getInt("UserID"));
                i++;
            }
            return workbook;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }

    public static Workbook getDownloadDetail(
            String startDate, String endDate) {

        // create the workbook, its worksheet, and its title row
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("Download Report");
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("The Download report");

        // create the header rows
        row = sheet.createRow(2);
        row.createCell(0).setCellValue("Start Date: " + startDate);
        row = sheet.createRow(3);
        row.createCell(0).setCellValue("End Date: " + endDate);
        row = sheet.createRow(5);
        row.createCell(0).setCellValue("DownloadDate");
        row.createCell(1).setCellValue("ProductCode");
        row.createCell(2).setCellValue("Email");
        row.createCell(3).setCellValue("FirstName");
        row.createCell(4).setCellValue("LastName");

        // create the data rows
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        Statement statement = null;
        ResultSet rs = null;
        String query
                = "SELECT DownloadDate, "
                + "   Download.ProductCode, "
                + "   Email, FirstName, LastName "
                + "FROM User "
                + "   INNER JOIN Download ON User.UserID = Download.UserID "
                + "WHERE DownloadDate >= '" + startDate + "' "
                + "   AND DownloadDate <= '" + endDate + "' "
                + "ORDER BY DownloadDate DESC";

        try {
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
            int total = 0;
            int i = 6;
            while (rs.next()) {
                row = sheet.createRow(i);
                row.createCell(0).setCellValue(rs.getDate("DownloadDate").toString());
                row.createCell(1).setCellValue(rs.getString("ProductCode"));
                row.createCell(2).setCellValue(rs.getString("Email"));
                row.createCell(3).setCellValue(rs.getString("FirstName"));
                row.createCell(4).setCellValue(rs.getString("LastName"));
                total++;
                i++;
            }
            row = sheet.createRow(i + 1);
            row.createCell(0).setCellValue("Total Number of Downloads: " + total);
            return workbook;
        } catch (SQLException e) {
            System.err.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closeStatement(statement);
            pool.freeConnection(connection);
        }
    }
}
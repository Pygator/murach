package music.data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import music.business.Download;
import music.business.User;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ReportDB {

    public static Workbook getUserEmail() {
        
        // get the data from the database
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT u FROM User u " +
                "ORDER BY u.lastName";
        TypedQuery<User> q = em.createQuery(qString, User.class);
        List<User> users = null;
        
        try {
            users = q.getResultList();
        } catch (NoResultException e) {
            System.err.println(e);
            return null;
        } finally {
            em.close();
        }
        
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
        int i = 3;
        for (User u : users) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(u.getLastName());
            row.createCell(1).setCellValue(u.getFirstName());
            row.createCell(2).setCellValue(u.getEmail());
            row.createCell(3).setCellValue(u.getCompanyName());
            row.createCell(4).setCellValue(u.getAddress1());
            row.createCell(5).setCellValue(u.getAddress2());
            row.createCell(6).setCellValue(u.getCity());
            row.createCell(7).setCellValue(u.getState());
            row.createCell(8).setCellValue(u.getZip());
            row.createCell(9).setCellValue(u.getCountry());
            row.createCell(10).setCellValue(u.getId());
            i++;
        }
            
        return workbook;
    }
    
    public static Workbook getDownloadDetail(
            String startDate, String endDate) {
        
        // get the data from the database
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "SELECT d from Download d " +
                "WHERE d.downloadDate >= :startDate AND " +
                "d.downloadDate <= :endDate ORDER BY d.downloadDate DESC";
        TypedQuery <Download> q = em.createQuery(qString, Download.class);
        List<Download> downloads = null;
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            q.setParameter("startDate", dateFormat.parse(startDate));
            q.setParameter("endDate", dateFormat.parse(endDate));
            downloads = q.getResultList();
        } catch (ParseException e) {
            System.err.println(e.toString());
            return null;
        } finally {
            em.close();
        }
        
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
        int total = 0;
        int i = 6;
        for (Download download : downloads) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue(download.getDownloadDate().toString());
            row.createCell(1).setCellValue(download.getProductCode());
            row.createCell(2).setCellValue(download.getUser().getEmail());
            row.createCell(3).setCellValue(download.getUser().getFirstName());
            row.createCell(4).setCellValue(download.getUser().getLastName());
            total++;
            i++;
        }        
        row = sheet.createRow(i+1);
        row.createCell(0).setCellValue("Total Number of Downloads: " + total);
        
        return workbook;
    }
}
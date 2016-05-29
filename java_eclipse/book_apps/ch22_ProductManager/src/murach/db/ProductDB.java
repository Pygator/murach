package murach.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import murach.business.Product;

public class ProductDB {
    
    public static List<Product> getAll() throws DBException {        
        String sql = "SELECT * FROM Product ORDER BY ProductID";
        List<Product> products = new ArrayList<>();
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                int productID = rs.getInt("ProductID");
                String code = rs.getString("Code");
                String name  = rs.getString("Description");
                double price = rs.getDouble("ListPrice");
                
                Product p = new Product();
                p.setId(productID);
                p.setCode(code);
                p.setDescription(name);
                p.setPrice(price);
                products.add(p);
            }
            return products;
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static Product get(String productCode) throws DBException {
        String sql = "SELECT * FROM Product WHERE Code = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, productCode);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                long productId = rs.getLong("ProductID");
                String name = rs.getString("Description");
                double price = rs.getDouble("ListPrice");
                rs.close();
                
                Product p = new Product();
                p.setId(productId);
                p.setCode(productCode);
                p.setDescription(name);
                p.setPrice(price);
                
                return p;
            } else {
                rs.close();
                return null;
            }
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static void add(Product product) throws DBException {
        String sql
                = "INSERT INTO Product (Code, Description, ListPrice) "
                + "VALUES (?, ?, ?)";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }

    public static void update(Product product) throws DBException {
        String sql = "UPDATE Product SET "
                + "Code = ?, "
                + "Description = ?, "
                + "ListPrice = ? "
                + "WHERE ProductID = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, product.getCode());
            ps.setString(2, product.getDescription());
            ps.setDouble(3, product.getPrice());
            ps.setLong(4, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }        
    }
    
    public static void delete(Product product) 
            throws DBException {
        String sql = "DELETE FROM Product "
                   + "WHERE ProductID = ?";
        Connection connection = DBUtil.getConnection();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, product.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new DBException(e);
        }
    }
}
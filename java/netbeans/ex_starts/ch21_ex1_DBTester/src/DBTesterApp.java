import java.sql.*;

public class DBTesterApp
{
    private static Connection connection = null;
    
    public static void main(String args[])
    {
        // get the connection and start the Derby engine
        connection = MurachDB.getConnection();
        if (connection != null)
            System.out.println("Derby has been started.\n");
        
        // select data from database
        printProducts();
        printFirstProduct();
        printLastProduct();
        printProductByCode("java");

        // modify data in the database
        Product p = new Product("test", "Test Product", 49.50);        
        insertProduct(p);
        printProducts();
        
        deleteProduct(p);
        printProducts();

        // disconnect from the database
        if (MurachDB.disconnect())
            System.out.println("Derby has been shut down.\n");
    }

    public static void printProducts()
    {
        try (Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM Products"))
        {            
            Product p = null;

            System.out.println("Product list:");
            while(rs.next())
            {
                String code = rs.getString("ProductCode");
                String description = rs.getString("Description");
                double price = rs.getDouble("Price");

                p = new Product(code, description, price);

                printProduct(p);
            }
            System.out.println();
        }
        catch(SQLException e)
        {
            e.printStackTrace();  // for debugging
        }
    }

    public static void printFirstProduct()
    {
        Product p = null;

        // add code that prints the record for the first product in the Products table

        System.out.println("First product:");
        printProduct(p);
        System.out.println();
    }

    public static void printLastProduct()
    {
        Product p = null;

        // add code that prints the record for the last product in the Products table

        System.out.println("Last product:");
        printProduct(p);
        System.out.println();
    }

    public static void printProductByCode(String productCode)
    {
        Product p = null;

        // add code that prints the product with the specified code

        System.out.println("Product by code: " + productCode);
        printProduct(p);
        System.out.println();
    }

    public static void insertProduct(Product p)
    {
        System.out.println("Insert test: ");

        // add code that inserts the specified product into the database
        // if a product with the specifed code already exists, display an error message

        printProduct(p);
        System.out.println();
    }

    private static void deleteProduct(Product p)
    {
        System.out.println("Delete test: ");

        // add code that deletes the specified product from the database
        // if a product with the specified code doesn't exist, display an error message

        printProduct(p);
        System.out.println();
    }

    // use this method to print a Product object on a single line
    private static void printProduct(Product p)
    {
        String productString =
            StringUtils.padWithSpaces(p.getCode(), 8) +
            StringUtils.padWithSpaces(p.getDescription(), 44) +
            p.getFormattedPrice();

        System.out.println(productString);
    }
}
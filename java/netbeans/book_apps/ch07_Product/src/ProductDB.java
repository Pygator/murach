public class ProductDB
{

    public static Product getProduct(String productCode)
    {
        // In a more realistic application, this code would
        // get the data for the product from a file or database
        // For now, this code just uses if/else statements
        // to return the correct product data

        // create the product
        Product p = new Product();
        p.setCode(productCode);

        // set the
        if (productCode.equalsIgnoreCase("java"))
        {
            p.setDescription("Murach's Beginning Java");
            p.setPrice(49.50);
        }
        else if (productCode.equalsIgnoreCase("jsps"))
        {
            p.setDescription("Murach's Java Servlets and JSP");
            p.setPrice(49.50);
        }
        else if (productCode.equalsIgnoreCase("mcb2"))
        {
            p.setDescription("Murach's Mainframe COBOL");
            p.setPrice(59.50);
        }
        else
        {
            p.setDescription("Unknown");
        }
        return p;
    }
}
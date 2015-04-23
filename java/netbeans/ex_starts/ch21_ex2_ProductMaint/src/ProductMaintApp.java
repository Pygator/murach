import java.util.Scanner;
import java.util.ArrayList;

public class ProductMaintApp implements ProductConstants
{
    // declare two class variables
    private static ProductDAO productDAO = null;
    private static Scanner sc = null;

    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Product Maintenance application\n");

        // set the class variables
        productDAO = DAOFactory.getProductDAO();
        sc = new Scanner(System.in);

        // display the command menu
        displayMenu();

        // perform 1 or more actions
        String action = "";
        while (!action.equalsIgnoreCase("exit"))
        {
            // get the input from the user
            action = Validator.getString(sc,
                "Enter a command: ");
            System.out.println();

            if (action.equalsIgnoreCase("list"))
                displayAllProducts();
            else if (action.equalsIgnoreCase("add"))
                addProduct();
            else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete"))
                deleteProduct();
            else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu"))
                displayMenu();
            else if (action.equalsIgnoreCase("exit"))
                System.out.println("Bye.\n");
            else
                System.out.println("Error! Not a valid command.\n");
        }
    }

    public static void displayMenu()
    {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all products");
        System.out.println("add     - Add a product");
        System.out.println("del     - Delete a product");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllProducts()
    {
        System.out.println("PRODUCT LIST");

        ArrayList<Product> products = productDAO.getProducts();
        if (products == null)
        {
            System.out.println("Error! Unable to get products.\n");
        }
        else
        {
            Product p = null;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < products.size(); i++)
            {
                p = products.get(i);
                sb.append(StringUtils.padWithSpaces(
                    p.getCode(), CODE_SIZE + 4));
                sb.append(StringUtils.padWithSpaces(
                    p.getDescription(), DESCRIPTION_SIZE + 4));
                sb.append(p.getFormattedPrice());
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public static void addProduct()
    {
        String code = Validator.getString(
            sc, "Enter product code: ");
        String description = Validator.getLine(
            sc, "Enter product description: ");
        double price = Validator.getDouble(
            sc, "Enter price: ");

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);
        boolean success = productDAO.addProduct(product);

        System.out.println();
        if (success)
            System.out.println(description
                + " was added to the database.\n");
        else
            System.out.println("Error! Unable to add product\n");
    }

    public static void deleteProduct()
    {
        String code = Validator.getString(sc,
            "Enter product code to delete: ");

        Product p = productDAO.getProduct(code);

        System.out.println();
        if (p != null)
        {
            boolean success = productDAO.deleteProduct(p);
            if (success)
                System.out.println(p.getDescription()
                    + " was deleted from the database.\n");
            else
                System.out.println("Error! Unable to add product\n");
        }
        else
        {
            System.out.println("No product matches that code.\n");
        }
    }
}
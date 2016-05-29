package murach.ui;

import java.util.List;
import murach.business.Product;
import murach.io.ProductIO;

public class Main {

    public static void main(String args[]) {

        // display a welcome message
        System.out.println("Welcome to the Product Manager\n");

        // display the command menu
        displayMenu();

        // perform 1 or more actions
        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            // get the input from the user
            action = Console.getString("Enter a command: ");
            System.out.println();

            if (action.equalsIgnoreCase("list")) {
                displayAllProducts();
            } else if (action.equalsIgnoreCase("add")) {
                addProduct();
            } else if (action.equalsIgnoreCase("del") || 
                       action.equalsIgnoreCase("delete")) {
                deleteProduct();
            } else if (action.equalsIgnoreCase("help") || 
                       action.equalsIgnoreCase("menu")) {
                displayMenu();
            } else if (action.equalsIgnoreCase("exit")) {
                System.out.println("Bye.\n");
            } else {
                System.out.println("Error! Not a valid command.\n");
            }
        }
    }

    public static void displayMenu() {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all products");
        System.out.println("add     - Add a product");
        System.out.println("del     - Delete a product");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllProducts() {
        System.out.println("PRODUCT LIST");

        List<Product> products = ProductIO.getAll();
        
        if (products == null) {
            System.out.println("\nError! Unable to get products.\n");
        } else {
            Product p;
            StringBuilder sb = new StringBuilder();
            for (Product product : products) {
                p = product;
                sb.append(StringUtil.padWithSpaces(
                        p.getCode(), 12));
                sb.append(StringUtil.padWithSpaces(
                        p.getDescription(), 34));
                sb.append(p.getFormattedPrice());
                sb.append("\n");
            }
            System.out.println(sb.toString());
        }
    }

    public static void addProduct() {
        String code = Console.getString("Enter product code: ");
        String description = Console.getString("Enter product description: ");
        double price = Console.getDouble("Enter price: ");

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);

        ProductIO.add(product);
        System.out.println("\n" + description
                + " was added to the database.\n");
    }

    public static void deleteProduct() {
        String code = Console.getString("Enter product code to delete: ");

        Product product = ProductIO.get(code);
        if (product == null) {
            System.out.println("\nError! Unable to get product.");
        }
        else {        
            ProductIO.delete(product);        
            System.out.println("\n" + product.getDescription() + 
                    " was deleted from the database.\n");
        }
    }
}
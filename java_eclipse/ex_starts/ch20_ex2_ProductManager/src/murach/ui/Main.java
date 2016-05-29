package murach.ui;

import java.util.List;
import murach.business.Product;
import murach.db.DBException;
import murach.db.DBUtil;
import murach.db.ProductDB;

public class Main {

    // declare a class variable
    public static void main(String args[]) {
        
        // display a welcome message
        Console.displayNewLine();
        Console.display("Welcome to the Product Manager\n");

        // display the command menu
        displayMenu();

        // perform 1 or more actions
        String action = "";
        while (!action.equalsIgnoreCase("exit")) {
            // get the input from the user
            action = Console.getString("Enter a command: ");
            Console.displayNewLine();

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
                Console.display("Bye.\n");
            } else {
                Console.display("Error! Not a valid command.\n");
            }
        }
    }

    public static void displayMenu() {
        Console.display("COMMAND MENU");
        Console.display("list    - List all products");
        Console.display("add     - Add a product");
        Console.display("del     - Delete a product");
        Console.display("help    - Show this menu");
        Console.display("exit    - Exit this application\n");
    }

    public static void displayAllProducts() {
        Console.display("PRODUCT LIST");

        List<Product> products = null;
        try {
            products = ProductDB.getAll();
        } catch (DBException e) {
            Console.display(e + "\n");
        }
        
        if (products == null) {
            Console.display("Error! Unable to get products.\n");
        } else {
            Product p;
            StringBuilder sb = new StringBuilder();
            for (Product product : products) {
                p = product;
                sb.append(StringUtil.padWithSpaces(
                        p.getCode(), 12));
                sb.append(StringUtil.padWithSpaces(
                        p.getDescription(), 34));
                sb.append(p.getPriceFormatted());
                sb.append("\n");
            }
            Console.display(sb.toString());
        }
    }

    public static void addProduct() {
        String code = Console.getString("Enter product code: ");
        String description = Console.getString("Enter product name: ");
        double price = Console.getDouble("Enter price: ");

        Product product = new Product();
        product.setCode(code);
        product.setDescription(description);
        product.setPrice(price);
            
        try {
            ProductDB.add(product);
            Console.display(product.getDescription()
                    + " was added to the database.\n");
        } catch (DBException e) {
            Console.display("Error! Unable to add product.");
            Console.display(e + "\n");
        }
    }

    public static void deleteProduct() {
        String code = Console.getString("Enter product code to delete: ");

        Product product;
        try {
            product = ProductDB.get(code);
            if (product == null) {
                throw new Exception("Product not found.");
            }
        } catch (Exception e) {
            Console.display("Error! Unable to delete product.");
            Console.display(e + "\n");
            return;
        }
        
        try {
            ProductDB.delete(product);
        } catch (DBException e) {
            Console.display("Error! Unable to delete product.");
            Console.display(e + "\n");
        }
        
        Console.display(product.getDescription() + " was deleted from the database.\n");
    }
    
    public static void exit() {
        try {
            DBUtil.closeConnection();
        } catch (DBException e) {
            Console.display("Error! Unable to close connection.");
            Console.display(e + "\n");
        }
        System.out.println("Bye.\n");
        System.exit(0);
    }
    
}
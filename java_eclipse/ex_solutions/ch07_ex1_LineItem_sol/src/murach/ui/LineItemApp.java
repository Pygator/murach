package murach.ui;

import java.util.Scanner;

import murach.db.ProductDB;
import murach.business.LineItem;
import murach.business.Product;

public class LineItemApp {

    public static void main(String args[]) {
        // display a welcome message
        System.out.println("Welcome to the Line Item Calculator");
        System.out.println();
        
        // declare counter variable
        byte count = 0;
        float total = 0;
        float max = 0;
        float min = 3.4e38f;

        // create 1 or more line items
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            System.out.print("Enter product code: ");
            String productCode = sc.nextLine();

            System.out.print("Enter quantity:     ");
            int quantity = Integer.parseInt(sc.nextLine());
            
            // get the Product object
            Product product = ProductDB.getProduct(productCode);

            // create the LineItem object
            LineItem lineItem = new LineItem(product, quantity);

            // display the output
            String message = "\nLINE ITEM\n" +
                "Code:        " + product.getCode() + "\n" +
                "Description: " + product.getDescription() + "\n" +
                "Price:       " + product.getPriceFormatted() + "\n" +
                "Quantity:    " + lineItem.getQuantity() + "\n" +
                "Total:       " + lineItem.getTotalFormatted() + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
            
            // increment counter variable
            count++;
            total += lineItem.getTotal();
            max = Math.max(max, lineItem.getTotal());
            min = Math.min(min, lineItem.getTotal());
        }
        System.out.println("Number of line items: " + count);        
        System.out.println("Invoice total: " + total);        
        System.out.println("Largest line item: " + max);        
        System.out.println("Smallest line item: " + min + "\n");
        sc.close();
        System.out.println("Bye!");   
    }
}
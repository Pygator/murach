package murach.lineitem;

import java.text.NumberFormat;
import java.util.Scanner;

public class LineItemApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Line Item Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get input from user
            System.out.print("Enter product code: ");
            String productCode = sc.nextLine();

            System.out.print("Enter quantity:     ");
            int quantity = Integer.parseInt(sc.nextLine());

            // set product price based on product code
            double price;
            String description;
            if (productCode.equalsIgnoreCase("java")) {
                price = 57.50;
                description = "Murach's Java Programming";
            } else if (productCode.equalsIgnoreCase("jsp")) {
                price = 57.50;
                description = "Murach's Java Servlets and JSP";
            } else if (productCode.equalsIgnoreCase("mysql")) {
                price = 54.50;
                description = "Murach's MySQL";
            } else if (productCode.equalsIgnoreCase("android")) {
                price = 54.50;
                description = "Murach's Android Programming";
            } else {
                description = "Unknown product";
                price = 0;
            }
            
            // calculate total
            double total = price * quantity;
            
            // format and display output
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            String message = "\nLINE ITEM\n" +
                "Code:        " + productCode + "\n" +
                "Description: " + description + "\n" +
                "Price:       " + currency.format(price) + "\n" +
                "Quantity:    " + quantity + "\n" +
                "Total:       " + currency.format(total) + "\n";
            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        sc.close();
        System.out.println("Bye!");
    }
}
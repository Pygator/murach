package murach.lineitem;

import java.util.Scanner;

import murach.business.*;
import murach.database.*;
import murach.presentation.*;

public class LineItemApp
{
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Line Item Calculator");
        System.out.println();

        // perform 1 or more calculations
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input scanner
            Scanner sc = new Scanner(System.in);

            // get the input from the user
            String productCode = Validator.getStringInput(sc,
                "Enter product code: ");
            int quantity = Validator.getIntInput(sc,
                "Enter quantity:     ", 0, 1000);

            // use the ProductDB class to get the Product object
            Product product = ProductDB.getProduct(productCode);

            // create the LineItem object
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);

            // display the output
            System.out.println();
            System.out.println("LINE ITEM");
            System.out.println("Code:        " + product.getCode());
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price:       " + product.getFormattedPrice());
            System.out.println("Quantity:    " + lineItem.getQuantity());
            System.out.println("Total:       " +
                lineItem.getFormattedTotal() + "\n");

            // see if the user wants to continue
            choice = Validator.getStringInput(sc, "Continue? (y/n): ");
            System.out.println();
        }
    }
}
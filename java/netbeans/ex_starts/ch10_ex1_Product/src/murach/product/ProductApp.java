package murach.product;

import java.util.Scanner;

import murach.business.*;
import murach.database.*;
import murach.presentation.*;

public class ProductApp
{
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Weclome to the Product Selector");
        System.out.println();

        // perform 1 or more selections
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            String productCode =
                Validator.getStringInput(sc, "Enter product code: ");

            // get the Product object
            Product p = ProductDB.getProduct(productCode);

             // display the output
            System.out.println();
            System.out.println("SELECTED PRODUCT");
            System.out.println("Description: " + p.getDescription());
            System.out.println("Price:       " + p.getFormattedPrice());
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}
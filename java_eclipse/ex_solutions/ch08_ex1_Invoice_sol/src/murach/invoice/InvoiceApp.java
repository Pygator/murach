package murach.invoice;

import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String choice = "y";

        while (true) {
            // get the input from the user
            System.out.print("Enter customer type (r/c/t): ");
            String customerType = sc.nextLine();
            System.out.print("Enter subtotal:   ");
            
            double subtotal;
            try {
                subtotal = Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
                continue;
            }

            // get the discount percent
            double discountPercent;
            switch (customerType) {
                case "r": 
                    if (subtotal < 100) {
                        discountPercent = 0.0;
                    }
                    else if (subtotal >= 100 && subtotal < 250) {
                        discountPercent = .1;
                    }
                    else if (subtotal >= 250 && subtotal < 500) {
                        discountPercent = .25;
                    }
                    else {
                        discountPercent = .3;                    
                    }
                    break;
                case "t":
                    if (subtotal < 500) {
                        discountPercent = .4;
                    }
                    else {
                        discountPercent = .5;
                    }
                    break;
                case "c":
                    discountPercent = .2;
                    break;
                default:
                    discountPercent = 0.0;
                    break;
            }

            // calculate the discount amount and total
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                    "Discount percent: " + percent.format(discountPercent) + "\n"
                    + "Discount amount:  " + currency.format(discountAmount) + "\n"
                    + "Total:            " + currency.format(total) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
            
            if (choice.equalsIgnoreCase("n")) {
            	sc.close();
                break;
            }
        }
    }
}
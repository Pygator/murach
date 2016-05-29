package murach.invoice;

import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvoiceApp {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();

        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (!choice.equalsIgnoreCase("n")) {
            // get the input from the user
            System.out.print("Enter subtotal:   ");
            String subtotalLine = sc.nextLine();
            double subtotal = new BigDecimal(subtotalLine)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            // get discount percent based on subtotal
            double discountPercent;
            if (subtotal >= 200) {
                discountPercent = .2;
            } else if (subtotal >= 100) {
                discountPercent = .1;
            } else {
                discountPercent = 0;
            }

            // calculate discount amount
            double discountAmount = subtotal * discountPercent;
            discountAmount = new BigDecimal(discountAmount)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            // calculate total before tax
            double totalBeforeTax = subtotal - discountAmount;
            
            // calculate sales tax
            final double SALES_TAX_PCT = .05;
            double salesTax = SALES_TAX_PCT * totalBeforeTax;
            salesTax = new BigDecimal(salesTax)
                    .setScale(2, RoundingMode.HALF_UP)
                    .doubleValue();

            // calculate total
            double total = totalBeforeTax + salesTax;

            // get the currency and percent formatter objects
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();

            // display the data
            String message = "\nINVOICE\n" +
                "Subtotal:         " + currency.format(subtotal) + "\n"
              + "Discount percent: " + percent.format(discountPercent) + "\n"
              + "Discount amount:  " + currency.format(discountAmount) + "\n"
              + "Total before tax: " + currency.format(totalBeforeTax) + "\n"
              + "Sales tax:        " + currency.format(salesTax) + "\n"
              + "Invoice total:    " + currency.format(total) + "\n";

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
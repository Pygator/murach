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
            BigDecimal subtotal = new BigDecimal(sc.nextLine())
                    .setScale(2, RoundingMode.HALF_UP);

            // calculate the discount amount and invoice total before tax
            BigDecimal discountPercent;
            if (subtotal.doubleValue() >= 200) {
                discountPercent = new BigDecimal(".2");
            } else if (subtotal.doubleValue() >= 100) {
                discountPercent = new BigDecimal(".1");
            } else {
                discountPercent = new BigDecimal("0");
            }

            // calculate discount amount
            BigDecimal discountAmount = subtotal.multiply(discountPercent)
                    .setScale(2, RoundingMode.HALF_UP);

            // declare and initialize the sales tax constant
            final double SALES_TAX_PCT = .05;

            // calculate total before tax
            BigDecimal totalBeforeTax = subtotal.subtract(discountAmount);
            
            // calculate sales tax
            BigDecimal salesTaxPercent = new BigDecimal(SALES_TAX_PCT);
            BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax)
                    .setScale(2, RoundingMode.HALF_UP);
            
            // calculate total
            BigDecimal total = totalBeforeTax.add(salesTax);


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
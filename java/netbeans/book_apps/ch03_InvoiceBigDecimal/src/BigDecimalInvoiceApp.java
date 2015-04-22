import java.util.Scanner;
import java.text.NumberFormat;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class BigDecimalInvoiceApp
{
    public static void main(String[] args)
    {
        // declare and initialize the sales tax constant
        final double SALES_TAX_PCT = .05;
        
        // create a Scanner object named sc
        Scanner sc = new Scanner(System.in);

        // perform invoice calculations until choice isn't equal to "y" or "Y"
        String choice = "y";
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter subtotal:   ");
            double subtotal = sc.nextDouble();

            // calculate the discount amount and invoice total before tax
            double discountPercent = 0.0;
            if (subtotal >= 200)
                discountPercent = .2;
            else if (subtotal >= 100)
                discountPercent = .1;
            else
                discountPercent = 0.0;

            // convert subtotal and discount percent to BigDecimal
            BigDecimal decimalSubtotal = new BigDecimal(Double.toString(subtotal));
            decimalSubtotal = decimalSubtotal.setScale(2, RoundingMode.HALF_UP);
            BigDecimal decimalDiscountPercent = new BigDecimal(Double.toString(discountPercent));

            // calculate discount amount
            BigDecimal discountAmount = decimalSubtotal.multiply(decimalDiscountPercent);
            discountAmount = discountAmount.setScale(2, RoundingMode.HALF_UP);

            // calculate total before tax, sales tax, and total
            BigDecimal totalBeforeTax = decimalSubtotal.subtract(discountAmount);
            BigDecimal salesTaxPercent = new BigDecimal(SALES_TAX_PCT);
            BigDecimal salesTax = salesTaxPercent.multiply(totalBeforeTax);
            salesTax = salesTax.setScale(2, RoundingMode.HALF_UP);
            BigDecimal total = totalBeforeTax.add(salesTax);

            // get the currency and percent formatter objects
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();

            // display the discount amount and total
            String message = "Subtotal:         " + currency.format(decimalSubtotal) + "\n"
                           + "Discount percent: " + percent.format(decimalDiscountPercent) + "\n"
                           + "Discount amount:  " + currency.format(discountAmount) + "\n"
                           + "Total before tax: " + currency.format(totalBeforeTax) + "\n"
                           + "Sales tax:        " + currency.format(salesTax) + "\n"
                           + "Invoice total:    " + currency.format(total) + "\n";

            System.out.println(message);

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
}
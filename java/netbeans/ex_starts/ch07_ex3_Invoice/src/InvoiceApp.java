import java.text.NumberFormat;
import java.util.Scanner;

public class InvoiceApp
{
    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Invoice Total Calculator");
        System.out.println();  // print a blank line

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while(choice.equalsIgnoreCase("y"))
        {
            // get user entries
            String customerType = Validator.getString(sc,
                "Enter customer type (r/c):   ");
            double subtotal = Validator.getDouble(sc,
                "Enter subtotal:              ", 0, 10000);

            // calculate the discount amount and total
            double discountPercent = getDiscountPercent(subtotal, customerType);
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;

            // format the values
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            String sSubtotal = currency.format(subtotal);
            String sCustomerType = "Unknown";
            if (customerType.equalsIgnoreCase("r"))
                sCustomerType = "Retail";
            else if (customerType.equalsIgnoreCase("c"))
                sCustomerType = "College";
            String sDiscountPercent = percent.format(discountPercent);
            String sDiscountAmount = currency.format(discountAmount);
            String sTotal = currency.format(total);

            // format and display the results
            String message = "Subtotal:         " + sSubtotal + "\n"
                           + "Customer type:    " + sCustomerType + "\n"
                           + "Discount percent: " + sDiscountPercent + "\n"
                           + "Discount amount:  " + sDiscountAmount + "\n"
                           + "Total:            " + sTotal + "\n";
            System.out.println();
            System.out.println(message);

            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }

    static double getDiscountPercent(double subtotal, String type)
    {
        double discountPercent = 0.0;
        if (type.equalsIgnoreCase("r"))
        {
            if (subtotal >= 500)
                discountPercent = .2;
            else if (subtotal >= 250 && subtotal < 500)
                discountPercent =.15;
            else if (subtotal >= 100 && subtotal < 250)
                discountPercent =.1;
            else if (subtotal < 100)
                discountPercent =.0;
        }
        else if (type.equalsIgnoreCase("c"))
        {
                discountPercent = .2;
        }
        else
            discountPercent = .05;

        return discountPercent;
     }
}
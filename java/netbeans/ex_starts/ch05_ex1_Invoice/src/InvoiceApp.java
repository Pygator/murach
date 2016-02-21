import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class InvoiceApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            String customerType = getValidCustomerType(sc,"Enter customer type (r/c): ");
            double subtotal;
//            System.out.print("Enter customer type (r/c): ");
//            String customerType = sc.next();
            try {
            System.out.print("Enter subtotal:   ");
            subtotal = sc.nextDouble();
            }
            catch (InputMismatchException e){
                sc.next();
                System.out.println("Error: Invalid number");
                continue;
            }
            // get the discount percent
            double discountPercent = 0;
            if (customerType.equalsIgnoreCase("R"))
            {
                if (subtotal < 100)
                    discountPercent = 0;
                else if (subtotal >= 100 && subtotal < 250)
                    discountPercent = .1;
                else if (subtotal >= 250)
                    discountPercent = .2;
            }
            else if (customerType.equalsIgnoreCase("C"))
            {
                if (subtotal < 250)
                    discountPercent = .2;
                else
                    discountPercent = .3;
            }
            else
            {
                discountPercent = .1;
            }
            
            // calculate the discount amount and total
            double discountAmount = subtotal * discountPercent;
            double total = subtotal - discountAmount;
            
            // format and display the results
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            System.out.println(
                    "Discount percent: " + percent.format(discountPercent) + "\n" +
                    "Discount amount:  " + currency.format(discountAmount) + "\n" +
                    "Total:            " + currency.format(total) + "\n");
            
            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }
    public static String getValidCustomerType(Scanner sc, String prompt) {
        String custType;
        boolean isValid = false;
        
        custType = "none";
        while (isValid == false){
            custType = getAlphaString(sc, prompt);
            isValid = custType.equalsIgnoreCase("c") || custType.equalsIgnoreCase("r");
        }
        return custType;
    }
    public static String getAlphaString(Scanner sc, String prompt)
    {
      String alphaString;
      alphaString = "none";
      boolean isValid = false;
      while (isValid == false){
          System.out.print(prompt);
 //          while (!sc.hasNext("[A-Za-z]+")) 
          if (!sc.hasNext("[A-Za-z]+")) {
              System.out.println(
                      "Error! Invalid string value. Try Again.");
          }
          else {
              alphaString = sc.next();
              isValid = true;
          }
          sc.nextLine();
      }
      return alphaString;
    }
}
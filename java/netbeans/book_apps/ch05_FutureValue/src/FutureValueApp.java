import java.util.Scanner;
import java.text.NumberFormat;

public class FutureValueApp
{
    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator\n");
        Scanner sc = new Scanner(System.in);

        // get the input from the user
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            double monthlyInvestment = 0.0;
            double interestRate = 0.0;
            int years = 0;
            try
            {
                System.out.print("Enter monthly investment:   ");
                monthlyInvestment = sc.nextDouble();
                System.out.print("Enter yearly interest rate: ");
                interestRate = sc.nextDouble();
                System.out.print("Enter number of years:      ");
                years = sc.nextInt();
            }
            catch (Exception e)
            {
                sc.next();   // discard the invalid number
                System.out.println("Error! Invalid number. Try again.\n");
                continue;    // jump to start of loop
            }

            // calculate future value
            double monthlyInterestRate = interestRate/12/100;
            int months = years * 12;
            double futureValue = calculateFutureValue(
                monthlyInvestment, monthlyInterestRate, months);

            // format and display the result
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            System.out.println("Future value:               "
                              + currency.format(futureValue) + "\n");

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.next();
            System.out.println();
        }
    }

    private static double calculateFutureValue(double monthlyInvestment,
    double monthlyInterestRate, int months)
    {
        double futureValue = 0;
        for (int i = 1; i <= months; i++)
            futureValue =
                (futureValue + monthlyInvestment) *
                (1 + monthlyInterestRate);
        return futureValue;
    }
}
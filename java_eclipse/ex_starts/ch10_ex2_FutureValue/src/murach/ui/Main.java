package murach.ui;

import java.text.NumberFormat;
import murach.calculators.Financial;

public class Main {

    public static void main(String[] args) {
        // displayLine a welcome message
        Console.displayLine("Welcome to the Future Value Calculator");
        Console.displayLine();

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            double monthlyInvestment = 
                    Console.getDouble("Enter monthly investment:   ");
            double yearlyInterestRate = 
                    Console.getDouble("Enter yearly interest rate: ");            
            int years = 
                    Console.getInt("Enter number of years:      ");
            
            // call the future value method
            double futureValue = Financial.calculateFutureValue(
                    monthlyInvestment, yearlyInterestRate, years);

            // format and displayLine the result
            Console.displayLine("Future value:               " + 
                    NumberFormat.getCurrencyInstance().format(futureValue));
            Console.displayLine();

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }
        Console.displayLine("Bye!");
    }
}
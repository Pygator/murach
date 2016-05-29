package murach.ui;

import java.text.NumberFormat;
import java.util.ArrayList;

import murach.calculators.Financial;

public class Main {

    public static void main(String[] args) {
        // create an array list to store the calculations
        ArrayList<String> calculations = new ArrayList<>();
        
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

            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // format and display the result
            Console.displayLine("Future value:               " + 
                    currency.format(futureValue));
            Console.displayLine();
            
            // format the calculation and store it in the list
            String result = currency.format(monthlyInvestment) + "\t"
                + percent.format(yearlyInterestRate/100) + "\t"
                + Integer.toString(years) + "\t"
                + currency.format(futureValue);
            calculations.add(result);

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }
        
        // print the list of calculations
        Console.displayLine("Future Value Calculations");
        Console.displayLine();
        Console.displayLine("Inv/Mo.\tRate\tYears\tFuture Value");
        for (String calculation : calculations) {
            Console.displayLine(calculation);
        }
        Console.displayLine();
        
        Console.displayLine("Bye!");
    }
}
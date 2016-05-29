package murach.ui;

import java.text.NumberFormat;
import murach.calculators.Financial;

public class Main {

    public static void main(String[] args) {
        // intitialize the 2-dimensional array and its index
        String calculations[][] = new String[10][4];
        int row = 0;

        // displayLine a welcome message
        Console.displayLine("Welcome to the Future Value Calculator");
        Console.displayLine();

        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            double monthlyInvestment
                    = Console.getDouble("Enter monthly investment:   ");
            double yearlyInterestRate
                    = Console.getDouble("Enter yearly interest rate: ");
            int years
                    = Console.getInt("Enter number of years:      ");

            // call the future value method
            double futureValue = Financial.calculateFutureValue(
                    monthlyInvestment, yearlyInterestRate, years);

            // format and displayLine the result
            Console.displayLine("Future value:               "
                    + NumberFormat.getCurrencyInstance().format(futureValue));
            Console.displayLine();

            // get the currency and percent formatters
            NumberFormat currency = NumberFormat.getCurrencyInstance();
            NumberFormat percent = NumberFormat.getPercentInstance();
            percent.setMinimumFractionDigits(1);

            // format the values and store them in the array
            calculations[row][0] = currency.format(monthlyInvestment);
            calculations[row][1] = percent.format(yearlyInterestRate / 100);
            calculations[row][2] = Integer.toString(years);
            calculations[row][3] = currency.format(futureValue);

            // increment the row counter
            row++;

            // see if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            Console.displayLine();
        }

        // print the contents of the calculations array
        Console.displayLine("Future Value Calculations");
        Console.displayLine();
        Console.displayLine("Inv/Mo.\tRate\tYears\tFuture Value");
        for (int i = 0; i < row; i++) {
            String message = "";
            for (int j = 0; j < 4; j++) {
                message += calculations[i][j] + "\t";
            }
            Console.displayLine(message);
        }
        Console.displayLine();

        Console.displayLine("Bye!");
    }
}
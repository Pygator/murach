package murach.fv;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Future Value Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);        
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {

            // get input from user
            System.out.print("Enter monthly investment:   ");
            double monthlyInvestment = Double.parseDouble(sc.nextLine());

            System.out.print("Enter yearly interest rate: ");
            double yearlyInterestRate = Double.parseDouble(sc.nextLine());

            System.out.print("Enter number of years:      ");
            int years = Integer.parseInt(sc.nextLine());                        
            
            // convert yearly values to monthly values
            double monthlyInterestRate = yearlyInterestRate / 12 / 100;
            int months = years * 12;        

            // calculate the future value
            double futureValue = 0;
            int i = 1;
            while (i <= months) {
                futureValue = futureValue + monthlyInvestment;
                double monthlyInterestAmount = 
                        futureValue * monthlyInterestRate;
                futureValue = futureValue + monthlyInterestAmount;            
                i = i + 1;
            }            

            // format and display the result
            System.out.println("Future value:               " + 
                    NumberFormat.getCurrencyInstance().format(futureValue));
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
        sc.close();
        System.out.println("Bye!");
    }
}
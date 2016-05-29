package murach.agecalculator;

import java.util.Scanner;

public class AgeCalculatorApp {

    public static void main(String[] args) {
        System.out.println("Welcome to the Age Calculator\n");

        // Get input from the the user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your date of birth (YYYY-MM-DD): ");
        String dateOfBirthString = sc.nextLine();
        System.out.println();
        
        // Get and print user's date of birth
        System.out.println("Your date of birth is ");

        // Get and print the current date
        System.out.println("The current date is ");

        //Calculate the user's age
                
        //Print the user's age
        System.out.println("Your age is ");
        sc.close();
    }
}
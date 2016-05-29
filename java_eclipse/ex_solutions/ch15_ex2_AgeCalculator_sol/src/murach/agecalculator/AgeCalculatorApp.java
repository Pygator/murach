package murach.agecalculator;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
        LocalDate dateOfBirth = LocalDate.parse(dateOfBirthString);
        DateTimeFormatter mediumDate = 
                DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println("Your date of birth is " + 
                mediumDate.format(dateOfBirth));

        // Get and print the current date
        LocalDate currentDate = LocalDate.now();
        System.out.println("The current date is " + 
                mediumDate.format(currentDate));

        //Calculate the user's age
        int age = currentDate.getYear() - dateOfBirth.getYear();
        
        //Subtract 1 if the user's birthday is after the current date
        LocalDate birthday = dateOfBirth.withYear(currentDate.getYear());        
        if (birthday.isAfter(currentDate)) {
            age -= 1;
        }
        
        //Print the user's age
        System.out.println("Your age is " + age);
        sc.close();
    }
}
package murach.presentation;

import java.util.Scanner;

public class Validator
{
    
    public static String getStringInput(Scanner sc, String prompt)
    {
        boolean isValid = false;
        String s = "";
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNext())
            {
                s = sc.nextLine(); // read entire line
                isValid = true;
            }
            else
            {
                System.out.println("Error! Invalid string value. Try again.");
            }
        }
        return s;
    }
    
    public static double getDoubleInput(Scanner sc, String prompt)
    {
        boolean isValid = false;
        double d = 0;
        while (isValid == false)
        {
            System.out.print(prompt);
            if (sc.hasNextDouble())
            {
                d = sc.nextDouble();
                isValid = true;
            }
            else
            {
                sc.next();     // discard the incorrectly entered double
                System.out.println("Error! Invalid decimal value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return d;
    }
    
    public static double getDoubleInput(Scanner sc, String prompt,
            double min, double max)
    {
        double d = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            d = getDoubleInput(sc, prompt);
            if (d <= min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (d >= max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return d;
    }
    
    public static int getIntInput(Scanner sc, String prompt)
    {
        boolean isValidInt = false;
        int i = 0;
        while (isValidInt == false)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                i = sc.nextInt();
                isValidInt = true;
            }
            else
            {
                sc.next();  // discard invalid data
                System.out.println("Error! Invalid integer value. Try again.");
            }
            sc.nextLine();  // discard any other data entered on the line
        }
        return i;
    }
    
    public static int getIntInput(Scanner sc, String prompt,
            int min, int max)
    {
        int i = 0;
        boolean isValid = false;
        while (isValid == false)
        {
            i = getIntInput(sc, prompt);
            if (i <= min)
                System.out.println(
                        "Error! Number must be greater than " + min);
            else if (i >= max)
                System.out.println(
                        "Error! Number must be less than " + max);
            else
                isValid = true;
        }
        return i;
    }    
}

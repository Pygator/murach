import java.util.*;
import java.text.DateFormat;

public class AgeCalculatorApp
{
    public static void main(String[] args)
    {
        //Get the user's birthdate
        System.out.println("Welcome to the age calculator.");
        Scanner sc = new Scanner(System.in);
        int birthMonth = Validator.getInt(sc, "Enter the month you were born (1 to 12): ",
            0, 13);
        int birthDay = Validator.getInt(sc, "Enter the day of the month you were born: ",
            0, 32);
        int birthYear = Validator.getInt(sc, "Enter the year you were born (four digits): ",
        1874, 2005);

    }
}

import java.util.Scanner;

public class SSNValidatorApp
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String ssn = Validator.getLine(sc, "Enter a Social Security Number: ");
        System.out.println("You entered: " + ssn);
    }
}
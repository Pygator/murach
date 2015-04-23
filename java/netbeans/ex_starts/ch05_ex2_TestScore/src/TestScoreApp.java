import java.util.Scanner;
import java.text.NumberFormat;

public class TestScoreApp
{
    public static void main(String[] args)
    {
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        double averageScore = 0;

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (!choice.equalsIgnoreCase("n"))
        {
            // get the input from the user
            System.out.print("Enter score: ");
            testScore = sc.nextInt();

            scoreCount += 1;
            scoreTotal += testScore;

            averageScore = (double) scoreTotal / (double) scoreCount;

            // see if the user wants to enter more test scores
            System.out.print("Enter another test score? (y/n): ");
            choice = sc.next();
        }

        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMaximumFractionDigits(1);
        String message = "\n" +
                         "Score count:   " + scoreCount + "\n"
                       + "Score total:   " + scoreTotal + "\n"
                       + "Average score: " + number.format(averageScore) + "\n";
        System.out.println(message);
    }
}
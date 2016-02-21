
import java.util.Scanner;

public class TestScoreApp {

    public static void main(String[] args) {
        // display operational messages
        System.out.println("Please enter test scores that range from 0 to 100.");
        System.out.println("To end the program enter 999.");
        System.out.println();  // print a blank line

        // initialize variables and create a Scanner object
        int scoreTotal = 0;
        int scoreCount = 0;
        int testScore = 0;
        Scanner sc = new Scanner(System.in);
        Scanner userContinue = new Scanner(System.in);
        String enterMoreScores = "Y";

        while (enterMoreScores.equalsIgnoreCase("y")) {
            // get a series of test scores from the user
            scoreCount = 0;
            System.out.print("Enter the number of test scores to be entered: ");
            scoreCount = sc.nextInt();

            for (int loopCount = 1; loopCount <= scoreCount; loopCount++) {
                // get the input from the user
                System.out.print("Enter score: ");
                testScore = sc.nextInt();

                // accumulate score count and score total
                if (testScore <= 100) {
                    //scoreCount = scoreCount + 1;
                    scoreTotal = scoreTotal + testScore;
                } else {
                    System.out.println("Invalid entry, not counted");
                    loopCount--;
                }
            }

            // display the score count, score total, and average score
            double averageScore = scoreTotal / scoreCount;
            String message = "\n"
                    + "Score count:   " + scoreCount + "\n"
                    + "Score total:   " + scoreTotal + "\n"
                    + "Average score: " + averageScore + "\n";
            System.out.println(message);

            System.out.print("Enter more test scores? (y/n):");
            enterMoreScores = userContinue.next();
        }

    }
}

package murach.ui;

import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);
    
    public static void displayNewLine() {
        System.out.println();
    }

    public static void display(String string) {
        System.out.println(string);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();        // read the whole line
        return s;
    }

    public static int getInt(String prompt) {
        boolean isValid = false;
        int i = 0;
        while (isValid == false) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                isValid = true;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer value. Try again.");
            }
        }
        return i;
    }

    public static int getInt(String prompt, int min, int max) {
        int i = 0;
        boolean isValid = false;
        while (isValid == false) {
            i = getInt(prompt);
            if (i <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min);
            } else if (i >= max) {
                System.out.println(
                        "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        boolean isValid = false;
        double d = 0;
        while (isValid == false) {
            System.out.print(prompt);
            try {
                d = Double.parseDouble(sc.nextLine());
                isValid = true;                
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal value. Try again.");
            }
        }
        return d;
    }

    public static double getDouble(String prompt,
            double min, double max) {
        double d = 0;
        boolean isValid = false;
        while (isValid == false) {
            d = getDouble(prompt);
            if (d <= min) {
                System.out.println(
                        "Error! Number must be greater than " + min);
            } else if (d >= max) {
                System.out.println(
                        "Error! Number must be less than " + max);
            } else {
                isValid = true;
            }
        }
        return d;
    }
}
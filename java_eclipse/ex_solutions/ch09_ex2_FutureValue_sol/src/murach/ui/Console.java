package murach.ui;

import java.util.Scanner;

public class Console {

    private static Scanner sc = new Scanner(System.in);
    
    public static void displayLine() {
        System.out.println();
    }

    public static void displayLine(String s) {
        System.out.println(s);
    }

    public static String getString(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine();
        return s;
    }

    public static int getInt(String prompt) {
        int i = 0;
        while (true) {
            System.out.print(prompt);
            try {
                i = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid integer. Try again.");
            }
        }
        return i;
    }

    public static double getDouble(String prompt) {
        double d = 0;
        while (true) {
            System.out.print(prompt);
            try {
                String line = sc.nextLine();
                
                // this removes any $ and % signs from the string
                String temp = "";
                for(int i = 0; i < line.length(); i++) {
                   if (line.charAt(i) != '$' && line.charAt(i) != '%') {
                      temp += line.charAt(i);
                   }
                }
                line = temp;
                
                d = Double.parseDouble(line);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Error! Invalid decimal. Try again.");
            }
        }
        return d;
    }
}
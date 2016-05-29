package murach.test;

import java.io.*;

public class ExceptionTesterApp {

    public static void main(String[] args) {
        System.err.println("In main: calling Method1.");
        Method1();
        System.err.println("In main: returned from Method1.");
    }

    public static void Method1() {
        System.err.println("\tIn Method1: calling Method2.");
        try {
            Method2();
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        }
        System.err.println("\tIn Method1: returned from Method2.");
    }

    public static void Method2() throws FileNotFoundException {
        System.err.println("\t\tIn Method2: calling Method3.");
        Method3();
        System.err.println("\t\tIn Method2: returned from Method3.");
    }

    public static void Method3() throws FileNotFoundException {
        System.err.println("\t\t\tIn Method3: Entering.");

        BufferedReader in = new BufferedReader(new FileReader("products.txt"));
        try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

        System.err.println("\t\t\tIn Method3: Exiting.");
    }
}

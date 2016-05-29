package murach.test;

import java.io.*;

public class CustomTesterApp {

    public static void main(String[] args) {
        Method1();
    }

    public static void Method1() {
        Method2();
    }

    public static void Method2() {
        try {
            Method3();
        } catch (TestException e) {
            System.out.println("A test exception occurred.");
            System.out.println("Cause: " + e.getCause().toString());
        }
    }

    public static void Method3() throws TestException {
        try {
            throw new IOException("An I/O exception occurred.");
        } catch (IOException e) {
            throw new TestException(e);
        }
    }
}

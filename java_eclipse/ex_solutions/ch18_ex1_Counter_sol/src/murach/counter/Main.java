package murach.counter;

public class Main {

    // Use these constants as the starting values for the two counter threads
    public static final int ODD = 1;
    public static final int EVEN = 2;

    public static void main(String[] args) {
        System.out.println("Main started.");
        Thread odd = new CounterThread(ODD);
        Thread even = new CounterThread(EVEN);
        odd.start();
        even.start();

        System.out.println("Main finished.");
    }

}

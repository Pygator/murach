package murach.test;

public class DisplayableTestApp {

    public static void main(String args[]) {
        System.out.println("Welcome to the Displayable Test application\n");

        // create an Employee object and display it
        Displayable e = new Employee(2, "Smith", "John");
        displayOnConsole(e);

        // create a Product object and display it
        Displayable p = new Product("java", "Murach's Java Programming", 57.50);
        displayOnConsole(p);
        
        System.out.println();        
    }

    private static void displayOnConsole(Displayable d) {
        System.out.println(d.getDisplayText());
    }
}
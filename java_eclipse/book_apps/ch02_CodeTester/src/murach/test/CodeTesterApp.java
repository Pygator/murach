package murach.test;

public class CodeTesterApp {

    public static void main(String args[]) {
        // display a welcome message
        System.out.println("Welcome to the Code Tester");
        System.out.println();

        // hard code three values
        String productCode = "java";
        double price = 49.50;
        int quantity = 2;

        // perform a calculation
        double total = price * quantity;
            
        // display the output
        String message = 
            "Code:     " + productCode + "\n" +
            "Price:    " + price + "\n" +
            "Quantity: " + quantity + "\n" +
            "Total:    " + total + "\n";
        System.out.println(message);

        // display a goodbye message
        System.out.println("Bye!");
    }
}
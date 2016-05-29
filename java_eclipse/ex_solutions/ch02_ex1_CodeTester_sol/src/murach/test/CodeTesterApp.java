package murach.test;

public class CodeTesterApp {

    public static void main(String args[]) {
        // display a welcome message
        System.out.println("Welcome to the Code Tester");
        System.out.println();

        // calculate and display a total
        String productCode = "android";
        String description = "Murach's Android Programming";
        double price = 57.50;
        int quantity = 2;
        double total = price * quantity;
        double taxPercent = .075;
        double taxAmount = total * taxPercent;
        double grandTotal = total + taxAmount;
        String message = 
            "Code:        " + productCode + "\n" +
            "Description: " + description + "\n" +
            "Price:       " + price + "\n" +
            "Quantity:    " + quantity + "\n" +
            "Total:       " + total + "\n" +
            "Tax Percent: " + taxPercent * 100 + "\n" +
            "Tax Amount:  " + taxAmount + "\n" +
            "Grand Total: " + grandTotal + "\n";
        System.out.println(message);

        // display your name        
        String firstName = "Joel";
        firstName = "Mike";
        String lastName = "Murach";
        String name = lastName + ", " + firstName;
        System.out.println("Name: " + name + "\n");
        
        // calculate and display an average        
        double sum = 301.75;
        sum = 200.12;
        int count = 6;
        double average = sum / count;
        System.out.println("Sum:     " + sum);
        System.out.println("Count:   " + count);        
        System.out.println("Average: " + average + "\n");

        // display a goodbye message
        System.out.println("Bye!");
    }
}

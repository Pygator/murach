package murach.ui;

public class Main {

    public static void main(String[] args) {
        System.out.println("Welcome to the Month Selector\n");
        
        String[] monthName = {"January", "February", "March", "April", "May", 
            "June", "July", "August", "September", "October", "November", 
            "December"};
                
        // select 1 or more months
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            // get the input from the user
            int monthNumber = Console.getInt("Enter month number: ");
            
            // validate input
            if (monthNumber < 1 || monthNumber > monthName.length) {
                Console.displayLine("Invalid month number. Try again.");
                continue;                
            }
            
            // display output            
            int monthIndex = monthNumber - 1;
            Console.displayLine("You selected:       " 
                    + monthName[monthIndex] + "\n");

            // check if the user wants to continue
            choice = Console.getString("Continue? (y/n): ");
            System.out.println();
        }
    }    
}
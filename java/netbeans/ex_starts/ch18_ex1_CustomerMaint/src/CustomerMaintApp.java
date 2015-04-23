import java.util.Scanner;
import java.util.ArrayList;

public class CustomerMaintApp implements CustomerConstants
{
    // declare class variables
    private static CustomerDAO customerDAO = null;
    private static Scanner sc = null;

    public static void main(String[] args)
    {
        // display a welcome message
        System.out.println("Welcome to the Customer Maintenance application\n");

        // set the class variables
        customerDAO = DAOFactory.getCustomerDAO();
        sc = new Scanner(System.in);

        // display the command menu
        displayMenu();

        // perform 1 or more actions
        String action = "";
        while (!action.equalsIgnoreCase("exit"))
        {
            // get the input from the user
            action = Validator.getString(sc,
                    "Enter a command: ");
            System.out.println();

            if (action.equalsIgnoreCase("list"))
                displayAllCustomers();
            else if (action.equalsIgnoreCase("add"))
                addCustomer();
            else if (action.equalsIgnoreCase("del") || action.equalsIgnoreCase("delete"))
                deleteCustomer();
            else if (action.equalsIgnoreCase("help") || action.equalsIgnoreCase("menu"))
                displayMenu();
            else if (action.equalsIgnoreCase("exit") || action.equalsIgnoreCase("quit"))
                System.out.println("Bye.\n");
            else
                System.out.println("Error! Not a valid command.\n");
        }
    }
    
    public static void displayMenu()
    {
        System.out.println("COMMAND MENU");
        System.out.println("list    - List all customers");
        System.out.println("add     - Add a customer");
        System.out.println("del     - Delete a customer");
        System.out.println("help    - Show this menu");
        System.out.println("exit    - Exit this application\n");
    }

    public static void displayAllCustomers()
    {
        System.out.println("CUSTOMER LIST");

        ArrayList<Customer> customers = customerDAO.getCustomers();
        Customer c = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < customers.size(); i++)
        {
            c = customers.get(i);
            sb.append(StringUtils.padWithSpaces(
                    c.getName(), NAME_SIZE + 2));
            sb.append(c.getEmail());
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void addCustomer()
    {
        String firstName = Validator.getLine(
                sc, "Enter first name: ");
        String lastName = Validator.getString(
                sc, "Enter last name: ");
        String email = Validator.getString(
                sc, "Enter customer email: ");

        Customer customer = new Customer();
        customer.setFirstName(firstName);
        customer.setLastName(lastName);
        customer.setEmail(email);        
        customerDAO.addCustomer(customer);

        System.out.println();
        System.out.println(firstName + " " + lastName
                + " has been added.\n");
    }

    public static void deleteCustomer()
    {
        String email = Validator.getString(sc,
                "Enter email to delete: ");

        Customer c = customerDAO.getCustomer(email);

        System.out.println();
        if (c != null)
        {
            customerDAO.deleteCustomer(c);
            System.out.println(c.getName()
            + " has been deleted.\n");
        }
        else
        {
            System.out.println("No customer matches that email.\n");
        }
    }
}

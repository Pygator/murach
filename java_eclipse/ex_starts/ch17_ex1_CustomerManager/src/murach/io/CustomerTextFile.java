package murach.io;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import murach.business.Customer;

public class CustomerTextFile {
    private static final String FIELD_SEP = "\t";
    private static final Path customersPath = null;      // add code here
    private static final File customersFile = null;      // add code here
    private static ArrayList<Customer> customers = null; // add code here
    
    // prevent instantiation of the class
    private CustomerTextFile() {}

    public static List<Customer> getCustomers() {
        // if the customers file has already been read, don't read it again
        if (customers != null)
            return customers;        

        customers = new ArrayList<>();  
        
        // load the array list with Customer objects created from
        // the data in the file
        

        return customers;            
    }

    public static Customer getCustomer(String email) {
        for (Customer c : customers) {
            if (c.getEmail().equals(email)) {
                return c;
            }
        }
        return null;
    }

    public static boolean addCustomer(Customer c) {
        customers.add(c);
        return saveCustomers();
    }

    public static boolean deleteCustomer(Customer c) {
        customers.remove(c);
        return saveCustomers();
    }

    public static boolean updateCustomer(Customer newCustomer) {
        // get the old customer and remove it
        Customer oldCustomer = getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return saveCustomers();
    }

    private static boolean saveCustomers() {
        // save the Customer objects in the array list to the file
        return true;
    }
}
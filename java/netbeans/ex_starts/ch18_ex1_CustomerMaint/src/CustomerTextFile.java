import java.util.*;
import java.io.*;
import java.nio.file.*;

public final class CustomerTextFile implements CustomerDAO
{
    private ArrayList<Customer> customers = null;
    private Path customersPath = null;
    private File customersFile = null;

    private final String FIELD_SEP = "\t";

    public CustomerTextFile()
    {
        // initialize the class variables
    }

    public ArrayList<Customer> getCustomers()
    {
        // if the customers file has already been read, don't read it again
        if (customers != null)
            return customers;        

        customers = new ArrayList<>();  
        
        // load the array list with Customer objects created from
        // the data in the file
        

        return customers;            
    }

    public Customer getCustomer(String email)
    {
        for (Customer c : customers)
        {
            if (c.getEmail().equals(email))
                return c;
        }
        return null;
    }

    public boolean addCustomer(Customer c)
    {
        customers.add(c);
        return this.saveCustomers();
    }

    public boolean deleteCustomer(Customer c)
    {
        customers.remove(c);
        return this.saveCustomers();
    }

    public boolean updateCustomer(Customer newCustomer)
    {
        // get the old customer and remove it
        Customer oldCustomer = this.getCustomer(newCustomer.getEmail());
        int i = customers.indexOf(oldCustomer);
        customers.remove(i);

        // add the updated customer
        customers.add(i, newCustomer);

        return this.saveCustomers();
    }

    private boolean saveCustomers()
    {   
        // save the Customer objects in the array list to the file

        
        return true;
    }	
}
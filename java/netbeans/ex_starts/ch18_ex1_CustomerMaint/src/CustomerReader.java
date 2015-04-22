import java.util.ArrayList;

public interface CustomerReader
{
    Customer getCustomer(String email);
    ArrayList<Customer> getCustomers();
}
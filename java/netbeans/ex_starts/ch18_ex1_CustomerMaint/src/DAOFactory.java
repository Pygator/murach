public class DAOFactory
{
    // this method maps the ProductDAO interface
    // to the appropriate data storage mechanism
    public static CustomerDAO getCustomerDAO()
    {
        CustomerDAO cDAO = new CustomerTextFile();
        return cDAO;
    }
}
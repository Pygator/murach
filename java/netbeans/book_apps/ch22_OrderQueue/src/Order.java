public class Order
{
    private int number;

    public Order(int number)
    {
        this.number = number;
    }

    @Override
    public String toString()
    {
        return "Order #" + number;
    }
}
public class OrderTaker extends Thread
{
    private static int orderNumber = 1;

    private int count = 0;
    private int maxOrders;
    private OrderQueue orderQueue;
    
    public OrderTaker(int orderCount, OrderQueue orderQueue)
    {
        this.maxOrders = orderCount;         // number of orders to create
        this.orderQueue = orderQueue;        // order queue
    }

    @Override
    public void run()
    {
        Order order;
        while (count < maxOrders)
        {
            order = new Order(getOrderNumber());
            orderQueue.pushOrder(order);     // add order to the queue
            System.out.println(order.toString() + " created by " 
                + this.getName());
            count++;
            try
            {
                Thread.sleep(1000);          // delay one second
            }
            catch (InterruptedException e)
            {}                               // ignore interruptions
        }
    }

    private static synchronized int getOrderNumber()
    {
        return orderNumber++;
    }
}
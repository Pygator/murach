public class ProductCloneApp
{
    public static void main(String args[]) throws CloneNotSupportedException
    {
        System.out.println("Welcome to the Product Clone Test\n");

        // create a new product
        Product p1 = new Product();
        p1.setCode("java");
        p1.setDescription("Murach's Beginning Java");
        p1.setPrice(49.50);

        // clone the product
        Product p2 = (Product) p1.clone();

        // change a value in the cloned product
        p2.setPrice(44.50);

        if (p1.getPrice() == p2.getPrice())
        {
            System.out.println("FAILURE: The clone method of the Product class is not cloning data.");
        }
        else if (p1.getPrice() != p2.getPrice())
        {
            System.out.println("SUCCESS: The clone method of the Product class is cloning data.");
        }
        System.out.println();
    }
}
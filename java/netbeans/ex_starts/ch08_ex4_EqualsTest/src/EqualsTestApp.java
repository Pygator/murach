public class EqualsTestApp
{
    public static void main(String args[])
    {
        System.out.println("Welcome to the Equals Tester\n");

        //Both variables refer to different objects that store the same data
        Product product1 = new Product();
        Product product2 = new Product();

        if (product1.equals(product2))
            System.out.println("The equals method of the Product class is comparing data.");
        else
            System.out.println("The equals method of the Product class is comparing references.");

        //Both variables refer to different objects that store the same data
        LineItem li1 = new LineItem();
        li1.setProduct(product1);
        LineItem li2 = new LineItem();
        li2.setProduct(product2);
        if (li1.equals(li2))
            System.out.println("The equals method of the LineItem class is comparing data.");
        else
            System.out.println("The equals method of the LineItem class is comparing references.");

        System.out.println();
    }
}
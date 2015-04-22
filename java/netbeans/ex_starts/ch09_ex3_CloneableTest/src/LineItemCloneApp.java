public class LineItemCloneApp
{
    public static void main(String args[]) throws CloneNotSupportedException
    {
        // welcome the user to the program
        System.out.println("Weclome to the Line Item Clone Test");
        System.out.println();

        // create a new product
        Product p1 = new Product();
        p1.setCode("java");
        p1.setDescription("Murach's Beginning Java");
        p1.setPrice(49.50);

        // create a new line item
        LineItem li1 = new LineItem();
        li1.setProduct(p1);
        li1.setQuantity(3);

        // clone the line item
        LineItem li2 = (LineItem) li1.clone();

        // change a value in the cloned line item
        // and in the Product object it contains
        li2.setQuantity(2);
        li2.getProduct().setPrice(44.50);

        // print the results
        System.out.println(li1);
        System.out.println(li2);

        System.out.println();
    }
}
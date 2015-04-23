import java.util.Scanner;

public class ProductApp
{
    public static void main(String args[])
    {
        // display a welcome message
        System.out.println("Welcome to the Product Selector");
        System.out.println();

        // display 1 or more products
        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            System.out.print("Enter product code: ");
            String productCode = sc.next();  // read the product code
            sc.nextLine();  // discard any other data entered on the line

            // get the Product object
            Product product = ProductDB.getProduct(productCode);

            // display the output
            System.out.println();
            System.out.println("SELECTED PRODUCT");
            System.out.println("Description: " + product.getDescription());
            System.out.println("Price:       " + product.getFormattedPrice());
            System.out.println();

            // see if the user wants to continue
            System.out.print("Continue? (y/n): ");
            choice = sc.nextLine();
            System.out.println();
        }
    }
}
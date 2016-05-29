package murach.product;

public class ProductTesterApp {

    public static void main(String args[]) {
        // display a welcome message
        System.out.println("Welcome to the Product Tester");
        System.out.println();

        // create the Product object
        Product product = new Product();
        System.out.println("Product object created with default constructor.\n");
        
        // print Product data to console
        String message = 
            "Code:         " + product.getCode() + "\n" +
            "Description:  " + product.getDescription() + "\n" +
            "Price:        " + product.getPriceFormatted() + "\n";        
        System.out.println(message);
        
        // set data in the Product object
        product.setCode("java");
        product.setDescription("Murach's Java Programming");
        product.setPrice(57.50);
        System.out.println("Data set in Product object with set methods.\n");

        // print Product data to console
        message = 
            "Code:         " + product.getCode() + "\n" +
            "Description:  " + product.getDescription() + "\n" +
            "Price:        " + product.getPriceFormatted() + "\n";        
        System.out.println(message);
        
        // set data in the Product object with constructor
        product = new Product("mysql", "Murach's MySQL", 54.50);
        System.out.println("Product object created with second constuctor.");
        System.out.println("Data set in Product object by constructor.\n");

        // print Product data to console
        message = 
            "Code:         " + product.getCode() + "\n" +
            "Description:  " + product.getDescription() + "\n" +
            "Price:        " + product.getPriceFormatted() + "\n";        
        System.out.println(message);        
    }
}
import java.util.ArrayList;
import java.io.*;
import javax.xml.stream.*;  // StAX API

public class XMLTesterApp
{
    private static String productsFilename = "products.xml";

    public static void main(String[] args)
    {
        System.out.println("Products list:");
        ArrayList<Product> products = readProducts();
        printProducts(products);

/*
        Product p1 = new Product("test", "XML Tester", 77.77);
        products.add(p1);
        writeProducts(products);
        System.out.println("XML Tester has been added to the XML document.\n");
*/

        System.out.println("Products list:");
        products = readProducts();
        printProducts(products);

/*
        products.remove(2);
        writeProducts(products);
        System.out.println("XML Tester has been deleted from the XML document.\n");
*/

        System.out.println("Products list:");
        products = readProducts();
        printProducts(products);

    }

    private static ArrayList<Product> readProducts()
    {
        ArrayList<Product> products = new ArrayList<>();
        Product p = null;

        // add code that reads the XML document from the products.xml file

        return products;
    }

    private static void writeProducts(ArrayList<Product> products)
    {
        // add code that writes the XML document to the products.xml file
    }

    private static void printProducts(ArrayList<Product> products)
    {
        for (Product p : products)
        {
            printProduct(p);
        }
        System.out.println();
    }

    private static void printProduct(Product p)
    {
        String productString =
            StringUtils.padWithSpaces(p.getCode(), 8) +
            StringUtils.padWithSpaces(p.getDescription(), 44) +
            p.getFormattedPrice();

        System.out.println(productString);
    }
}
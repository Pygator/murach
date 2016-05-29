package murach.io;

import java.util.*;
import java.io.*;
import java.nio.file.*;
import murach.business.Product;

public class ProductIO {
    private static final Path productsPath = Paths.get("products.txt");
    private static final File productsFile = productsPath.toFile();
    private static final String FIELD_SEP = "\t";
    private static List<Product> products = getAll();

    // prevent instantiation of class
    private ProductIO() {}

    public static List<Product> getAll() {
        // if the products file has already been read, don't read it again
        if (products != null) {
            return products;
        }

        products = new ArrayList<>();        
        if (Files.exists(productsPath)) {
            try (BufferedReader in = new BufferedReader(
                                     new FileReader(productsFile))) {
                // read all products stored in the file into the array list
                String line = in.readLine();
                while(line != null) {
                    String[] columns = line.split(FIELD_SEP);
                    String code = columns[0];
                    String description = columns[1];
                    String price = columns[2];

                    Product p = new Product();
                    p.setCode(code);
                    p.setDescription(description);
                    p.setPrice(Double.parseDouble(price));
                    products.add(p);

                    line = in.readLine();                    
                }
            }
            catch(IOException e) {
                System.out.println(e);
                return null;
            }
        }
        return products;
    }

    public static Product get(String code) {
        for (Product p : products) {
            if (p.getCode().equals(code))
                return p;
        }
        return null;
    }

    private static boolean saveAll() {
        try (PrintWriter out = new PrintWriter(
                               new BufferedWriter(
                               new FileWriter(productsFile)))) {
            // write all products in the array list to the file
            for (Product p : products) {
                out.print(p.getCode() + FIELD_SEP);
                out.print(p.getDescription() + FIELD_SEP);
                out.println(p.getPrice());
            }
        }
        catch(IOException e) {
            System.out.println(e);
            return false;
        }

        return true;
    }

    public static boolean add(Product p) {
        products.add(p);
        return saveAll();
    }

    public static boolean delete(Product p) {
        products.remove(p);
        return saveAll();
    }

    public static boolean update(Product newProduct) {
        // get the old product and remove it
        Product oldProduct = get(newProduct.getCode());
        int i = products.indexOf(oldProduct);
        products.remove(i);

        // add the updated product
        products.add(i, newProduct);

        return saveAll();
    }
}
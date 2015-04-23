package murach.db;

import java.io.*;
import java.util.*;
import murach.business.*;

public class ProductTextFile implements ProductDAO
{
    private ArrayList<Product> products = null;
    private File productsFile = null;

    private final String FIELD_SEP = "\t";

    public ProductTextFile()
    {
        productsFile = new File("products.txt");
        products = this.getProducts();
    }

    private void checkFile() throws IOException
    {
        // if the file doesn't exist, create it
        if (!productsFile.exists())
            productsFile.createNewFile();
    }

    private boolean saveProducts()
    {
        PrintWriter out = null;
        try
        {
            this.checkFile();

            // open output stream for overwriting
            out = new PrintWriter(
                  new BufferedWriter(
                  new FileWriter(productsFile)));

            // write all products in the array list
            // to the file
            for (Product p : products)
            {
                out.print(p.getCode() + FIELD_SEP);
                out.print(p.getDescription() + FIELD_SEP);
                out.println(p.getPrice());
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return false;
        }
        finally
        {
            this.close(out);
        }
        return true;
    }

    private void close(Closeable stream)
    {
        try
        {
            if (stream != null)
                stream.close();
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts()
    {
        // if the products array has been created, don't create it again
        if (products != null)
            return copyProducts();

        BufferedReader in = null;
        try
        {
            this.checkFile();

            in = new BufferedReader(
                 new FileReader(productsFile));

            products = new ArrayList<Product>();

            // read all products stored in the file
            // into the array list
            String line = in.readLine();
            while(line != null)
            {
                String[] columns = line.split(FIELD_SEP);
                String code = columns[0];
                String description = columns[1];
                String price = columns[2];

                Product p = new Product(
                    code, description, Double.parseDouble(price));
                products.add(p);

                line = in.readLine();
            }
        }
        catch(IOException ioe)
        {
            ioe.printStackTrace();
            return null;
        }
        finally
        {
            this.close(in);
        }
        ArrayList<Product> productsCopy = new ArrayList<Product>();
        for (Product p : products)
            productsCopy.add(p);
        return copyProducts();
    }

    private ArrayList<Product> copyProducts()
    {
        ArrayList<Product> productsCopy = new ArrayList<Product>();
        for (Product p : products)
            productsCopy.add(p);
        return productsCopy;
    }

    public Product getProduct(String code)
    {
        for (Product p : products)
        {
            if (p.getCode().equals(code))
                return p;
        }
        return null;
    }

    public boolean addProduct(Product p)
    {
         products.add(p);
        return this.saveProducts();
    }

    public boolean deleteProduct(Product p)
    {
        products.remove(p);
        return this.saveProducts();
    }

    public boolean updateProduct(Product newProduct)
    {
        // get the old product and remove it
        Product oldProduct = this.getProduct(newProduct.getCode());
        int i = products.indexOf(oldProduct);
        products.remove(i);

        // add the updated product
        products.add(i, newProduct);

        return this.saveProducts();
    }
}

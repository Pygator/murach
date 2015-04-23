import java.io.*;
import java.util.*;
import java.nio.file.*;

public class ProductTextFile implements ProductDAO
{

    private ArrayList<Product> products = null;
    private Path path = null;
    private File file = null;
    private boolean fileHasChanges = true;

    private final String FIELD_SEP = "\t";

    public ProductTextFile()
    {
        products = new ArrayList<Product>();
        path = Paths.get("products.txt");
        file = path.toFile();
        getProducts();
    }

    private void getProducts()
    {
        try
        {
            // if the file doesn't exists, create it
            if (!Files.exists(path))
                Files.createFile(path);

            BufferedReader in =
                new BufferedReader(
                    new FileReader(file));

            if (fileHasChanges)
                products.clear();

            String line = in.readLine();
            while(line != null)
            {
                StringTokenizer t = new StringTokenizer(line, FIELD_SEP);
                String code = t.nextToken();
                String description = t.nextToken();
                String price = t.nextToken();

                Product p = new Product();
                p.setCode(code);
                p.setDescription(description);
                p.setPrice(Double.parseDouble(price));

                products.add(p);

                line = in.readLine();
            }
            in.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    private void saveProducts()
    {
        try
        {
            PrintWriter out = new PrintWriter(
                    new BufferedWriter(
                    new FileWriter(file)));

            Product p = null;
            for (int i = 0; i < products.size(); i++)
            {
                p = products.get(i);
                out.println(
                    p.getCode() + FIELD_SEP +
                    p.getDescription() + FIELD_SEP +
                    p.getPrice());
            }

            out.close();

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    private String padWithSpaces(String s, int length)
    {
        if (s.length() < length)
        {
            StringBuilder sb = new StringBuilder(s);
            while(sb.length() < length)
            {
                sb.append(" ");
            }
            return sb.toString();
        }
        else
        {
            return s.substring(0, length);
        }
    }

    //*************************************************
    //* Implement the ProductReader interface
    //*************************************************

    public Product getProduct(String code)
    {
        Product p = null;
        for (int i = 0; i < products.size(); i++)
        {
            p = products.get(i);
            if (p.getCode().equals(code))
                return p;
        }
        return null;
    }

    public String getProductsString()
    {
        Product p = null;
        String s = "";
        for (int i = 0; i < products.size(); i++)
        {
            p = products.get(i);
            String col1 =
                this.padWithSpaces(p.getCode(), CODE_SIZE + 4);
            String col2 =
                this.padWithSpaces(p.getDescription(), DESCRIPTION_SIZE + 4);
            s += col1 + col2 + p.getFormattedPrice() + "\n";
        }
        return s;
    }

    //*************************************************
    //* Implement the ProductWriter interface
    //*************************************************

    public boolean addProduct(Product p)
    {
        products.add(p);
        saveProducts();
        fileHasChanges = true;
        getProducts();
        return true;
    }

    public boolean deleteProduct(Product p)
    {
        products.remove(p);
        saveProducts();
        fileHasChanges = true;
        getProducts();
        return true;
     }

    public boolean updateProduct(Product p)
    {
        int i = products.indexOf(p);
        products.remove(i);
        products.add(i, p);
        saveProducts();
        fileHasChanges = true;
        getProducts();
        return true;
    }

}
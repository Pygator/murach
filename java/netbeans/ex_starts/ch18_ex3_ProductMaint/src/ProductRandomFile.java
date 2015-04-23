import java.io.*;
import java.util.*;

public class ProductRandomFile implements ProductDAO
{
    private RandomAccessFile productsFile = null;
    private ArrayList<String> productCodes = null;

    private final int PRICE_SIZE = 8;  // doubles are 8 bytes
    private final int RECORD_SIZE =
        CODE_SIZE * 2 +          // from the ProductConstants interface
        DESCRIPTION_SIZE * 2 +   // from the ProductConstants interface
        PRICE_SIZE;
    private final String DELETION_CODE = "    ";

    public ProductRandomFile()
    {
        try
        {
            productsFile = new RandomAccessFile("products.ran", "rw");
            productCodes = this.getCodes();
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }

    //*************************************************
    // Private methods for reading products
    //*************************************************

    private int getRecordCount() throws IOException
    {
        int recordCount = (int) productsFile.length() / RECORD_SIZE;
        return recordCount;
    }

    private int getRecordNumber(String productCode)
    {
        for (int i = 0; i < productCodes.size(); i++)
        {
            String code = productCodes.get(i);
            if (productCode.equals(code))
                return i;
        }
        return -1;  // no record matches the product code
    }

    private Product getRecord(int recordNumber) throws IOException
    {
        if (recordNumber >= 0 && recordNumber < this.getRecordCount())
        {
            productsFile.seek(recordNumber * RECORD_SIZE);

            String code = IOStringUtils.readFixedString(
                productsFile, CODE_SIZE);
            String description = IOStringUtils.readFixedString(
                productsFile, DESCRIPTION_SIZE);
            double price = productsFile.readDouble();

            Product product = new Product(code, description, price);
            return product;
        }
        else
        {
            return null;
        }
    }

    private ArrayList<String> getCodes()
    {
        try
        {
            ArrayList<String> codes = new ArrayList<>();
            for (int i = 0; i < getRecordCount(); i++)
            {
                productsFile.seek(i * RECORD_SIZE);
                codes.add(IOStringUtils.readFixedString(
                    productsFile, CODE_SIZE));
            }
            return codes;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }

    //*********************************************************
    // Public methods for reading products
    //*********************************************************

    public ArrayList<Product> getProducts()
    {
        ArrayList<Product> products = new ArrayList<>();
        try
        {
            for (int i = 0; i < productCodes.size(); i++)
            {
                // if record has been marked for deletion,
                // don't add to products array list
                if (!productCodes.get(i).equals(DELETION_CODE))
                {
                    Product product = this.getRecord(i);
                    products.add(product);
                }
            }
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
        return products;
    }

    public Product getProduct(String productCode)
    {
        try
        {
            int recordNumber = this.getRecordNumber(productCode);
            Product product = this.getRecord(recordNumber);
            return product;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return null;
        }
    }

    //*************************************************
    //* Private methods for writing products
    //*************************************************

    private boolean writeProduct(Product product, int recordNumber)
    {
        try
        {
            productsFile.seek(recordNumber * RECORD_SIZE);
            IOStringUtils.writeFixedString(
                productsFile, CODE_SIZE, product.getCode());
            IOStringUtils.writeFixedString(
                productsFile, DESCRIPTION_SIZE, product.getDescription());
            productsFile.writeDouble(product.getPrice());
            return true;
        }
        catch(IOException e)
        {
            System.out.println(e);
            return false;
        }
    }

    //*************************************************
    //* Public methods for writing products
    //*************************************************

    public boolean addProduct(Product product)
    {
        productCodes.add(product.getCode());
        int recordNumber = getRecordNumber(product.getCode());
        return writeProduct(product, recordNumber);
    }

    public boolean updateProduct(Product product)
    {
        int recordNumber = getRecordNumber(product.getCode());
        if (recordNumber != -1)
            return writeProduct(product, recordNumber);
        else
            return false;
    }

    public boolean deleteProduct(Product product)
    {
        int recordNumber = getRecordNumber(product.getCode());
        if (recordNumber != -1)
        {
            productCodes.set(recordNumber, DELETION_CODE);
            product.setCode(DELETION_CODE);  // mark record for deletion
            return writeProduct(product, recordNumber);
        }
        else
        {
            return false;
        }
    }
}
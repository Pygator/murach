package murach.db;

import java.util.ArrayList;
import murach.business.*;

public interface ProductReader
{
    Product getProduct(String code);
    ArrayList<Product> getProducts();
}
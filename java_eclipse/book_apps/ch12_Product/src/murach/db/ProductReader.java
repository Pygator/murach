package murach.db;

import murach.business.Product;

public interface ProductReader {
    Product getProduct(String code);
    String getProducts();
}
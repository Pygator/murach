package murach.business;

import java.text.NumberFormat;

/**********************************************************************
 * The <code>Product</code> class defines a product and is used
 * by the <code>LineItem</code> and <code>ProductDB</code> classes.
 * @author Joel Murach
 * @version 8.0
 **********************************************************************/
public class Product  {

    private String code;
    private String description;
    private double price;

    /**************************************************************
     * Creates a <code>Product</code> with default values.
     **************************************************************/
    public Product() {
        code = "";
        description = "";
        price = 0;
    }

    /**************************************************************
     * Sets the product code.
     * @param code A <code>String</code> for the product code.
     *************************************************************/
    public void setCode(String code) {
        this.code = code;
    }

    /**************************************************************
     * Gets the product code.
     * @return A <code>String</code> for the product code.
     *************************************************************/
    public String getCode() {
        return code;
    }

    /**************************************************************
     * Sets the product description.
     * @param description A <code>String</code> for the product description.
     *************************************************************/
    public void setDescription(String description) {
        this.description = description;
    }

    /***********************************************************
     * Gets the product description.
     * @return A <code>String</code> for the product description.
     ***********************************************************/
    public String getDescription() {
        return description;
    }

    /**************************************************************
     * Sets the product price.
     * @param price A <code>double</code> for the product price.
     *************************************************************/
    public void setPrice(double price) {
        this.price = price;
    }

    /***********************************************************
     * Gets the product price.
     * @return A <code>double</code> for the product price.
     ***********************************************************/
    public double getPrice() {
        return price;
    }

    /***********************************************************
     * Gets the product price with currency formatting.
     * @return A <code>String</code> for the product price 
     * with currency formatting
     ***********************************************************/
    public String getPriceFormatted() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

    /***********************************************************
     * Gets the default string for the product, which is the 
     * description for the product
     * @return The default string for the product
     ***********************************************************/
    @Override
    public String toString() {
        return description;
    }
}
package murach.business;

import java.text.NumberFormat;

/**********************************************************
 * The <code>Product</code> class represents a product and is used
 * by the <code>LineItem</code> class.
 **********************************************************/
public class Product
{
    private String code;
    private String description;
    private double price;

    /***********************************************************
     * Initializes a <code>Product</code> and sets all instance
     * variables to empty strings or zero values.
     ***********************************************************/
    public Product()
    {
        code = "";
        description = "";
        price = 0;
    }

    /***********************************************************
     * Sets the product's code to the specified <code>String</code>.
     ***********************************************************/
    public void setCode(String code)
    {
        this.code = code;
    }

    /***********************************************************
     * Returns a <code>String</code> that represents the product's
     * code.
     ***********************************************************/
    public String getCode(){
        return code;
    }

    /***********************************************************
     * Sets the product's description to the specified
     * <code>String</code>.
     ***********************************************************/
    public void setDescription(String description)
    {
        this.description = description;
    }

    /***********************************************************
     * Returns a <code>String</code> that represents the product's
     * description.
     ***********************************************************/
    public String getDescription()
    {
        return description;
    }

    /***********************************************************
     * Sets the product's price to the specified
     * <code>double</code> value.
     ***********************************************************/
    public void setPrice(double price)
    {
        this.price = price;
    }

    /***********************************************************
     * Returns a <code>double</code> value that represents the
     * product's price.
     ***********************************************************/
    public double getPrice()
    {
        return price;
    }

    /***********************************************************
     * Returns a <code>String</code> that represents the product's
     * price with standard currency formatting applied ($0.00).
     ***********************************************************/
    public String getFormattedPrice()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(price);
    }

}
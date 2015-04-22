package murach.business;

import java.text.NumberFormat;
import java.text.ParseException;

public class Product
{
    private String code;
    private String description;
    private double price;

    public Product()
    {
        this("", "", 0);
    }

    public Product(String code, String description, double price)
    {
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getCode(){
        return code;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public double getPrice()
    {
        return price;
    }

    public String getFormattedPrice()
    {
        NumberFormat number = NumberFormat.getNumberInstance();
        number.setMinimumFractionDigits(2);
        number.setMaximumFractionDigits(2);
        return number.format(price);
    }

    public void setFormattedPrice(String formattedPrice)
    {
        NumberFormat number = NumberFormat.getNumberInstance();
        Number n;
        try
        {
            n = number.parse(formattedPrice);
        }
        catch (ParseException e)
        {
            n = 0;
        }
        this.price = n.doubleValue();
    }

    public boolean equals(Object object)
    {
        if (object instanceof Product)
        {
            Product product2 = (Product) object;
            if
            (
                code.equals(product2.getCode()) &&
                description.equals(product2.getDescription()) &&
                price == product2.getPrice()
            )
                return true;
        }
        return false;
    }

    public String toString()
    {
        return description;
    }
}
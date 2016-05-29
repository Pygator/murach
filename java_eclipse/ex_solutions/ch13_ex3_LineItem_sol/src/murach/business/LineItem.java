package murach.business;

import java.text.NumberFormat;

/**
 * The LineItem class defines a line item. This class uses the Product class.
 */
public class LineItem {

    private Product product;
    private int quantity;

    /**
     * Creates a LineItem with default values.
     */
    public LineItem() {
        this.product = null;
        this.quantity = 0;
    }

    /**
     * Creates a LineItem with specified values.
     * @param product A Product object for the product.
     * @param quantity An int value for the quantity.
     */
    public LineItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * Sets the product.
     * @param product The Product object for the product.
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    /**
     * Gets the product.
     * @return The Product object for the product.
     */
    public Product getProduct() {
        return product;
    }

    /**
     * Sets the quantity.
     * @param quantity The int value for the quantity.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Gets the quantity.
     * @return The int value for the quantity.
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Gets the total for the line item.
     * @return The double value for the line item total.
     */
    public double getTotal() {
        double total = quantity * product.getPrice();
        return total;
    }

    /**
     * Gets the total for the line item with currency formatting.
     * @return A String object for the line item total with currency formatting.
     */
    public String getTotalFormatted() {
        double total = this.getTotal();
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        String totalFormatted = currency.format(total);
        return totalFormatted;
    }
}

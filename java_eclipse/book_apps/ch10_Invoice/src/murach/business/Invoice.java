package murach.business;

import java.text.NumberFormat;

public class Invoice {

    // the instance variable
    private LineItem[] lineItems;
    private int index;

    // the constructor
    public Invoice() {
        lineItems = new LineItem[100];
        index = 0;
    }

    // a method that adds a line item
    public void addItem(LineItem lineItem) {
        lineItems[index] = lineItem;
        index++;
    }

    // the get accessor for the line item collection
    public LineItem[] getLineItems() {
        return lineItems;
    }

    // a method that gets the invoice total
    public double getTotal() {
        double invoiceTotal = 0;
        for (LineItem lineItem : lineItems) {
            if (lineItem == null) {
                break;
            }
            invoiceTotal += lineItem.getTotal();
        }
        return invoiceTotal;
    }

    // a method that returns the invoice total in currency format
    public String getTotalFormatted() {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(getTotal());
    }
}
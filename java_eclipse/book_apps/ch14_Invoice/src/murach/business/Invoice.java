package murach.business;

import java.text.NumberFormat;
import java.util.ArrayList;

public class Invoice {

    // the instance variable
    private ArrayList<LineItem> lineItems;

    // the constructor
    public Invoice() {
        lineItems = new ArrayList<>();
    }

    // a method that adds a line item
    public void addItem(LineItem lineItem) {
        lineItems.add(lineItem);
    }

    // the get accessor for the line item collection
    public ArrayList<LineItem> getLineItems() {
        return lineItems;
    }

    // a method that gets the invoice total
    public double getTotal() {
        double invoiceTotal = 0;
        for (LineItem lineItem : lineItems) {
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
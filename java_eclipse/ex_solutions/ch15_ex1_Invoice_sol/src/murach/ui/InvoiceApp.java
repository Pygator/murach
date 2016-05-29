package murach.ui;

import murach.db.ProductDB;
import murach.business.Invoice;
import murach.business.LineItem;
import murach.business.Product;

public class InvoiceApp {

    public static Invoice invoice = new Invoice();

    public static void main(String args[]) {
        System.out.println("Welcome to the Invoice application\n");
        getLineItems();
        displayInvoice();
    }

    public static void getLineItems() {
        String choice = "y";
        while (choice.equalsIgnoreCase("y")) {
            String productCode = Console.getString("Enter product code: ");
            int quantity = Console.getInt("Enter quantity:     ");

            Product product = ProductDB.getProduct(productCode);
            invoice.addItem(new LineItem(product, quantity));

            choice = Console.getString("Another line item? (y/n): ");
            System.out.println();
        }
    }

    public static void displayInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append("Invoice date: ");
        sb.append(invoice.getInvoiceDateFormatted());        
        sb.append("\n");
        sb.append("Due date:     ");
        sb.append(invoice.getDueDateFormatted());        
        sb.append("\n\n");
        
        sb.append(StringUtil.pad("Description", 34));
        sb.append(StringUtil.pad("Price", 10));        
        sb.append(StringUtil.pad("Qty", 5));        
        sb.append(StringUtil.pad("Total", 10));
        sb.append("\n");

        for (LineItem lineItem : invoice.getLineItems()) {
            Product product = lineItem.getProduct();
            sb.append(StringUtil.pad(product.getDescription(), 34));
            sb.append(StringUtil.pad(product.getPriceFormatted(), 10));
            sb.append(StringUtil.pad(lineItem.getQuantityFormatted(), 5));
            sb.append(StringUtil.pad(lineItem.getTotalFormatted(), 10));
            sb.append("\n");
        }
        sb.append("\nInvoice total: ");
        sb.append(invoice.getTotalFormatted());
        sb.append("\n");
        System.out.println(sb);
    }
}
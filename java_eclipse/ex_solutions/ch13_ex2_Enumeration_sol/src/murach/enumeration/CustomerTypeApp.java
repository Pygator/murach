package murach.enumeration;

public class CustomerTypeApp {

    public static void main(String[] args) {
        // display a welcome message
        System.out.println("Welcome to the Customer Type Test application\n");

        // get and display the discount percent for a customer type
        CustomerType trade = CustomerType.TRADE;
        double discountPercent = getDiscountPercent(trade);
        System.out.println("discountPercent: " + discountPercent + "\n");

        // display the value of the toString method of a customer type
        System.out.println("toString: " + trade.toString() + "\n");
    }

    // a method that accepts a CustomerType enumeration
    public static double getDiscountPercent(CustomerType ct) {
        double discountPercent = 0;
        if (ct == CustomerType.RETAIL) {
            discountPercent = 0.10;
        } else if (ct == CustomerType.TRADE) {
            discountPercent = 0.30;
        } else if (ct == CustomerType.COLLEGE) {
            discountPercent = 0.20;
        }
        return discountPercent;
    }
}

package murach.tags;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.IOException;
import java.util.ArrayList;
import java.text.NumberFormat;

import murach.business.Product;

public class ProductsTag extends BodyTagSupport {

    private ArrayList<Product> products;
    private int count;
    private Product product;

    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();

    // Get vector and skip the body if the vector is empty.
    @Override
    public int doStartTag() {
        products = (ArrayList<Product>) pageContext.findAttribute("products");
        if (products.size() <= 0) {
            return SKIP_BODY;
        } else {
            return EVAL_BODY_BUFFERED;
        }
    }

    // Evaluate the body and add the data for the first vector element
    // to the bodyContent object.
    @Override
    public void doInitBody() {
        count = 0;
        product = (Product) products.get(count);
        pageContext.setAttribute("code", product.getCode());
        pageContext.setAttribute("description", product.getDescription());
        double price = product.getPrice();
        String priceAsString = currency.format(price);
        pageContext.setAttribute("price", priceAsString);
        count++;
    }
    // Evaluate the body again and add the data
    // for the other vector elements to the bodyContent object.
    // Then, write the data of the bodyContent object to the JSP.

    @Override
    public int doAfterBody() throws JspException {
        try {
            if (count < products.size()) {
                product = (Product) products.get(count);
                pageContext.setAttribute("code", product.getCode());
                pageContext.setAttribute("description", product.getDescription());
                pageContext.setAttribute("price", currency.format(product.getPrice()));
                count++;
                return EVAL_BODY_AGAIN;
            } else {
                JspWriter out = bodyContent.getEnclosingWriter();
                bodyContent.writeOut(out);
                return SKIP_BODY;
            }
        } catch (IOException ioe) {
            System.err.println("IOException doAfterBody: " + ioe);
            return SKIP_BODY;
        }
    }
}
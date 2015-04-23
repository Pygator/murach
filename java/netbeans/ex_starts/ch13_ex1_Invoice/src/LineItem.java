import java.text.NumberFormat;

public class LineItem
{
	private Product product;
	private int quantity;
	private double total;

	public LineItem(Product product, int quantity)
	{
		this.product = product;
		this.quantity = quantity;
		this.total = getTotal();
	}

	public Product getProduct()
	{
		return product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public double getTotal()
	{
		total = quantity * product.getPrice();
		return total;
	}

	public String getFormattedTotal()
	{
		double total = this.getTotal();
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		String formattedTotal = currency.format(total);
		return currency.format(total);
	}
}
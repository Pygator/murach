public class Address
{
	private String streetAddress1;
	private String streetAddress2;
	private String city;
	private String state;
	private String postalCode;

	public Address()
	{
		streetAddress1 = "";
		streetAddress2 = "";
		city = "";
		state = "";
		postalCode = "";
	}

	public void setStreetAddress1(String streetAddress1)
	{
		this.streetAddress1 = streetAddress1;
	}

	public String getStreetAddress1()
	{
		return streetAddress1;
	}

	public void setStreetAddress2(String streetAddress2)
	{
		this.streetAddress2 = streetAddress2;
	}

	public String getStreetAddress2()
	{
		return streetAddress2;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getCity()
	{
		return city;
	}

	// and so on

}
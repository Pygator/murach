package music.business;

import java.io.Serializable;

public class User implements Serializable {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String companyName;
    private String address1;
    private String address2;
    private String city;
    private String st;
    private String zip;
    private String country;
    private String creditCardType;
    private String creditCardNumber;
    private String creditCardExpirationDate;

    public User() {
        firstName = "";
        lastName = "";
        email = "";
        companyName = "";
        address1 = "";
        address2 = "";
        city = "";
        st = "";
        zip = "";
        country = "";
        creditCardType = "";
        creditCardNumber = "";
        creditCardExpirationDate = "";
    }
    
    public Long getId() {
        return userId;
    }

    public void setId(Long userId) {
        this.userId = userId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress2() {
        return address2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    // State is a reserved SQL word, so the field is called "st" instead.
    public void setState(String state) {
        st = state;
    }

    public String getState() {
        return st;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getZip() {
        return zip;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    // this works, but it mixes the Model and the View
    public String getAddressHTMLFormat() {
        String address = firstName + " " + lastName + "<br>";

        if (companyName == null || companyName.equals("") || companyName.equals(" ")) {
            address += "";
        } else {
            address += companyName + "<br>";
        }

        address += address1 + "<br>";

        if (address2 == null || address2.equals("") || address2.equals(" ")) {
            address += "";
        } else {
            address += address2 + "<br>";
        }

        address += city + ", " + st + " " + zip + "<br>"
                + country;

        return address;
    }

    public void setCreditCardType(String creditCartType) {
        this.creditCardType = creditCartType;
    }

    public String getCreditCardType() {
        return creditCardType;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }
}
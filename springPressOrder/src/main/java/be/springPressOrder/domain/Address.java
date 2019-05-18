package be.springPressOrder.domain;

public class Address {
    private String street;
    private String number;
    private String postalCode;
    private String town;
    private String country;

    public Address(String street, String number, String postalCode, String town, String country) {
        this.street = street;
        this.number = number;
        postalCode = postalCode;
        town = town;
        country = country;
    }

    public String getStreet() {
        return street;
    }

    public String getNumber() {
        return number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getTown() {
        return town;
    }

    public String getCountry() {
        return country;
    }
}

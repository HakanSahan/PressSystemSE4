package be.springPressOrder.domain;

public abstract class Person {
    private int id;
    private String name;
    private String firstname;
    private String phone;
    private String email;
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Person(int id, String name, String firstname, String phone, String email) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
    }

}

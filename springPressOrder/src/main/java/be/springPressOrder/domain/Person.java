package be.springPressOrder.domain;


import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int id;

    @Column
    private String name;

    @Column
    private String firstname;

    @Column
    private String phone;

    @Column
    private String email;

    @ManyToOne
    @JoinColumn(name = "address_id")
    private Address address;

    Person(int id, String name, String firstname, String phone, String email) {
        this.id = id;
        this.name = name;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
    }

    Person(String name, String firstname, String phone, String email) {
        this.name = name;
        this.firstname = firstname;
        this.phone = phone;
        this.email = email;
    }

    Person(){}

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

}

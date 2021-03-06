package be.springPressOrder.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.*;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column
    @Digits(integer=3, fraction=0, message = "Please select an amount less than thousand ")
    private int amount;

    public enum Status {NotPlanned, Planned, Executing, Executed, Canceled}

    @Column
    private Status status;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date orderDate;

    // Moet set zijn anders :  Illegal attempt to map a non collection as a @OneToMany, @ManyToMany or @CollectionOfElements: be.springPressOrder.domain.Order.juices
    @OneToMany(mappedBy = "order")
    private Set<Juice> juices;

    @ManyToOne
    @JoinColumn(name = "fruid_id")
    private Fruit fruit;

    private int idClient;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pressOrder_id", referencedColumnName = "id")
    private PressOrder pressOrder;

    public Order(int amount, Juice juice, int idClient){
        this.amount = amount;
        this.juices = new HashSet<>();
        this.juices.add(juice);
        this.idClient = idClient;
        orderDate = new Date();
        status = Status.Canceled;
    }

    public Order(int amount, Fruit fruit, int idClient){
        this.amount = amount;
        this.fruit = fruit;
        this.idClient = idClient;
        orderDate = new Date();
        status = Status.NotPlanned;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<Juice> getJuices() {
        return juices;
    }

    public int getIdClient() {
        return idClient;
    }

    public PressOrder getPressOrders() {
        return pressOrder;
    }

    public int getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void addJuice(Juice juice){juices.add(juice);}

    public void setJuices(Set<Juice> juices){this.juices = juices;}
}

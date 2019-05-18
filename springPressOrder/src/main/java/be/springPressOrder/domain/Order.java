package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Digits(integer=3, fraction=0, message = "Please select an amount less than thousand ")
    private int amount;
    public enum OrderStatus {Canceled}
    private OrderStatus status;

    @ManyToOne
    @JoinColumn(name = "fruid_id")
    private Fruit fruit;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date orderDate;
    private int idClient;

    @OneToMany(mappedBy = "order")
    private List<Juice> juices;


    public int getIdClient() {
        return idClient;
    }

    public Order(){

    }

    public Order(int amount, Juice juice, int idClient){
        this.amount = amount;
        this.juices = new ArrayList<Juice>();
        this.juices.add(juice);
        this.idClient = idClient;
        orderDate = new Date();
        status = OrderStatus.Canceled;
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

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public List<Juice> getJuices() {
        return juices;
    }

    public void setJuice(List<Juice> juices) {
        this.juices = juices;
    }
}

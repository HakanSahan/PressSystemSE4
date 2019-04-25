package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    public enum Status {NotPlanned, Planned, Executing, Executed, Canceled}
    private Status status;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date orderDate;
    private String juice;
    private int idClient;

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getJuice() {
        return juice;
    }

    public void setJuice(String juice) {
        this.juice = juice;
    }




    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PressOrder> pressOrders;

    public int getIdClient() {
        return idClient;
    }

    public Order(){
        orderDate = new Date();
        status = Status.NotPlanned;
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

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Order(int amount, String juice, int idClient){
        this.amount = amount;
        this.juice = juice;
        this.idClient = idClient;
        orderDate = new Date();
        status = Status.NotPlanned;
    }



}

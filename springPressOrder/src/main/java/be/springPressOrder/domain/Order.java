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

    @Digits(integer=3, fraction=0, message = "No more 3 digits")
    private int amount;
    public enum OrderStatus {Canceled};
    private OrderStatus status;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date orderDate;
    //private Juice juice;
    private int idClient;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PressOrder> pressOrders;

    public int getIdClient() {
        return idClient;
    }

    public Order(){
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

    public Order(int amount, /*Juice juice,*/ int idClient){
        this.amount = amount;
        //this.juice = juice;
        this.idClient = idClient;
        orderDate = new Date();
        status = OrderStatus.Canceled;
    }

    /*public Juice getJuice() {
        return juice;
    }

    public void setJuice(Juice juice) {
        this.juice = juice;
    }*/



}

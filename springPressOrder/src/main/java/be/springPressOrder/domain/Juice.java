package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Juices")
public class Juice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   @OneToOne
    private Fruit fruit;

    private int avAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date pressDate;
    private int fromClient;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    public Juice(Fruit fruit, int avAmount, Date presdate, int fromClient) {
        this.fruit = fruit;
        this.avAmount = avAmount;
        this.pressDate = presdate;
        this.fromClient = fromClient;
    }

    public Juice(){

    }

    public int getAvAmount() {
        return avAmount;
    }

    public Date getPressdate() {
        return pressDate;
    }

    public int getFromClient() {
        return fromClient;
    }

    public void setAvAmount(int avAmount) {
        this.avAmount = avAmount;
    }

    public void setPresdate(Date presdate) {
        this.pressDate = presdate;
    }

    public void setFromClient(int fromClient) {
        this.fromClient = fromClient;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}

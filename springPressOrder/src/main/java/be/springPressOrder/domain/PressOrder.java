package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PressOrders")
public class PressOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private int fruitAmount;
    private int maxJuiceAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date startHour;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date endHour;
    public enum Status {NotPlanned, Planned, Executing, Executed, Canceled} ;
    private Status status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PressOrder(){
        this.order = new Order();
    }

    public PressOrder(int fruitAmount, int maxJuiceAmount, Order order){
        this.fruitAmount = fruitAmount;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = Status.NotPlanned;
        this.order = order;
    }

    /*
    public PressOrder(int hoeveelheidFruit, Order bestelling) {
        this.fruitAmount = hoeveelheidFruit;
        this.order = bestelling;
        status = Status.NotPlannend;
    }*/

    public int getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public int getMaxJuiceAmount() {
        return maxJuiceAmount;
    }

    public void setMaxJuiceAmount(int maxJuiceAmount) {
        this.maxJuiceAmount = maxJuiceAmount;
    }

    public Date getStartHour() {
        return startHour;
    }

    public void setStartHour(Date startHour) {
        this.startHour = startHour;
    }

    public Date getEndHour() {
        return endHour;
    }

    public void setEndHour(Date endHour) {
        this.endHour = endHour;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }


    public Order getOrder() {
        return order;
    }

    public Integer getOrderId()
    {
        return order.getId();
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}

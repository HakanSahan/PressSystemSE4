package be.springPressOrder.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Pressorders")
public class PressOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int fruitAmount;
    private int juice;
    private int maxJuiceAmount;
    private Date startHour;
    private Date endHour;
    public enum Status {NotPlannend, Plannend, Executing, Executed, Canceled} ;
    private Status status;
    @OneToOne
    private Order order;
    private int idClient;

    //private Machine machine;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClientId(int idClient) {
        this.idClient = idClient;
    }

    public int getFruitAmount() {
        return fruitAmount;
    }

    public void setFruitAmount(int fruitAmount) {
        this.fruitAmount = fruitAmount;
    }

    public int getJuice() {
        return juice;
    }

    public void setJuice(int juice) {
        this.juice = juice;
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

    public void setOrder(Order order) {
        this.order = order;
    }

    /*public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }*/

    public PressOrder(int hoeveelheidFruit, Order bestelling) {
        this.fruitAmount = hoeveelheidFruit;
        this.order = bestelling;
        status = Status.NotPlannend;
    }

    public PressOrder() {
        status = Status.NotPlannend;
    }
}

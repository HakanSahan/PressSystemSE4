package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Entity
@Table(name = "Juices")
@XmlRootElement(name="juice")
public class Juice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   @OneToOne
    private Fruit fruit;

    private int avAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date presdate;
    private int fromClient;


    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    public Juice(Fruit fruit, int avAmount, Date presdate, int fromClient) {
        this.fruit = fruit;
        this.avAmount = avAmount;
        this.presdate = presdate;
        this.fromClient = fromClient;
    }

    public Juice(){

    }

    @XmlElement(name="Soort")
    public Fruit getSort() {
        return fruit;
    }

    @XmlElement(name="AvAmount")
    public int getAvAmount() {
        return avAmount;
    }

    @XmlElement(name="Presdate")
    public Date getPresdate() {
        return presdate;
    }

    @XmlElement(name="Klant")
    public int getFromClient() {
        return fromClient;
    }

    public void setAmount(int amount) {
        this.amount = amount;
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

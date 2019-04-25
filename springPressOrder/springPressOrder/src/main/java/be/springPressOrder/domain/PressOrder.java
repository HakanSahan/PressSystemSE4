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
    private int juice;
    private int maxJuiceAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date startHour;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date endHour;
    public enum Status {NotPlanned, Planned, Executing, Executed, Canceled} ;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    //private Order order;
    // private Machine machine;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PressOrder(){

    }

    public PressOrder(int fruitAmount, int juice, int maxJuiceAmount, Status st){
        this.fruitAmount = fruitAmount;
        this.juice = juice;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = st;
        order = null;
    }

    public PressOrder(int fruitAmount, int juice, int maxJuiceAmount, Status st, Order order){
        this.fruitAmount = fruitAmount;
        this.juice = juice;
        this.maxJuiceAmount = maxJuiceAmount;
        this.status = st;
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

    public Integer getOrderId()
    {
        return order.getId();
    }
    public void setOrder(Order order) {
        this.order = order;
    }
/*
    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }*/


 /*   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Version
    private Integer version;

    private String productId;
    private String description;
    private String imageUrl;
    private BigDecimal price;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    */
}

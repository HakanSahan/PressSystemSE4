package be.springPressOrder.domain;

import java.util.Date;

public class Juice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private Fruit fruit;

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    @ManyToOne
    @JoinColumn(name = "storage_id")
    private Storage storage;

    private int amount;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date pressDate;
    private int fromClient;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setFruit(Fruit fruit) {
        this.fruit = fruit;
    }

    public Date getPressDate() {
        return pressDate;
    }

    public void setPressDate(Date pressDate) {
        this.pressDate = pressDate;
    }

    public Order getOrder() {
        return order;
    }

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = true)
    private Order order;

    public Juice(Fruit fruit, int amount, Date presdate, int fromClient) {
        this.fruit = fruit;
        this.amount = amount;
        this.pressDate = presdate;
        this.fromClient = fromClient;
    }

    public Juice(){

    }
    public Fruit getSort() {
        return sort;
    }

    public int getAmount() {
        return amount;
    }

    public Date getPressdate() {
        return pressDate;
    }

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

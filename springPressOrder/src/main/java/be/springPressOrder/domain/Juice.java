package be.springPressOrder.domain;

import java.util.Date;

public class Juice {
    private Fruit sort;
    private int avAmount;
    private Date pressDate;
    private int fromClient;

    public Juice(Fruit sort, int avAmount, Date pressDate, int fromClient) {
        this.sort = sort;
        this.avAmount = avAmount;
        this.pressDate = pressDate;
        this.fromClient = fromClient;
    }

    public Juice(){

    }
    public Fruit getSort() {
        return sort;
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
}

package be.springPressOrder.domain;

import java.util.ArrayList;

public class Storage {
    private be.springPressOrder.domain.Sort sortOfFruit;
    private ArrayList<Juice> juices;
    private int total;

    public be.springPressOrder.domain.Sort getSortOfFruit() {
        return sortOfFruit;
    }

    public ArrayList<Juice> getJuices() {
        return juices;
    }

    public int getTotal() {
        return total;
    }

    public void AddJuice(Juice juice){
        juices.add(juice);
        total += juice.getAvAmount();
    }

    public void RemoveJuice(int amount){
        total -= amount;
    }

    public Storage(Sort sortOfFruit) {
        this.sortOfFruit = sortOfFruit;
        this.juices = new ArrayList<>();
        this.total = 0;
    }
}

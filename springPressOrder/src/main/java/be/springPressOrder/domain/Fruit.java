package be.springPressOrder.domain;

import javax.persistence.*;

@Entity
@Table(name = "Fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fruitname; //TODO ???
    private Double avgJuiceAmount;
    private int beginmonth;
    private int endmonth;

    @OneToOne(cascade=CascadeType.ALL)
    private Sort sort;

    public String getFruitname() {
        return fruitname;
    }

    public Double getavgJuiceAmount() {
        return avgJuiceAmount;
    }

    public void setavgJuiceAmount(Double avgJuiceAmount) {
        this.avgJuiceAmount = avgJuiceAmount;
    }

    public int getBeginmonth() {
        return beginmonth;
    }

    public void setBeginmonth(int beginmonth) {
        this.beginmonth = beginmonth;
    }

    public int getendmonth() {
        return endmonth;
    }

    public void setendmonth(int endmonth) {
        this.endmonth = endmonth;
    }

    public Fruit(String fruitname, Double avgJuiceAmount, int beginmonth, int endmonth) {
        this.fruitname = fruitname;
        this.avgJuiceAmount = avgJuiceAmount;
        this.beginmonth = beginmonth;
        this.endmonth = endmonth;
    }
}

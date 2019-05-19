package be.springPressOrder.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Storage")
public class Storage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Fruit cannot be null")
    @OneToOne(mappedBy = "storage")
    private Fruit fruit;

    @OneToMany(mappedBy = "storage")
    private Set<Juice> juices;

    private int total;

    public Storage(Fruit fruit, Set<Juice> juices, int total) {
        this.fruit = fruit;
        this.juices = juices;
        this.total = total;
    }

    public Storage(Fruit fruit){
        this.fruit = fruit;
        this.juices = new HashSet<>();
    }

    public Storage(){

    }

    public int getId() {
        return id;
    }

    public Fruit getFruit() { return fruit; }

    public Set<Juice> getJuices() {
        return juices;
    }

    public int getTotal() {
        return total;
    }

    public void addJuice(Juice juice){
        juices.add(juice);
        total += juice.getAmount();
    }

    public void removeJuice(Juice juice){
        if(juices.contains(juice)) {
            juices.remove(juices);
            total -= juice.getAmount();
        }
    }
}

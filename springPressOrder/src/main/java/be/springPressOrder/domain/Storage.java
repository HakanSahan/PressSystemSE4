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

    @NotNull(message = "Name of storage cannot be null")
    private String name;

    @OneToMany(mappedBy = "storage")
    private Set<Juice> juices;

    private int total;

    public Storage(String name, Set<Juice> juices, int total) {
        this.name = name;
        this.juices = juices;
        this.total = total;
    }

    public Storage(String name){
        this.name = name;
        this.juices = new HashSet<>();
    }

    public Storage(){

    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Juice> getJuices() {
        return juices;
    }

    public int getTotal() {
        return total;
    }

    public void AddJuice(Juice juice){
        juices.add(juice);
        total += juice.getAmount();
    }

    public void RemoveJuice(Juice juice){
        if(juices.contains(juice)) {
            juices.remove(juices);
            total -= juice.getAmount();
        }
    }
}

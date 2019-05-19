package be.springPressOrder.domain;



import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Fruits")
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull(message = "Fruit name cannot be null")
    private String fruitname;

    @OneToMany(mappedBy = "fruit")
    private Set<Order> orderSet;

    @OneToMany
    private Set<Juice> juices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storage_id", referencedColumnName = "id")
    private Storage storage;

    @OneToOne
    @JoinColumn(name = "fruitData_id",referencedColumnName = "id")
    private FruitData fruitData;

    public Fruit(String fruitname) {
        this.fruitname = fruitname;
        orderSet = new HashSet<>();
        juices = new HashSet<>();
    }

    public Fruit(){}

    public String getFruitname() {
        return fruitname;
    }

    public int getId(){return  id;}
}

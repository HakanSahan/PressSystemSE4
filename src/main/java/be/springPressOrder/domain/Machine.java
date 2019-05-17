package be.springPressOrder.domain;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table (name= "Machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    public enum Status {Ok, NietOK};
    private Status status;
    private boolean isOccupied;
    private int maxCapacityPerHour;
    private ArrayList<Rapport> reportLists;


    public Machine(){

    }

    public Machine(Status status, boolean isOccupied, int maxCapacityPerHour) {
        this.status = status;
        this.isOccupied = isOccupied;
        this.maxCapacityPerHour = maxCapacityPerHour;
        this.reportLists = reportLists;
    }

    public Machine(int id, boolean isOccupied, int maxCapacityPerHour) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.maxCapacityPerHour = maxCapacityPerHour;
        //TODO Status ?
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public int maxCapacityPerHour() {
        return maxCapacityPerHour;
    }

    public void setMaxCapacityPerHour(int maxCapacityPerHour) {
        this.maxCapacityPerHour = maxCapacityPerHour;
    }
    // Methode apparatuur chack
}

package be.springPressOrder.domain;


import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Machines")
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public Integer getId(){
        return id;
    }

    public void setId(Integer id){this.id = id;}

    public enum Status {Ok,Not_OK}
    private Status status;
    private boolean isOccupied;
    private int maxCapacityPerHour;

    @OneToMany(mappedBy = "machine")
    private Set<Rapport> reportList;

    @OneToMany(mappedBy = "machine")
    private Set<Schedule> schedules;

    public Machine(int id, boolean isOccupied, int maxCapacityPerHour) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.maxCapacityPerHour = maxCapacityPerHour;
        reportList = new HashSet<>();
        schedules = new HashSet<>();
        status = Status.Ok;
    }

    public Machine(){
        reportList = new HashSet<>();
        schedules = new HashSet<>();
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

    public Set<Rapport> getReportList() {
        return reportList;
    }

    public Rapport MachineCheck(){
        return new Rapport(this,Status.Ok, Status.Not_OK,"Something went wrong",new Date());
    }

    public Set<Schedule> getSchedules(){
        return schedules;
    }
}

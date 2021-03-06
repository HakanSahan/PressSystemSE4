package be.springPressOrder.domain;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Schedules")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @ManyToOne
    @JoinColumn(name = "pressOrder_id")
    private PressOrder pressOrder;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date startHour;
    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date endHour;

    public Schedule(){

    }

    public Schedule(Machine machine, PressOrder pressOrder, Date startHour, Date endHour) {
        this.machine = machine;
        this.pressOrder = pressOrder;
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Machine getMachine() {
        return machine;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public PressOrder getPressOrder() {
        return pressOrder;
    }

    public void setPressOrder(PressOrder pressOrder) {
        this.pressOrder = pressOrder;
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
}

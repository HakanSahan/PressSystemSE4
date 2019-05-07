package be.springPressOrder.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Rapports")
public class Rapport {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Machine.Status previousStatus;
    private Machine.Status newStatus;
    private String log;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

    @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm")
    private Date checkTime;

    Rapport(Machine machine, Machine.Status previousStatus, Machine.Status newStatus, String log, Date checkTime) {
        this.machine = machine;
        this.previousStatus = previousStatus;
        this.newStatus = newStatus;
        this.log = log;
        this.checkTime = checkTime;
    }

    public int getId() {
        return id;
    }

    public Machine.Status getPreviousStatus() {
        return previousStatus;
    }

    public void setPreviousStatus(Machine.Status previousStatus) {
        this.previousStatus = previousStatus;
    }

    public Machine.Status getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(Machine.Status newStatus) {
        this.newStatus = newStatus;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public Machine getMachine(){
        return machine;
    }
}

package be.springPressOrder.domain;

import java.util.Date;

public class Rapport {
    private int id;
    private Machine.Status previousStatus;
    private Machine.Status newStatus;
    private String log;
    private Date checkTime;

    public Rapport(int id, Machine.Status previousStatus, Machine.Status newStatus, String log, Date checkTime) {
        this.id = id;
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
}

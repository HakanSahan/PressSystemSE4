package be.springPressOrder.domain;

import java.util.ArrayList;
import java.util.Date;

public class Machine {
    private int id;
    public enum Status {Ok,Not_OK} ;
    private Status status;
    private boolean isOccupied;
    private int maxCapacityPerHour;
    private ArrayList<Rapport> reportList;

    public Machine(int id, boolean isOccupied, int maxCapacityPerHour) {
        this.id = id;
        this.isOccupied = isOccupied;
        this.maxCapacityPerHour = maxCapacityPerHour;
        reportList = new ArrayList<>();
        status = Status.Ok;
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

    public ArrayList<Rapport> getReportList() {
        return reportList;
    }

    public Rapport MachineCheck(){
        return new Rapport(Status.Ok,Status.Not_OK,"Something went wrong",new Date());
    }
}

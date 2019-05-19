package be.springPressOrder.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "technicians")
public class Technician extends Person{

    @Column
    private Boolean isAvaileble;

    @OneToMany(mappedBy = "technician")
    private List<RequestTechnician> requestTechnicians = new ArrayList<>();


    public Technician(int id, String name, String firstname, String phone, String email) {
        super(id, name, firstname, phone, email);
    }

    public Technician(String name, String firstname, String phone, String email) {
        super(name, firstname, phone, email);
    }

    public Technician(){}

    public Boolean getAvaileble() {
        return isAvaileble;
    }

    public void setAvaileble(Boolean availeble) {
        isAvaileble = availeble;
    }

    public List<RequestTechnician> getRequestTechnicians(){
        return requestTechnicians;
    }
}

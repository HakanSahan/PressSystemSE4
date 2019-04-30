package be.springPressOrder.domain;

public class Technician extends Person {
    private boolean isAvailable;
    public Technician(int id, String name, String firstname, String phone, String email) {
        super(id, name, firstname, phone, email);
    }
}

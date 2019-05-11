package be.springPressOrder.domain;

public class Technician extends Person {
    private boolean isAvailable;
    public Technician(String name, String firstname, String phone, String email, String username, String password) {
        super(name, firstname, phone, email,username,"technician",password);
    }

    public Technician(){
        super("technician");
    }
}

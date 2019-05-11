package be.springPressOrder.domain;

public class Client extends Person {
    public Client(String name, String firstname, String phone, String email, String username, String password) {
        super(name, firstname, phone, email,username,"client",password);
    }

    public Client(){
        super("client");
    }
}

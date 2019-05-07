package be.springPressOrder;

import org.springframework.security.crypto.bcrypt.BCrypt;

public class EncryptSomePasswords {

    public static String hash(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static void main(String[] args) {

        String[] passwords = {"1", "2", "3","4"};

        for (String pwd : passwords ) {
            System.out.printf("%s is {bcrypt}%s%n", pwd, hash(pwd));
        }
    }
}

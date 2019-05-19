package be.springPressOrder.services;

import be.springPressOrder.domain.User;

public interface UserService {
    User getUserByUsername(String username);

    User saveUser(User user);

    void deleteUser(String username);
}

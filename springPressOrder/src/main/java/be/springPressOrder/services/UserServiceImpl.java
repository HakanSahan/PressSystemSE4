package be.springPressOrder.services;

import be.springPressOrder.dao.UserRepository;
import be.springPressOrder.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getUserByUsername(String username) {
        return (User)userRepository.findOne(username);
    }

    @Override
    public User saveUser(User client) {
        return userRepository.save(client);
    }

    @Override
    public void deleteUser(String username) {
        userRepository.delete(username);
    }
}

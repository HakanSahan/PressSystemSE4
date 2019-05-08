package be.springPressOrder.dao;

import be.springPressOrder.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {

    public Order findById(int id);

    public Order findOrderByUser(User user);

    public List<Order> findAllByUser(User user);

    //void delete(Integer id);
}

package be.springPressOrder.dao;

import be.springPressOrder.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByIdClient(int idClient);

    public Order findById(int id);

    //public Order findOrderByUser(User user);

    //public List<Order> findAllByUserOrderByName(User user);

    //void delete(Integer id);
}

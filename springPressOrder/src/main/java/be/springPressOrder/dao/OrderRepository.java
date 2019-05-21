package be.springPressOrder.dao;

import be.springPressOrder.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByIdClient(int idClient);

    public Order findById(int id);

    //public Order findOrderByUser(User user);

    //public List<Order> findAllByUserOrderByName(User user);

    //void delete(Integer id);
}
package be.springPressOrder.dao;

import be.springPressOrder.domain.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findByIdClient(int idClient);

    public Order findById(int id);

    //public Order findOrderByUser(User user);

    //public List<Order> findAllByUserOrderByName(User user);

}

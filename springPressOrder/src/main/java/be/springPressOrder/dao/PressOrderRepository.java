package be.springPressOrder.dao;

import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import org.springframework.data.repository.CrudRepository;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {
    PressOrder findByOrder(Order order);
    Iterable<PressOrder> findAllByIdClient(int idClient);
}

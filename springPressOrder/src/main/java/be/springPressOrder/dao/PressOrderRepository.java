package be.springPressOrder.dao;

import be.springPressOrder.domain.PressOrder;
import org.springframework.data.repository.CrudRepository;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {

    public PressOrder findById(int id);
    ///public List<PressOrder > findAllByUserOrderByName(User user);

    void delete(Integer id);
    PressOrder findByOrder(Order order);
    Iterable<PressOrder> findAllByIdClient(int idClient);
}

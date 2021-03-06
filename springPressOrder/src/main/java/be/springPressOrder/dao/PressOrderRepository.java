package be.springPressOrder.dao;

import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.domain.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {

    public PressOrder findById(int id);
    ///public List<PressOrder > findAllByUserOrderByName(User user);

    void delete(Integer id);
}

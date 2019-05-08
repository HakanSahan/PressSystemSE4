package be.springPressOrder.dao;

import be.springPressOrder.domain.PressOrder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {

    public PressOrder findById(int id);
    public List<PressOrder > findAllByUser(User user);

    //void delete(Integer id);
}

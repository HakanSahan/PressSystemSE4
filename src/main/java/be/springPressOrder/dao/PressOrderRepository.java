package be.springPressOrder.dao;

import be.springPressOrder.domain.PressOrder;
import org.springframework.data.repository.CrudRepository;

public interface PressOrderRepository extends CrudRepository<PressOrder, Integer> {
}

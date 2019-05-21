package be.springPressOrder.dao;

import be.springPressOrder.domain.Machine;
import be.springPressOrder.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface MachineRepository extends CrudRepository<Machine, Integer> {

}

package be.springPressOrder.dao;

import be.springPressOrder.domain.PressOrder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PressOrderRepository extends JpaRepository<PressOrder, Integer> {

    public PressOrder findById(int id);
    ///public List<PressOrder > findAllByUserOrderByName(User user);

    void delete(Integer id);
}

package be.springPressOrder.dao;

import be.springPressOrder.domain.Schedule;
import org.springframework.data.repository.CrudRepository;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}

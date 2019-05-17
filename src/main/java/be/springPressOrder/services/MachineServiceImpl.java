package be.springPressOrder.services;

import be.springPressOrder.dao.MachineRepository;
import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.domain.Machine;
import be.springPressOrder.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MachineServiceImpl implements MachineService {

    private MachineRepository machineRepository;

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Iterable<Machine> listAllMachines() {
        return machineRepository.findAll();
    }


    @Override
    public Machine getMachineById(Integer id) {
        return machineRepository.findOne(id);
    }
 /*
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.delete(id);
    }
    */
}

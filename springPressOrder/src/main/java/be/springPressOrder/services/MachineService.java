package be.springPressOrder.services;

import be.springPressOrder.domain.Machine;

public interface MachineService {

    Iterable<Machine> listAllMachines();

    Machine getMachineById(Integer id);

 /*
    Order saveOrder(Order order);

    void deleteOrder(Integer id);
    */
}

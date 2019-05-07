package be.springPressOrder.services;

import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.dao.PressOrderRepository;
import be.springPressOrder.domain.PressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PressOrderServiceImpl implements PressOrderService {
    private PressOrderRepository pressOrderRepository;

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Override
    public Iterable<PressOrder> listAllPressOrders() {
        return pressOrderRepository.findAll();
    }

    @Override
    public Optional<PressOrder> getPressOrderById(Integer id) {
        return pressOrderRepository.findById(id);
    }

    @Override
    public PressOrder getPressOrderByOrder(Order order) {
        return pressOrderRepository.findByOrder(order);
    }

    @Override
    public Iterable<PressOrder> listPressOrderByOrder(Integer id) {
        ArrayList<PressOrder> result = new  ArrayList();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getId() == id)
                result.add(pressOrder);
        }
        return result;
    }

    @Override
    public PressOrder savePressOrder(PressOrder pressOrder) {
        return pressOrderRepository.save(pressOrder);
    }

    @Override
    public void deletePressOrder(Integer id) {
        pressOrderRepository.delete(id);
    }
}

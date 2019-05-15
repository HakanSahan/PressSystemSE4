package be.springPressOrder.services;

import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.dao.PressOrderRepository;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Slf4j
@Service
public class PressOrderServiceImpl implements PressOrderService {
    private PressOrderRepository pressOrderRepository;

    private OrderRepository orderRepository;

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Integer id) {
        return orderRepository.findById(id);
    }
    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        //orderRepository.delete(id);
    }
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
    public Iterable<PressOrder> listPressOrderByOrder(Integer id) {
        ArrayList<PressOrder> result = new  ArrayList();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getOrderId() == id)
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

        PressOrder pressOrder = pressOrderRepository.findById(id).get();
        pressOrderRepository.delete(pressOrder);
    }
}

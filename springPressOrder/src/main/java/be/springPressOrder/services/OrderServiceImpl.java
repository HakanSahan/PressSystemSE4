package be.springPressOrder.services;

import be.springPressOrder.domain.Order;
import be.springPressOrder.dao.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

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
    public Order getOrderById(Integer id) {
        return orderRepository.findOne(id);
    }

    //------------
    @Override
    public Order addOrder(Order order) {
        return null;
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.delete(id);
    }


    @Transactional(propagation= Propagation.REQUIRED,readOnly=false)
    public Order createOrder(Order order) {

        return orderRepository.save(order);
    }
}

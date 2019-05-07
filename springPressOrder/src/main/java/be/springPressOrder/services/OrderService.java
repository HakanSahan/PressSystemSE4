package be.springPressOrder.services;

import be.springPressOrder.domain.Order;

import java.util.Optional;

public interface OrderService {

    Iterable<Order> listAllOrders();

    Optional<Order> getOrderById(Integer id);

    Order saveOrder(Order order);

    void deleteOrder(Integer id);
}

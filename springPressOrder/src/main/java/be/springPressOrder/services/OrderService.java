package be.springPressOrder.services;

import be.springPressOrder.domain.Order;

public interface OrderService {

    Iterable<Order> listAllOrders();

    Order getOrderById(Integer id);

    Order saveOrder(Order order);

    void deleteOrder(Integer id);
}

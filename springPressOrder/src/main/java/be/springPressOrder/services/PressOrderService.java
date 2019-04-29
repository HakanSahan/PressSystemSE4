package be.springPressOrder.services;


import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;

public interface PressOrderService {
    Iterable<PressOrder> listAllPressOrders();

    PressOrder getPressOrderById(Integer id);

    PressOrder getPressOrderByOrder(Order order);

    Iterable<PressOrder> listPressOrderByOrder(Integer id);

    PressOrder savePressOrder(PressOrder pressOrder);

    void deletePressOrder(Integer id);
}

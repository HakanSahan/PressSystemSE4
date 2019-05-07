package be.springPressOrder.services;


import be.springPressOrder.domain.PressOrder;

import java.util.Optional;

public interface PressOrderService {
    Iterable<PressOrder> listAllPressOrders();

    Optional<PressOrder> getPressOrderById(Integer id);

    Iterable<PressOrder> listPressOrderByOrder(Integer id);

    PressOrder savePressOrder(PressOrder pressOrder);

    void deletePressOrder(Integer id);
}

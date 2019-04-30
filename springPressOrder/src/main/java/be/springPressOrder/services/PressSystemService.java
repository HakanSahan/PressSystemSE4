package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.domain.Fruit;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;

public interface PressSystemService {
    Iterable<PressOrder> listAllPressOrders();

    PressOrder getPressOrderById(Integer id);

    Iterable<Fruit>      listAllFruits();

    Iterable<PressOrder> listPressOrderByOrder(Integer id);

    Iterable<PressOrder> listPressOrderByFruit(String fruitName);

    PressOrder addPressOrder(int amountOfFruit,Fruit fruit, int maxJuiceAmount,int idClient);

    PressOrder savePressOrder(int id, int amountOfFruit, Fruit fruit, int maxJuiceAmount,int idClient);

    void deletePressOrder(Integer id);

    Iterable<Order> listAllOrders();

    Iterable<Order> listOrderByFruit(String fruitName);

    Order getOrderById(Integer id);

    Order addOrder(int amount, Fruit fruit, int idClient);

    Order saveOrder(int id, int amount, Fruit fruit, int idClient);

    void deleteOrder(Integer id);

    Order processOrder(OrderData orderData);

    public PressOrder processPressOrder(PressOrderData pressOrderData);
}

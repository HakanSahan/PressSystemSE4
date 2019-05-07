package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.domain.*;

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

    PressOrder processPressOrder(PressOrderData pressOrderData);

    Iterable<Schedule> listAllSchedules();

    Iterable<Machine> listAllMachines();

    Schedule processSchedule(ScheduleData scheduleData);

    Iterable<Technician> listAllTechnicians();

    Technician getTechnicianById(int id);

    Iterable<RequestTechnician> listAllRequestTechnicians();

    RequestTechnician getRequestTechnicianById(int id);

    RequestTechnician processRequestTechnician(RequestTechnicianData requestTechnicianData);
}

package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class PressSystemServiceImpl implements PressSystemService {
    private PressOrderRepository pressOrderRepository;
    private FruitRepository fruitRepository;
    private OrderRepository orderRepository;
    private ScheduleRepository scheduleRepository;
    private MachineRepository machineRepository;
    private TechnicianRepository technicianRepository;
    private RequestTechnicianRepository requestTechnicianRepository;

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository){this.scheduleRepository = scheduleRepository;}

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository){this.machineRepository = machineRepository;}

    @Autowired
    public void setTechnicianRepository(TechnicianRepository technicianRepository){this.technicianRepository = technicianRepository;}

    @Autowired
    public void setRequestTechnicianRepository (RequestTechnicianRepository requestTechnicianRepository){this.requestTechnicianRepository = requestTechnicianRepository;}

    @Override
    public Iterable<PressOrder> listAllPressOrders() {
        return pressOrderRepository.findAll();
    }

    @Override
    public PressOrder getPressOrderById(Integer id) {
        return pressOrderRepository.findOne(id);
    }

    @Override
    public Iterable<PressOrder> listPressOrderByOrder(Integer idOrder) {
        ArrayList<PressOrder> result = new  ArrayList<>();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getOrderId().equals(idOrder))
                result.add(pressOrder);
        }
        return result;
    }

    @Override
    public Iterable<Fruit> listAllFruits(){
        return fruitRepository.findAll();
    }

    @Override
    public Iterable<PressOrder> listPressOrderByFruit(String fruitName) {
        ArrayList<PressOrder> result = new  ArrayList<>();
        for (PressOrder pressOrder : pressOrderRepository.findAll())
        {
            if(pressOrder.getOrder().getFruit().getFruitname().equals(fruitName))
                result.add(pressOrder);
        }
        return result;
    }

    @Override
    public PressOrder addPressOrder(int amountOfFruit, Fruit fruit, int maxJuiceAmount, int idClient) {
       return pressOrderRepository.save(createPressOrder(amountOfFruit,fruit,maxJuiceAmount,idClient));
    }

    @Override
    public PressOrder savePressOrder(int id, int amountOfFruit, Fruit fruit, int maxJuiceAmount, int idClient) {
        return null;
    }

    @Override
    public void deletePressOrder(Integer id) {
        pressOrderRepository.delete(id);
    }

    @Override
    public Iterable<Order> listAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Iterable<Order> listOrderByFruit(String  fruitName) {
        return null;
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order addOrder(int amount, Fruit fruit, int idClient) {
        return orderRepository.save(createOrder(amount,fruit,idClient));
    }

    @Override
    public Order saveOrder(int id, int amount, Fruit fruit, int idClient) {
        return null;
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.delete(id);
    }

    private Order createOrder(int amount, Fruit fruit, int idClient){
        return new Order(amount,fruit,idClient);
    }

    private PressOrder createPressOrder(int amountOfFruit, Fruit fruit, int maxJuiceAmount, int idClient){
        Order order = createOrder(0,fruit,idClient);
        return new PressOrder(amountOfFruit,maxJuiceAmount,order);
    }

    @Override
    public Order processOrder(OrderData orderData){
        Order order = new Order(orderData.fruitAmount,fruitRepository.findOne(orderData.fruitId),orderData.clientId);

        return orderRepository.save(order);
    }

    @Override
    public PressOrder processPressOrder(PressOrderData pressOrderData){
        return pressOrderRepository.save(new PressOrder(pressOrderData.fruitAmount,pressOrderData.maxJuiceAmount,new Order(0,fruitRepository.findOne(pressOrderData.fruitId),pressOrderData.clientId)));
    }

    @Override
    public Iterable<Schedule> listAllSchedules(){
        return scheduleRepository.findAll();
    }

    @Override
    public Schedule processSchedule(ScheduleData scheduleData){
        return scheduleRepository.save(new Schedule(machineRepository.findOne(scheduleData.machineId),pressOrderRepository.findOne(scheduleData.pressOrderId),scheduleData.beginHour,scheduleData.endHour));
    }

    @Override
    public Iterable<Machine> listAllMachines(){
        return machineRepository.findAll();
    }

    @Override
    public Iterable<Technician> listAllTechnicians(){
        return technicianRepository.findAll();
    }

    @Override
    public Technician getTechnicianById(int id){
        return technicianRepository.findOne(id);
    }

    @Override
    public Iterable<RequestTechnician> listAllRequestTechnicians(){
        return requestTechnicianRepository.findAll();
    }

    @Override
    public RequestTechnician getRequestTechnicianById(int id){
        return requestTechnicianRepository.findOne(id);
    }

    @Override
    public RequestTechnician processRequestTechnician(RequestTechnicianData requestTechnicianData){
        return requestTechnicianRepository.save(new RequestTechnician(requestTechnicianData.sendDate,requestTechnicianData.message,technicianRepository.findOne(requestTechnicianData.technicianId)));
    }
}
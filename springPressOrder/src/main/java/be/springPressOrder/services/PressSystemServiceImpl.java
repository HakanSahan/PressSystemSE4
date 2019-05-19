package be.springPressOrder.services;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.text.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class PressSystemServiceImpl implements PressSystemService {
    private PressOrderRepository pressOrderRepository;
    private FruitRepository fruitRepository;
    private OrderRepository orderRepository;
    private ScheduleRepository scheduleRepository;
    private MachineRepository machineRepository;
    private TechnicianRepository technicianRepository;
    private RequestTechnicianRepository requestTechnicianRepository;
    private UserRepository userRepository;
    private StorageRepository storageRepository;
    private FruitDataRepository fruitDataRepository;

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) { this.pressOrderRepository = pressOrderRepository; }

    @Autowired
    public void setUserRepository(UserRepository userRepository){this.userRepository = userRepository;}

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

    @Autowired
    public void setStorageRepository (StorageRepository storageRepository){this.storageRepository = storageRepository;}

    @Autowired
    public void setFruitDataRepository (FruitDataRepository fruitDataRepository){this.fruitDataRepository=fruitDataRepository;}

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
            if(pressOrder.getOrder().getId() == idOrder)
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
    public String processSchedule(ScheduleData scheduleData) throws ParseException {
        String message = "";
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        System.out.println(format.parse(scheduleData.beginHour).toString());
        System.out.println(format.parse(scheduleData.endHour).toString());
        Schedule schedule = new Schedule(machineRepository.findOne(scheduleData.machineId),pressOrderRepository.findOne(scheduleData.pressOrderId),format.parse(scheduleData.beginHour),format.parse(scheduleData.endHour));
        schedule = scheduleRepository.save(schedule);
        return String.format("Press order has been scheduled with id %d",schedule.getId());
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


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUsername(username);
        if (user != null) return user;
        throw new UsernameNotFoundException("User "+username+" not found!");
    }

    public Iterable<Storage> listAllStorages(){
        return storageRepository.findAll();
    }

    public Storage getStorageById(int id){
        return storageRepository.findOne(id);
    }

    public void checkMachinesStatus(){
        Iterable<Machine> machines = machineRepository.findAll();
        for (Machine machine:machines) {
            Machine.Status oldStatus = machine.getStatus();
            if(machine.getStatus() == Machine.Status.Ok){
                int hoursActive = 0;
                for (Schedule schedule:machine.getSchedules()) {
                    hoursActive += (schedule.getEndHour().getTime() - schedule.getStartHour().getTime())/(60 * 60 * 1000) % 24;
                }
                double errorChance = 0.1 + 0.0012 * hoursActive;
                if(Math.random() < errorChance)
                    machine.setStatus(Machine.Status.Not_OK);
            }
            machine.addRapport(new Rapport(machine,oldStatus,machine.getStatus(),""));
            machineRepository.save(machine);
        }
    }

    public void predictFruitAmount(){
        Weather weather = new Weather(25,5,20,5,new Date(),new Date());
        Fruit fruit = new Fruit();
        //if(weather.getAverageAmountOfRain() > 250 && weather.getAvarageHoursOfSun() > 5)
    }

    public void pressPressOrder(int pressOrderId){
        PressOrder po = getPressOrderById(pressOrderId);
        FruitData fruitData = fruitDataRepository.findByFruit(po.getOrder().getFruit());
        po.setStatus(PressOrder.Status.Executed);
        int amountOfJuiceTotal = (int)Math.round(po.getFruitAmount()*fruitData.getAvgJuiceAmount());
        Juice juiceForClient = new Juice();
        if(amountOfJuiceTotal > po.getMaxJuiceAmount()) {
            juiceForClient.setAmount(po.getMaxJuiceAmount());
            Juice restJuice = new Juice();
            restJuice.setAmount(amountOfJuiceTotal - po.getMaxJuiceAmount());
            Storage storage = storageRepository.findStorageByFruit(po.getOrder().getFruit());
            storage.addJuice(restJuice);
            storageRepository.save(storage);
        }
        else
            juiceForClient.setAmount(po.getMaxJuiceAmount());
        po.getOrder().setAmount(juiceForClient.getAmount());
        po.getOrder().addJuice(juiceForClient);
        pressOrderRepository.save(po);
    }

    public void getJuicesForOrder(int orderId){
        Order order = getOrderById(orderId);
        Storage storage =storageRepository.findStorageByFruit(order.getFruit());
        if(storage.getTotal() >= order.getAmount()){
            if(storage.getTotal() == order.getAmount()) {
                order.setJuices(storage.getJuices());
                storage.getJuices().clear();
            }
            Set<Juice> juices = storage.getJuices();
            for (Juice juice:juices) {
                if(juice.getAmount() <= order.getAmount()){
                    order.addJuice(juice);
                    order.setAmount(order.getAmount() - juice.getAmount());
                    storage.removeJuice(juice);
                    if(order.getAmount() == 0)
                        break;
                }
                else {
                    Juice orderJuice = new Juice(juice.getFruit(),order.getAmount(),juice.getPressDate(),juice.getFromClient());
                    order.addJuice(orderJuice);
                    juice.setAmount(juice.getAmount()-order.getAmount());
                    break;
                }
            }
            orderRepository.save(order);
            storageRepository.save(storage);
        }
        else
            order.setStatus(Order.Status.Canceled);
    }

}

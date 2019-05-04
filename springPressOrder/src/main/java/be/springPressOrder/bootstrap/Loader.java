package be.springPressOrder.bootstrap;

import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Date;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private PressOrderRepository pressOrderRepository;
    private OrderRepository orderRepository;
    private FruitRepository fruitRepository;
    private MachineRepository machineRepository;
    private ScheduleRepository scheduleRepository;
    private TechnicianRepository technicianRepository;
    private RequestTechnicianRepository requestTechnicianRepository;

    private Logger log = Logger.getLogger(Loader.class);

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setFruitRepository (FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setMachineRepository(MachineRepository machineRepository){this.machineRepository = machineRepository;}

    @Autowired
    public void setScheduleRepository(ScheduleRepository scheduleRepository){this.scheduleRepository = scheduleRepository;}

    @Autowired
    public void setTechnicianRepository(TechnicianRepository technicianRepository){this.technicianRepository =technicianRepository;}

    @Autowired
    public void setRequestTechnicianRepository(RequestTechnicianRepository requestTechnicianRepository){this.requestTechnicianRepository = requestTechnicianRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Fruit apple = new Fruit("Apple",0.1,5,7);
        Fruit pear = new Fruit("Pear",0.2,2,3);
        fruitRepository.save(apple);
        fruitRepository.save(pear);
        Order order1 = new Order(2,apple,1);
        orderRepository.save(order1);
        log.info("Saved order1 - id: " + order1.getId());

        Order order2 = new Order(3,pear,2);
        orderRepository.save(order2);
        log.info("Saved order2 - id: " + order2.getId());

        PressOrder pressOrder1 = new PressOrder(100,10,new Order(2,pear,1));
        pressOrderRepository.save(pressOrder1);
        log.info("Saved press order1 - id: " + pressOrder1.getId());

        PressOrder pressOrder2 = new PressOrder(100,10,new Order(2,apple,1));
        pressOrderRepository.save(pressOrder2);
        log.info("Saved press order2 - id: " + pressOrder2.getId());

        PressOrder order3 = new PressOrder(100,10,new Order(2,apple,1));
        pressOrderRepository.save(order3);
        log.info("Saved press order3 - id: " + order3.getId());

        Machine machine1 = new Machine(1,false,100);
        Machine machine2 = new Machine(2,false,100);
        Machine machine3 = new Machine(3,false,100);
        machineRepository.save(machine1);
        machineRepository.save(machine2);
        machineRepository.save(machine3);

        Technician technician1 = new Technician("Duck","James","+32479019788","JamesDuck@Duck.com");
        Technician technician2 = new Technician("Flamingo","Jeff","+32488527488","JeffFlamingo@Duck.com");

        RequestTechnician request1 = new RequestTechnician(new Date(),"Please HELP",technician1);

        RequestTechnician request2 = new RequestTechnician(new Date(),"Boot too big",technician1);

        RequestTechnician request3 = new RequestTechnician(new Date(),"Please HELP",technician2);

        RequestTechnician request4 = new RequestTechnician(new Date(),"Boot too big",technician2);

        technician1.getRequestTechnicians().add(request1);
        technician1.getRequestTechnicians().add(request2);
        technician2.getRequestTechnicians().add(request3);
        technician2.getRequestTechnicians().add(request4);

        technicianRepository.save(technician1);
        technicianRepository.save(technician2);

        requestTechnicianRepository.save(request1);
        requestTechnicianRepository.save(request4);
        requestTechnicianRepository.save(request2);
        requestTechnicianRepository.save(request3);

        Schedule schedule = new Schedule(machine1,pressOrder1,new Date(),new Date());

        scheduleRepository.save(schedule);

        /*PressOrder shirt = new PressOrder();
        shirt.setDescription("Spring Framework Guru Shirt");
        shirt.setPrice(new BigDecimal("18.95"));
        shirt.setImageUrl("https://springPressOrder.guru/wp-content/uploads/2015/04/spring_framework_guru_shirt-rf412049699c14ba5b68bb1c09182bfa2_8nax2_512.jpg");
        shirt.setProductId("235268845711068308");
        pressOrderRepository.save(shirt);

        log.info("Saved Shirt - id: " + shirt.getId());

        PressOrder mug = new PressOrder();
        mug.setDescription("Spring Framework Guru Mug");
        mug.setImageUrl("https://springPressOrder.guru/wp-content/uploads/2015/04/spring_framework_guru_coffee_mug-r11e7694903c348e1a667dfd2f1474d95_x7j54_8byvr_512.jpg");
        mug.setProductId("168639393495335947");
        mug.setPrice(new BigDecimal("11.95"));
        pressOrderRepository.save(mug);

        log.info("Saved Mug - id:" + mug.getId());
        */
    }
}

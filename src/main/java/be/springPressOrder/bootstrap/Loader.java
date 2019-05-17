package be.springPressOrder.bootstrap;

import be.springPressOrder.dao.MachineRepository;
import be.springPressOrder.domain.Machine;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.dao.PressOrderRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private PressOrderRepository pressOrderRepository;
    private OrderRepository orderRepository;
    private MachineRepository machineRepository;

    private Logger log = Logger.getLogger(Loader.class);

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setMachineRepository (MachineRepository machineRepository) {this.machineRepository = machineRepository;}

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        //Orders
        Order order1 = new Order(2,"AppleJuice",1);
        orderRepository.save(order1);
        log.info("Saved order1 - id: " + order1.getId());

        Order order2 = new Order(3,"PearJuice",2);
        orderRepository.save(order2);
        log.info("Saved order2 - id: " + order2.getId());

        PressOrder pressOrder1 = new PressOrder(100, 99, 100, PressOrder.Status.Planned,order2);
        pressOrderRepository.save(pressOrder1);
        log.info("Saved press order1 - id: " + pressOrder1.getId());

        PressOrder pressOrder2 = new PressOrder(1, 7, 1, PressOrder.Status.NotPlanned,order2);
        pressOrderRepository.save(pressOrder2);
        log.info("Saved press order2 - id: " + pressOrder2.getId());

        PressOrder order3 = new PressOrder(2, 6, 2, PressOrder.Status.NotPlanned,order1);
        pressOrderRepository.save(order3);
        log.info("Saved press order3 - id: " + order3.getId());

        //Machines
        Machine machine1 = new Machine(Machine.Status.NietOK,true,200);
        machineRepository.save(machine1);
        log.info("Saved Machine 1");

        Machine machine2 = new Machine(Machine.Status.Ok, false, 350);
        machineRepository.save(machine2);
        log.info("Saved Machine 2");

        Machine machine3 = new Machine(Machine.Status.Ok, true, 350);
        machineRepository.save(machine3);
        log.info("Saved Machine 3");

        Machine machine4 = new Machine(Machine.Status.NietOK, false, 250);
        machineRepository.save(machine4);
        log.info("Saved Machine 4");

        Machine machine5 = new Machine(Machine.Status.NietOK, false, 300);
        machineRepository.save(machine5);
        log.info("Saved Machine 5");


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

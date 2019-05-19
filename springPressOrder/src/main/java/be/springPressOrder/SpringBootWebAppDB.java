package be.springPressOrder;

import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class SpringBootWebAppDB implements CommandLineRunner {

    @Autowired
    PressOrderRepository pressOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FruitRepository fruitRepository;

    @Autowired
    MachineRepository machineRepository;

    @Override
    public void run(String... args) throws Exception {

        User user = new User(1,"admin","{noop}password","ROLE_ADMIN","a","a","a");


        userRepository.save(user);

        Fruit fruit = new Fruit("Apple");
        fruitRepository.save(fruit);

        machineRepository.save(new Machine());

      List<Order> orders = Arrays.asList(
                new Order(50,fruit,1),
                new Order(50,fruit,1),
                new Order(50,fruit,1));

            orderRepository.save(orders);

        //orderRepository.save(order1);
        //log.info("Saved order1 - id: " + order1.getId());

        Order order2 = new Order(50,fruit,1);
        orderRepository.save(order2);
        //log.info("Saved order2 - id: " + order2.getId());

          List<PressOrder> pressOrders = Arrays.asList(
                    new PressOrder(100, 99, order2),
                    new PressOrder(1, 7,  order2),
                    new PressOrder(2, 6, order2));

                pressOrderRepository.save(pressOrders);


            PressOrder pressOrder1 = new PressOrder(100, 99, order2);
            pressOrderRepository.save(pressOrder1);
            //log.info("Saved press order1 - id: " + pressOrder1.getId());

            PressOrder pressOrder2 = new PressOrder(1, 7,  order2);
            pressOrderRepository.save(pressOrder2);
            //log.info("Saved press order2 - id: " + pressOrder2.getId());

            PressOrder order3 = new PressOrder(2, 6, order2);
            pressOrderRepository.save(order3);
            //log.info("Saved press order3 - id: " + order3.getId());
        }
    }
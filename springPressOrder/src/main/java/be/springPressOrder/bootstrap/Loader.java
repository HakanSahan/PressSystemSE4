package be.springPressOrder.bootstrap;

import be.springPressOrder.dao.*;
import be.springPressOrder.domain.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Loader implements ApplicationListener<ContextRefreshedEvent> {

    private PressOrderRepository pressOrderRepository;
    private OrderRepository orderRepository;
    private JuiceRepository juiceRepository;
    private FruitRepository fruitRepository;
    private UserRepository userRepository;

    private Logger log = Logger.getLogger(Loader.class);

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setFruitRepository(FruitRepository fruitRepository){this.fruitRepository = fruitRepository;}

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Autowired
    public void setJuiceRepository(JuiceRepository juiceRepository) {
        this.juiceRepository = juiceRepository;
    }


    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        Fruit sortapple1 = new Fruit("apple",0.25,1,2);
        fruitRepository.save(sortapple1);
        Juice juice1 = new Juice(sortapple1,20,new Date(),1);
        juiceRepository.save(juice1);

        Order order1 = new Order(5,juice1,1);
        orderRepository.save(order1);
        log.info("Saved order1 - id: " + order1.getId());

        Order order2 = new Order(3,juice1,2);
        orderRepository.save(order2);
        log.info("Saved order2 - id: " + order2.getId());

        PressOrder pressOrder1 = new PressOrder(100,order2);
        pressOrder1.setClientId(1);
        pressOrderRepository.save(pressOrder1);
        log.info("Saved press order1 - id: " + pressOrder1.getId());

        PressOrder pressOrder2 = new PressOrder(7,order2);
        pressOrderRepository.save(pressOrder2);
        log.info("Saved press order2 - id: " + pressOrder2.getId());

        PressOrder order3 = new PressOrder(2,order1);
        pressOrderRepository.save(order3);
        log.info("Saved press order3 - id: " + order3.getId());

        User user = new User("V","P","04","e@mail.com","username","USER","password");
        userRepository.save(user);
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

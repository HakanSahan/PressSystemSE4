package be.springPressOrder;

import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.dao.PressOrderRepository;
import be.springPressOrder.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;


@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
public class SpringBootWebAppDB implements CommandLineRunner {

    @Autowired
    PressOrderRepository pressOrderRepository;

    @Autowired
    OrderRepository orderRepository;

    /*@Autowired
    EntryRepository entryRepository;*/

    @Autowired
    UserRepository userRepository;

        /*for (User user: users) {
            // user must be saved for it to have an id
            userRepository.save(user);
            // There must be 1 dummy entry for each user to save the next startTimeFrom
            Entry dummyEntry = new Entry();
            dummyEntry.setUser(user);
            LocalDateTime now = LocalDateTime.now();
            dummyEntry.setDateTimeFrom(now);
            dummyEntry.setDateTimeTo(now);
            dummyEntry.setDuration(Duration.ZERO);
            dummyEntry.setDescription("This is your dummy entry, for housekeeping purposes");
            entryRepository.save(dummyEntry);

            user.setDummyEntry(dummyEntry);
            userRepository.save(user);
        }*/

        //private Logger log = Logger.getLogger(be.springPressOrder.bootstrap.Loader.class);

    @Autowired
    public void setPressOrderRepository(PressOrderRepository pressOrderRepository) {
        this.pressOrderRepository = pressOrderRepository;
    }

    @Autowired
    public void setOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
/*
        List<User> users = Arrays.asList(
                new User("admin","admin", true, true, true,true, SimpleGrantedAuthority(role.toString()),
                /*new User("press","press",
                        "ROLE_USER","Tessa", "Wullaert", "tessa@wullaert.be"),
                new User("client", "client",
                        "ROLE_USER","Nicky", "Evrard", "nicky@evrard.be"),
                new User("tech", "tech",
                        "ROLE_ADMIN","Hans", "Vandenbogaerde","hans@gmail.com")
        );*/

        /*for (User user: users) {
            // user must be saved for it to have an id
            userRepository.save(user);
            // There must be 1 dummy entry for each user to save the next startTimeFrom
            Entry dummyEntry = new Entry();
            dummyEntry.setUser(user);
            LocalDateTime now = LocalDateTime.now();
            dummyEntry.setDateTimeFrom(now);
            dummyEntry.setDateTimeTo(now);
            dummyEntry.setDuration(Duration.ZERO);
            dummyEntry.setDescription("This is your dummy entry, for housekeeping purposes");
            entryRepository.save(dummyEntry);

            user.setDummyEntry(dummyEntry);
            userRepository.save(user);
        }*/



        /*List<Order> orders = Arrays.asList(
        new Order(2,"AppleJuice",1),
        new Order(3,"PearJuice",2),
        new Order(4,"ApplePearJuice",3));

        for (Order order: orders) {
            orderRepository.save(order);
        }*/

        //orderRepository.save(order1);
        //log.info("Saved order1 - id: " + order1.getId());

        /*Order order2 = new Order(3,"PearJuice",2);
        orderRepository.save(order2);
        log.info("Saved order2 - id: " + order2.getId());*/

        /*for(Order order:orders){
            List<PressOrder> pressOrders = Arrays.asList(
                    new PressOrder(100, 99, 100, PressOrder.Status.Planned,order),
                    new PressOrder(1, 7, 1, PressOrder.Status.NotPlanned,order),
                    new PressOrder(2, 6, 2, PressOrder.Status.NotPlanned,order));

            for (PressOrder pressOrder: pressOrders) {
                pressOrderRepository.save(pressOrder);

        }

        PressOrder pressOrder1 = new PressOrder(100, 99, 100, PressOrder.Status.Planned,order2);
        pressOrderRepository.save(pressOrder1);
        log.info("Saved press order1 - id: " + pressOrder1.getId());

        PressOrder pressOrder2 = new PressOrder(1, 7, 1, PressOrder.Status.NotPlanned,order2);
        pressOrderRepository.save(pressOrder2);
        log.info("Saved press order2 - id: " + pressOrder2.getId());

        PressOrder order3 = new PressOrder(2, 6, 2, PressOrder.Status.NotPlanned,order1);
        pressOrderRepository.save(order3);
        log.info("Saved press order3 - id: " + order3.getId());*/
    }
}
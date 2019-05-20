package be.springPressOrder;

import be.springPressOrder.dao.PressOrderRepository;
import be.springPressOrder.domain.Fruit;
import be.springPressOrder.domain.Order;
import be.springPressOrder.domain.PressOrder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    //Creatie van objecten om microservices van Order en PressOrder te testen
    @Bean
    CommandLineRunner init(PressOrderRepository pressOrderRepository) {
        Fruit fruitTest = new Fruit("Apple");
        Order order = new Order(40,fruitTest,1);
        Order order2 = new Order(8,fruitTest,1);

        return (orders) -> {
            pressOrderRepository.save(new PressOrder(40, 39, order));
            pressOrderRepository.save(new PressOrder(8, 7,  order2));
        };
    }

}

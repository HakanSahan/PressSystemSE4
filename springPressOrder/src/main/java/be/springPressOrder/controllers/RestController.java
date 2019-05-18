package be.springPressOrder.controllers;

import be.springPressOrder.dao.OrderRepository;
import be.springPressOrder.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path="/orderrest", produces = "application/json")
@CrossOrigin(origins="*")
public class RestController {

    @Autowired
    private OrderRepository orderRepository;

    @GetMapping("/{id}")
    public Order getOrderbyId(@PathVariable("id") int id) {
        return orderRepository.findByIdClient(id); //.get()
    }
}

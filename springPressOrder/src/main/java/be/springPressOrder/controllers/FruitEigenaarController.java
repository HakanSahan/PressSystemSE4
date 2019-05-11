package be.springPressOrder.controllers;

import be.springPressOrder.services.OrderService;
import be.springPressOrder.services.PressOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FruitEigenaarController {
    private PressOrderService pressOrderService;
    private OrderService orderService;

    @Autowired
    public void setPressOrderService(PressOrderService pressOrderService) {
        this.pressOrderService = pressOrderService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/fruiteigenaaroverzicht/{id}", method = RequestMethod.GET)
    public String list(@PathVariable Integer id,Model model) {
        model.addAttribute("Orders", orderService.getOrdersByClientId(id));
        model.addAttribute("PressOrders", pressOrderService.getPressOrdersByClientId(id));
        return "fruiteigenaaroverzicht";
    }
}

package be.springPressOrder.controllers;

import be.springPressOrder.Data.OrderData;
import be.springPressOrder.domain.Order;
import be.springPressOrder.services.OrderService;
import be.springPressOrder.services.PressOrderService;
import lombok.extern.slf4j.Slf4j;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/menu")
public class OrderController {


    private PressSystemService pressSystemService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("listOrders", pressSystemService.listAllOrders());
        return "orders";
    }
    //(value = "/orders", method = RequestMethod.GET)

    @RequestMapping("order/{id}")
    public String showOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", pressSystemService.getOrderById(id));
        return "ordersshow";
    }

    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", pressSystemService.getOrderById(id));
        return "orderform";
    }

    @RequestMapping("order/new")
    public String newOrder(Model model) {
        model.addAttribute("objOrder", new OrderData());
        model.addAttribute("objFruits",pressSystemService.listAllFruits());
        return "orderform";
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public String saveOrder(OrderData order) {
        Order newOrder = pressSystemService.processOrder(order);
        return "redirect:/order/" + newOrder.getId();
    }

    @RequestMapping("order/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deleteOrder(id);
        return "redirect:/orders";
    }

    @RequestMapping("order/pressorders/{id}")
    public String listDetail(@PathVariable Integer id,Model model) {
        model.addAttribute("listOrders", pressSystemService.listPressOrderByOrder(id));//listAllPressOrders());
        return "ordersdetails";
    }


}

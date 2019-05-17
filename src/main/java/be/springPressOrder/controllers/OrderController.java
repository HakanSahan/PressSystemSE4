package be.springPressOrder.controllers;

import be.springPressOrder.domain.Order;
import be.springPressOrder.services.OrderService;
import be.springPressOrder.services.PressOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class OrderController {

    private OrderService orderService;
    private PressOrderService pressOrderService;

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @Autowired
    public void setPressOrderService(PressOrderService pressOrderService) {
        this.pressOrderService = pressOrderService;
    }

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("listOrders", orderService.listAllOrders());
        return "orders";
    }

    @RequestMapping("order/{id}")
    public String showOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", orderService.getOrderById(id));
        return "ordersshow";
    }

    @RequestMapping("order/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("objOrder", orderService.getOrderById(id));
        return "orderform";
    }

    @RequestMapping("order/new")
    public String newOrder(Model model) {
        model.addAttribute("objOrder", new Order());
        return "orderform";
    }

    @RequestMapping(value = "order", method = RequestMethod.POST)
    public String saveOrder(Order order) {
        orderService.saveOrder(order);
        return "redirect:/order/" + order.getId();
    }

    @RequestMapping("order/delete/{id}")
    public String delete(@PathVariable Integer id) {
        orderService.deleteOrder(id);
        return "redirect:/orders";
    }

    @RequestMapping("order/pressorders/{id}")
    public String listDetail(@PathVariable Integer id,Model model) {
       // model.addAttribute("listOrders", orderService.listAllOrders());
        model.addAttribute("listOrders", pressOrderService.listPressOrderByOrder(id));//listAllPressOrders());
        //model.addAttribute("message", "HELLO");
        return "ordersdetails";
    }


}

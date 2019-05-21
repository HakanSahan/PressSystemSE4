package be.springPressOrder.controllers;

import be.springPressOrder.domain.Order;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class OrderController {

//private PressSystemService pressSystemService;

    @Autowired
    PressSystemService pressSystemService;

    //bestaande orders zien
    @RequestMapping (path = "seeOrder", method=RequestMethod.POST)
    Order seeOrder (@RequestBody Order order)	{
        return pressSystemService.getOrderById(order.getId());
    }

    //nieuwe orders maken(verwijst naar methode in PressSystemServiceImpl) en zien
    @RequestMapping (path = "newOrder", method=RequestMethod.POST)
    Order  newOrder (@RequestBody Order order)	{
        order = pressSystemService.newOrder(order);
        return pressSystemService.getOrderById(order.getId());
    }

    /*@RequestMapping(value = "/orders", method = RequestMethod.GET)
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
        System.out.println("==================================TEST POST ORDER======================================");
        Order newOrder = pressSystemService.processOrder(order);
        return "redirect:/order/" + newOrder.getId();
    }
    @RequestMapping("order/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deleteOrder(id);
        return "redirect:/orders";
    }
    @RequestMapping("order/pressorders/{id}")
    public String listDetail(@PathVariable Integer id, Model model) {
        model.addAttribute("listOrders", pressSystemService.listPressOrderByOrder(id));//listAllPressOrders());
        return "ordersdetails";
    }
    @RequestMapping(value={"/orderbyclientid.html"}, method = RequestMethod.GET)
    public String orderDetailsByClientId(@RequestParam("idClient") Integer idClient, ModelMap model){
        //Order order = orderService.getOrderByClientId(idClient);
        model.addAttribute("objOrder",pressSystemService.getOrderByClientId(idClient));
        return "ordersshow";
    }*/

}
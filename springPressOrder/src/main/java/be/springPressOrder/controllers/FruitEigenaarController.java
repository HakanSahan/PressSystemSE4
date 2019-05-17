package be.springPressOrder.controllers;

import be.springPressOrder.domain.Client;
import be.springPressOrder.domain.User;
import be.springPressOrder.services.ClientService;
import be.springPressOrder.services.OrderService;
import be.springPressOrder.services.PressOrderService;
import be.springPressOrder.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FruitEigenaarController {
    private PressOrderService pressOrderService;
    private UserService userService;
    private OrderService orderService;

    @Autowired
    public void setPressOrderService(PressOrderService pressOrderService) {
        this.pressOrderService = pressOrderService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }

    @RequestMapping(value = "/fruiteigenaar/overzicht/{id}", method = RequestMethod.GET)
    public String list(@PathVariable Integer id,Model model) {
        model.addAttribute("Orders", orderService.getOrdersByClientId(id));
        model.addAttribute("PressOrders", pressOrderService.getPressOrdersByClientId(id));
        return "fruiteigenaaroverzicht";
    }
    @RequestMapping(value = "/fruiteigenaar/registratie", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("objUser", new User());
        //model.addAttribute("PressOrders", pressOrderService.getPressOrdersByClientId(id));
        return "fruiteigenaarregistratie";
    }


    //@RequestMapping(value = "/fruiteigenaar/create", method = RequestMethod.POST)
    /*public String saveOrder(Client client) {
        //clientService.saveClient(client);
        return "redirect:/order/1";
    }*/
    @RequestMapping(value = "/fruiteigenaar/create", method = RequestMethod.POST)
    public String saveOrder(User user) {
        user.setRole("USER");
        userService.saveUser(user);
        return "redirect:/";
    }
}

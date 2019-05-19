package be.springPressOrder.controllers;

import be.springPressOrder.Data.PressOrderData;
import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.services.PressSystemService;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Slf4j
@Controller
public class PressOrderController {

    private PressSystemService pressSystemService;

    @Autowired
    public void setPressOrderService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
    }

    @Autowired
<<<<<<< HEAD
<<<<<<< HEAD
    public void setOrderService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
=======
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
>>>>>>> parent of 2e50c06... merge fix
=======
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
>>>>>>> parent of 2e50c06... merge fix
    }

    @RequestMapping(value = "/pressorders", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("pressOrders", pressSystemService.listAllPressOrders());
        return "pressorders";
    }

    @RequestMapping("pressorder/{id}")
    public String showPressOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressSystemService.getPressOrderById(id));
        return "pressordersshow";
    }

    @RequestMapping("pressorder/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressSystemService.getPressOrderById(id));
        return "pressorderform";
    }

    @RequestMapping("pressorder/new")
    public String newPressOrder(Model model) {
        model.addAttribute("objPressOrder", new PressOrderData());
        model.addAttribute("objFruits",pressSystemService.listAllFruits());
        return "pressorderform";
    }

    @RequestMapping(value = "pressOrder", method = RequestMethod.POST)
    public String savePressOrder(@Valid PressOrderData pressOrder, Errors errors, Model model) {
        //pressSystemService.addPressOrder(pressOrder.getFruitAmount(),pressOrder.getOrder().getFruit(),pressOrder.getMaxJuiceAmount(),pressOrder.getOrder().getIdClient());
        PressOrder newPressOrder = pressSystemService.processPressOrder(pressOrder);
        return "redirect:/pressorder/" + newPressOrder.getId();
    }

    @RequestMapping("pressorder/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deletePressOrder(id);
        return "redirect:/pressorders";
    }

    @RequestMapping(value={"/pressorderbyorderbyid.html"}, method = RequestMethod.GET)
<<<<<<< HEAD
<<<<<<< HEAD
    public String pressOrderDetailsByOrderId(@RequestParam("orderId") Integer orderId, ModelMap model){
        //Order order = orderService.getOrderByClientId(idClient);
        model.addAttribute("pressOrder",pressSystemService.getPressOrderById(orderId));
=======
    public String pressOrderDetailsByOrderId(@RequestParam("orderid") Integer orderid, ModelMap model){
        //Order order = orderService.getOrderByClientId(idClient);
        model.addAttribute("pressOrder",pressOrderService.getPressOrderByOrder(orderService.getOrderById(orderid)));
>>>>>>> parent of 2e50c06... merge fix
=======
    public String pressOrderDetailsByOrderId(@RequestParam("orderid") Integer orderid, ModelMap model){
        //Order order = orderService.getOrderByClientId(idClient);
        model.addAttribute("pressOrder",pressOrderService.getPressOrderByOrder(orderService.getOrderById(orderid)));
>>>>>>> parent of 2e50c06... merge fix
        return "pressordersshow";
    }

    @RequestMapping("pressorder/plan/{id}")
    public String plan(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressOrderService.getPressOrderById(id));
        return "pressorderplan";
    }
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> parent of 2e50c06... merge fix



>>>>>>> parent of 2e50c06... merge fix
}

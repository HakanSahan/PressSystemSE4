package be.springPressOrder.controllers;

import be.springPressOrder.services.PressOrderService;
import be.springPressOrder.domain.PressOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PressOrderController {

    private PressOrderService pressOrderService;

    @Autowired
    public void setPressOrderService(PressOrderService pressOrderService) {
        this.pressOrderService = pressOrderService;
    }

    @RequestMapping(value = "/pressorders", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("pressOrders", pressOrderService.listAllPressOrders());
        return "pressorders";
    }

    @RequestMapping("pressorder/{id}")
    public String showPressOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressOrderService.getPressOrderById(id));
        return "pressordersshow";
    }

    @RequestMapping("pressorder/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pressOrder", pressOrderService.getPressOrderById(id));
        return "pressorderform";
    }

    @RequestMapping("pressorder/new")
    public String newPressOrder(Model model) {
        model.addAttribute("pressOrder", new PressOrder());
        return "pressorderform";
    }

    @RequestMapping(value = "pressorder", method = RequestMethod.POST)
    public String savePressOrder(PressOrder pressOrder) {
        pressOrderService.savePressOrder(pressOrder);
        return "redirect:/pressorder/" + pressOrder.getId();
    }

    @RequestMapping("pressorder/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressOrderService.deletePressOrder(id);
        return "redirect:/pressorders";
    }

    /*@RequestMapping("pressorder/xorder/{id}")
    public String xorders(@PathVariable Integer id) {
        //xOrderService.deletePressOrder(id);
        return "redirect:/xorders";
    }*/


}

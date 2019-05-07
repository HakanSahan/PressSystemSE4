package be.springPressOrder.controllers;

import be.springPressOrder.domain.PressOrder;
import be.springPressOrder.services.PressOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Slf4j
@Controller
@RequestMapping("/menu")
public class PressOrderController {

    private PressSystemService pressSystemService;

    @Autowired
    public void setPressOrderService(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;
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
    public String savePressOrder(PressOrderData pressOrder) {
        //pressSystemService.addPressOrder(pressOrder.getFruitAmount(),pressOrder.getOrder().getFruit(),pressOrder.getMaxJuiceAmount(),pressOrder.getOrder().getIdClient());
        PressOrder newPressOrder = pressSystemService.processPressOrder(pressOrder);
        return "redirect:/pressorder/" + newPressOrder.getId();
    }

    @RequestMapping("pressorder/delete/{id}")
    public String delete(@PathVariable Integer id) {
        pressSystemService.deletePressOrder(id);
        return "redirect:/pressorders";
    }


}

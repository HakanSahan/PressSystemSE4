package be.springPressOrder.controllers;

import be.springPressOrder.domain.Machine;
import be.springPressOrder.services.MachineService;
import be.springPressOrder.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;


@Controller
public class MachineController {

    private MachineService machineService;

    @Autowired
    public void setMachineService(MachineService machineService) {
        this.machineService = machineService;
    }

    @RequestMapping(value = "/machines", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("listMachines", machineService.listAllMachines());
        return "machines";
    }

    @RequestMapping("machines/{id}")
    public String showOrder(@PathVariable Integer id, Model model) {
        model.addAttribute("objMachine", machineService.getMachineById(id));
        return "machineshow";
    }

}

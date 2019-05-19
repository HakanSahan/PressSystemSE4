package be.springPressOrder.controllers;

import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ScheduleController {

    private PressSystemService pressSystemService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("listSchedules",pressSystemService.listAllSchedules());
        return "schedules";
    }

    @RequestMapping(value = "/schedule/new")
    public String newSchedule(Model model){
        model.addAttribute("objSchedule",new ScheduleData());
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "scheduleform";
    }

    @RequestMapping(value = "/machine/{idMachine}/newSchedule")
    public String newScheduleAfterChoosingMachine(@PathVariable Integer idMachine, Model model){

        ScheduleData newSchedule = new ScheduleData();
        newSchedule.machineId = idMachine;
        model.addAttribute("objSchedule",newSchedule);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        //model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "scheduleform";
    }

    @RequestMapping(value = "abc", method = RequestMethod.POST)
    public String saveSchedule(ScheduleData schedule){
        pressSystemService.processSchedule(schedule);
        return "redirect: /schedules";
    }

}

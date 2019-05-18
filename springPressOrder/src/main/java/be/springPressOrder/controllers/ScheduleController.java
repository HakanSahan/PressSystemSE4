package be.springPressOrder.controllers;

import be.springPressOrder.Data.ScheduleData;
import be.springPressOrder.domain.Schedule;
import be.springPressOrder.services.PressSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/schedule")
public class ScheduleController {


    private PressSystemService pressSystemService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @GetMapping
    public String scheduleCreateForm(Model model){
        ScheduleData newSchedule = new ScheduleData();
        model.addAttribute("listMachines",pressSystemService.listAllMachines());
        model.addAttribute("objSchedule",newSchedule);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        //model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "scheduleform";
    }

    @PostMapping(path = "/test")
    public String saveSchedule(ScheduleData schedule){
        System.out.println("TEST POST");
        pressSystemService.processSchedule(schedule);
        return "redirect: /schedules";
    }

        /*@RequestMapping(value = "/schedules", method = RequestMethod.GET)
    public String list(Model model){
        model.addAttribute("listSchedules",pressSystemService.listAllSchedules());
        return "schedules";
    }*/

    /*@RequestMapping(value = "/schedule/new")
    public String newSchedule(Model model){

    }*/



/*    @RequestMapping(value = "/machine/{idMachine}/newSchedule")
    public String newScheduleAfterChoosingMachine(@PathVariable Integer idMachine, Model model){

        ScheduleData newSchedule = new ScheduleData();
        newSchedule.machineId = idMachine;
        model.addAttribute("objSchedule",newSchedule);
        model.addAttribute("listPressOrders", pressSystemService.listAllPressOrders());
        //model.addAttribute("listMachines",pressSystemService.listAllMachines());
        return "scheduleform";
    }*/

}

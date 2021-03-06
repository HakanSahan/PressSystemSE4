package be.springPressOrder.controllers;

import be.springPressOrder.Data.RequestTechnicianData;
import be.springPressOrder.domain.RequestTechnician;
import be.springPressOrder.domain.Technician;
import be.springPressOrder.services.PressSystemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.jws.WebParam;
import javax.validation.Valid;


@Controller
public class TechnicianController {

    private PressSystemService pressSystemService;

    @Autowired
    public void setPressSystemService(PressSystemService pressSystemService){this.pressSystemService = pressSystemService;}

    @RequestMapping(value = "/technican/{id}")
    public String listTechnicianRequets(@PathVariable Integer id,Model model){
        model.addAttribute("listRequests",pressSystemService.getTechnicianById(id).getRequestTechnicians());
        return "technicianOverview";
    }

    @RequestMapping(value = "/request/new", method = RequestMethod.GET)
    public String getNewRequest(Model model)
    {
        model.addAttribute("objRequest",new RequestTechnicianData());
        model.addAttribute("listTechnicians",pressSystemService.listAllTechnicians());
        return "requestForm";
    }

    @RequestMapping(value = "request", method = RequestMethod.POST)
    public String saveRequest(@Valid RequestTechnicianData requestTechnician, Errors errors, Model model){
        System.out.println("=================================================TEST POST TECHNICIAN REQUEST=============================================");
        pressSystemService.processRequestTechnician(requestTechnician);
        return "redirect: /";
    }

    @RequestMapping(value = "request", method = RequestMethod.GET)
    public String showRequest(){
        System.out.println("=================================================TEST POST TECHNICIAN REQUEST=============================================");
        //pressSystemService.processRequestTechnician(requestTechnician);
        return "request";
    }

}

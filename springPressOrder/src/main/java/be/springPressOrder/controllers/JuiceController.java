package be.springPressOrder.controllers;

import be.springPressOrder.domain.Juice;
import be.springPressOrder.services.JuiceService;
import be.springPressOrder.services.JuiceServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
@Controller
public class JuiceController {
    private JuiceServiceInt juiceServiceInt;

    @Autowired
    public void setJuiceServiceInt(JuiceServiceInt juiceServiceInt) {
        this.juiceServiceInt = juiceServiceInt;
    }

    /*
    @RequestMapping(value = "/juices", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("listJuices", juiceServiceInt.listAllJuices());
        return "juices";
    }
    */
//test
    @RequestMapping(value={"/juices"},method=RequestMethod.GET)
    public @ResponseBody
    List<Juice> getJuices(){

        return (List<Juice>) juiceServiceInt.listAllJuices();
    }

}

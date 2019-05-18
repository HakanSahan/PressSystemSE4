package be.springPressOrder.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/menu")
    public String menu(){
        return "menu";
    }

    /*@RequestMapping("/login")
    public String login() {
        return "login";
    }*/

    @RequestMapping("/403")
    public String error403() {
        return "/403";
    }

    @GetMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute("error", true);
        return "login";
    }

}

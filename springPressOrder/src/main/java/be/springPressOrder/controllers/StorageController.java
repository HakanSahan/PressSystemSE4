package be.springPressOrder.controllers;

import be.springPressOrder.domain.Storage;
import be.springPressOrder.services.PressSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.persistence.Column;
import java.util.List;

@Controller
@RequestMapping(path = "/storage")
public class StorageController {
    private PressSystemService pressSystemService;

    @Autowired
    public void setJuiceServiceInt(PressSystemService pressSystemService) {
        this.pressSystemService = pressSystemService;

    }

    @GetMapping(path = "/json")
    public @ResponseBody
    List<Storage> getStorage(){
        return (List<Storage>) pressSystemService.listAllStorages();
    }
}

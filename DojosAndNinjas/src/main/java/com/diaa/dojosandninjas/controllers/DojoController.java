package com.diaa.dojosandninjas.controllers;

import com.diaa.dojosandninjas.models.Dojo;
import com.diaa.dojosandninjas.models.Ninja;
import com.diaa.dojosandninjas.services.DojoService;
import jdk.dynalink.linker.LinkerServices;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
public class DojoController {
    private final DojoService dojoService;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @RequestMapping("/")
    public String dojos(Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "dojos/show.jsp";
    }

    @RequestMapping("/dojos/new")
    public String addDojo(@ModelAttribute("dojo") Dojo dojo){
        return "dojos/addDojo.jsp";
    }
    @RequestMapping(value = "dojos/new", method = RequestMethod.POST)
    public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result){
        if(result.hasErrors()){
            return "dojos/addDojo.jsp";
        } else {
            dojoService.addDojo(dojo);
            return "redirect:/";
        }
    }
    @RequestMapping("/ninjas/new")
    public String addNinja(@ModelAttribute("ninja")Ninja ninja, Model model){
        List<Dojo> dojos = dojoService.allDojos();
        model.addAttribute("dojos", dojos);
        return "dojos/addNinja.jsp";
    }
    @RequestMapping(value = "ninjas/new", method = RequestMethod.POST)
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, @RequestParam("dojo") Long id){
        if(result.hasErrors()){
            return "dojos/addNinja.jsp";
        } else {
            dojoService.addNinja(ninja);
            Dojo dojo = dojoService.getDojo(id);
            List<Ninja> ninjas = dojo.getNinjas();
            ninjas.add(ninja);
            return "redirect:/";
        }
    }

    @RequestMapping("dojos/{id}")
    public String displayNinjas(@PathVariable("id") Long id, Model model){
        Dojo dojo = dojoService.getDojo(id);
        List<Ninja> ninjas = dojo.getNinjas();
        model.addAttribute("ninjas",ninjas);
        return "dojos/ninjas.jsp";
    }
}

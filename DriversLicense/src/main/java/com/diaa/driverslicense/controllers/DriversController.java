package com.diaa.driverslicense.controllers;


import com.diaa.driverslicense.models.License;
import com.diaa.driverslicense.models.Person;
import com.diaa.driverslicense.services.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DriversController {

    private final DriverService personService;
    public DriversController(DriverService personService){
        this.personService = personService;
    }

    @RequestMapping("/")
    public String list(Model model){
        List<Person> persons = personService.allPersons();
        model.addAttribute("persons", persons);
        return "list.jsp";
    }

    @RequestMapping("persons/new")
    public String addPerson(@ModelAttribute("person")Person person){
        return "addPerson.jsp";
    }

    @RequestMapping(value = "persons/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("person") Person person, BindingResult result){
        if (result.hasErrors()){
            return "addPerson.jsp";
        }else {
            personService.addPerson(person);
            return "redirect:/";
        }

    }

    @RequestMapping("persons/{id}")
    public String display(Model model,@PathVariable("id") Long id){
        Person person = personService.getPerson(id);
        model.addAttribute("person", person);
        return "person.jsp";
    }


    @RequestMapping("licenses/new")
    public String addLicense(Model model, @ModelAttribute("license")License license){
        List<Person> persons = personService.getUnlicensedPeople();
        model.addAttribute("persons", persons);
        return "addLicense.jsp";
    }
    @RequestMapping(value = "licenses/new", method = RequestMethod.POST)
    public String create(@Valid @ModelAttribute("license")License license, BindingResult result){
        if(result.hasErrors()){
            return "addLicense.jsp";
        } else {
            personService.addLicense(license);
            return "redirect:/";
        }
    }
}

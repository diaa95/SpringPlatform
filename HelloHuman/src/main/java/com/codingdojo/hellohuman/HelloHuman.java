package com.codingdojo.hellohuman;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/human")
public class HelloHuman {
    // 1. Annotation
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String hello(@RequestParam(value = "first_name", required = false) String firstname, @RequestParam(value = "last_name", required = false) String lastname) { // 3
        if (firstname == null) {
            return "<h1>Hello Human</h1><p>Welcome to SpringBoot!</p>";
        }
        else if(firstname != null && lastname == null){
            return "<h1>Hello " + firstname +"</h1><p>Welcome to SpringBoot!</P>";
        }
        else {
            return "<h1>Hello " + firstname +" "+ lastname +"</h1><p>Welcome to SpringBoot!</P>";
        }
    }
}

package com.codingdojo.strings;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1. Annotation
@RestController
public class Strings {
    // 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello() { // 3
        return "Hello client! How are you doing?";
    }
    // 1. Annotation
    @RequestMapping("/random")
    // 3. Method that maps to the request route above
    public String random() { // 3
        return "Spring Boot id great! So easy to just respond with strings";
    }

}

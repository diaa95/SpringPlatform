package com.codingdojo.routing;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 1. Annotation
@RestController
@RequestMapping("/coding")
public class CodingController {
    // 1. Annotation
    @RequestMapping("")
    // 3. Method that maps to the request route above
    public String hello() { // 3
        return "Hello Coding Dojo!";
    }
    // 1. Annotation
    @RequestMapping("/python")
    // 3. Method that maps to the request route above
    public String python() { // 3
        return "Python/Django was awesome!";
    }
    @RequestMapping("/java")
    // 3. Method that maps to the request route above
    public String java() { // 3
        return "Java/Spring is better!";
    }
}


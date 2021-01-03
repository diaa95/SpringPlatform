package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// 2. Importing dependencies
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
// 1. Annotation
@RestController
public class FirstprojectApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstprojectApplication.class, args);
    }

    // 1. Annotation
    @RequestMapping("/")
    // 3. Method that maps to the request route above
    public String hello(@RequestParam(value = "q", required = false) String searchQuery) { // 3
        if (searchQuery == null) {
            return "You searched for: nothing";
        } else {
            return "You searched for: " + searchQuery;
        }
    }
    @RequestMapping("/m/{track}/{module}/{lesson}")
    public String showLesson(@PathVariable("track") String track,@PathVariable("module") String module, @PathVariable("lesson") String lesson){
        return "Track: " + track + ", Module: "+ module + ", Lesson: "+ lesson;
    }
}
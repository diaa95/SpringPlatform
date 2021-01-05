package com.diaa.counter;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.print.attribute.standard.PresentationDirection;
import javax.servlet.http.HttpSession;

@Controller
public class CountController {
    @RequestMapping("/")
    public String start(HttpSession session){
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        return "redirect:/home";
    }
    @RequestMapping("/counter")
    public String home(HttpSession session){
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        return "index.jsp";
    }

    @RequestMapping("/home")
    public String increment(HttpSession session){
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        Integer count = (Integer) session.getAttribute("count");
        count++;
        session.setAttribute("count", count);
        return "home.jsp";
    }
    @RequestMapping("/double")
    public String doubleIncrement(HttpSession session){
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        }
        Integer count = (Integer) session.getAttribute("count");
        count ++;
        session.setAttribute("count", count);
        return "redirect:/home";
    }
    @RequestMapping("/destroy")
    public String destroy(HttpSession session){
        session.setAttribute("count", 0);
        return "redirect:/counter";
        }

}

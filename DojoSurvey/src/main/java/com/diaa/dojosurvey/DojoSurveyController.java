package com.diaa.dojosurvey;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class DojoSurveyController {
    @RequestMapping("/")
    public String index(){
        return "index.jsp";
    }

    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public String result(HttpSession session, @RequestParam(value = "name") String name, @RequestParam("location") String location, @RequestParam("language") String language, @RequestParam("comment") String comment){
        session.setAttribute("name", name);
        session.setAttribute("location", location);
        session.setAttribute("language", language);
        session.setAttribute("comment", comment);
        return "redirect:/view";
    }

    @RequestMapping("/view")
    public String view(HttpSession session){
        if(session.getAttribute("language").equals("java")){
            return "java.jsp";
        }else { return "result.jsp"; }
    }
}

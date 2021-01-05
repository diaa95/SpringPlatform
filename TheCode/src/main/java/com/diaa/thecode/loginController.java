package com.diaa.thecode;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class loginController {
    @RequestMapping("/")
    public String form(HttpSession session){
        return "index.jsp";
    }
    @RequestMapping(value ="/check", method = RequestMethod.POST)
    public String Check(HttpSession session, @RequestParam(value ="code") String code){
        if(String.valueOf(code).equals("bushido")) {
            session.setAttribute("code", code);
            return "redirect:/home";
        }
        else{ return "redirect:/createError";}
    }
    @RequestMapping("/home")
    public String home(HttpSession session){
        if (session.getAttribute("code") != null){
            return "home.jsp";
        }
        else return "redirect:/createError";
    }
    @RequestMapping("/createError")
    public String flashMessages(RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "You must train harder!");
        return "redirect:/";
    }
}

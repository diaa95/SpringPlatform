package com.diaa.authentication.controllers;


import com.diaa.authentication.models.LogIn;
import com.diaa.authentication.models.User;
import com.diaa.authentication.services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @RequestMapping("/")
    public String LoginAndRegister(@ModelAttribute("user") User user, @ModelAttribute("logIn")LogIn logIn){
        return "LogInAndRegistration.jsp";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String Register(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session){
        if(result.hasErrors()){
            return "LogInAndRegistration.jsp";
        } else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute("logIn") LogIn logIn, HttpSession session, Model model){
         if(userService.authenticateUser(logIn.getExistingEmail(), logIn.getHash())) {
             User user = userService.findByEmail(logIn.getExistingEmail());
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }else return "LogInAndRegistration.jsp";
    }
    @RequestMapping("/home")
    public String home(HttpSession session, Model model){
        if(session.getAttribute("id") != null){
        Long id = (Long) session.getAttribute("id");
        System.out.println("*******************************************");
        System.out.println(id);
        User user = userService.findUserById(id);
        model.addAttribute("user", user);
        return "Home.jsp";
        }else return "redirect:/";
    }
    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("id");
        return "redirect:/";
    }
}

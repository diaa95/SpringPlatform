package com.diaa.authentication.controllers;


import com.diaa.authentication.models.LogIn;
import com.diaa.authentication.models.User;
import com.diaa.authentication.services.UserService;
import com.diaa.authentication.validator.LogInValidator;
import com.diaa.authentication.validator.UserValidator;
import org.springframework.stereotype.Controller;
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
    private final UserValidator userValidator;
    private final LogInValidator logInValidator;


    public UserController(UserService userService, UserValidator userValidator, LogInValidator logInValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
        this.logInValidator = logInValidator;
    }

    @RequestMapping("/")
    public String LoginAndRegister(@ModelAttribute("user") User user, @ModelAttribute("logIn")LogIn logIn){
        return "LogInAndRegistration.jsp";
    }
    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String Register(@Valid @ModelAttribute("user")User user, BindingResult result,@ModelAttribute("logIn") LogIn logIn, HttpSession session){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            return "LogInAndRegistration.jsp";
        } else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }
    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute("logIn") LogIn logIn, BindingResult result1, @ModelAttribute("user") User userA, HttpSession session){
        logInValidator.validate(logIn,result1);
        if(result1.hasErrors()){
            return "LogInAndRegistration.jsp";
        }else {
                User user = userService.findByEmail(logIn.getRegisteredEmail());
                session.setAttribute("id", user.getId());
                return "redirect:/home";
        }
    }

    @RequestMapping("/home")
    public String home(HttpSession session, Model model){
        if(session.getAttribute("id") != null){
        Long id = (Long) session.getAttribute("id");
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

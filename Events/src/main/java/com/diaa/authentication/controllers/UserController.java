package com.diaa.authentication.controllers;


import com.diaa.authentication.models.*;
import com.diaa.authentication.services.UserService;
import com.diaa.authentication.validators.LogInValidator;
import com.diaa.authentication.validators.UserValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

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
    public String LoginAndRegister(@ModelAttribute("user") User user, @ModelAttribute("logIn") LogIn logIn, Model model){
        model.addAttribute("states", State.States);
        return "LogInAndRegistration.jsp";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String Register(@Valid @ModelAttribute("user")User user, BindingResult result, @ModelAttribute("logIn") LogIn logIn, HttpSession session,Model model){
        userValidator.validate(user, result);
        if(result.hasErrors()){
            String[] states = new String[]{"NY", "LA", "PH"};
            model.addAttribute("states", State.States);
            return "LogInAndRegistration.jsp";
        } else {
            userService.registerUser(user);
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping(value = "/logIn", method = RequestMethod.POST)
    public String LogIn(@ModelAttribute("logIn") LogIn logIn, BindingResult result1, @ModelAttribute("user") User userA, HttpSession session, Model model){
        logInValidator.validate(logIn,result1);
        if(result1.hasErrors()){
            model.addAttribute("states", State.States);
            return "LogInAndRegistration.jsp";
        }else {
            User user = userService.findByEmail(logIn.getRegisteredEmail());
            session.setAttribute("id", user.getId());
            return "redirect:/home";
        }
    }

    @RequestMapping("/home")
    public String home(@ModelAttribute("event")Event event, HttpSession session, Model model){
        if(session.getAttribute("id") != null){
            Long id = (Long) session.getAttribute("id");
            User user = userService.findUserById(id);
            List<Event> inState = userService.EventsInState(user.getState());
            List<Event> notInState = userService.EventsNotInState(user.getState());
            model.addAttribute("user", user);
            model.addAttribute("states", State.States);
            model.addAttribute("inState", inState);
            model.addAttribute("notInState", notInState);
            return "Home.jsp";
        }else return "redirect:/";
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public String addEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session, Model model){
        if(result.hasErrors()){
            model.addAttribute("states", State.States);
            return "Home.jsp";
        } else {
            Long host_id =(Long) session.getAttribute("id");
            userService.addEvent(event, host_id);
            return "redirect:/home";
        }
    }

    @RequestMapping("/joinEvent/{event_id}")
    public String Join(@PathVariable("event_id")Long event_id, HttpSession session){
        User user = userService.findUserById((Long) session.getAttribute("id"));
        Event event = userService.findEventById(event_id);
        userService.joinEvent(user, event);
        return "redirect:/home";
    }

    @RequestMapping("/events/{id}")
    public String showEvent(@PathVariable("id")Long id, Model model, @ModelAttribute("message")Message message, HttpSession session){
        Event event = userService.findEventById(id);
        List<Message> messages = userService.findEventMessages(event);
        User user = userService.findUserById((Long) session.getAttribute("id"));
        model.addAttribute("user", user);
        model.addAttribute("event", event);
        model.addAttribute("messages", messages);
        return "showEvent.jsp";
    }

    @RequestMapping(value = "/addMessage/{user_id}/{event_id}", method = RequestMethod.POST)
    public String addMessage(@PathVariable("user_id")Long user_id, @PathVariable("event_id")Long event_id, @Valid @ModelAttribute("message") Message message, BindingResult result){
        if(result.hasErrors()){
            return "showEvent.jsp";
        }else{
            User user = userService.findUserById(user_id);
            Event event = userService.findEventById(event_id);
            userService.addMessage(message.getContext(), user, event);
            return "redirect:/events/"+event_id;
        }
    }

    @RequestMapping(value = "/destroy/{event_id}", method = RequestMethod.DELETE)
    public String destroy(@PathVariable("event_id")Long event_id){
        userService.deleteEventById(event_id);
        return "redirect:/home";
    }

    @RequestMapping("/cancel/{event_id}")
    public String cancel(@PathVariable("event_id")Long event_id, HttpSession session){
        User user = userService.findUserById((Long) session.getAttribute("id"));
        Event event = userService.findEventById(event_id);
        userService.cancel(event, user);
        return "redirect:/home";
    }


    @RequestMapping("/events/{id}/edit")
    public String displayEditEvent(@PathVariable("id") Long event_id, HttpSession session, Model model) {
        User user = userService.findUserById((Long) session.getAttribute("id"));
        Event event = userService.findEventById(event_id);
        if (event.getHost().equals(user)) {
            model.addAttribute("event", event);
            model.addAttribute("states", State.States);
            return "/eventEdit.jsp";
        }
        return "redirect:/home";
    }

    @RequestMapping(value = "/events/{id}/edit", method = RequestMethod.POST)
    public String editEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "/eventEdit.jsp";
        }
        else {
            userService.addEvent(event, (Long) session.getAttribute("id"));
            return "redirect:/home";
        }
    }


    @RequestMapping("/logout")
    public String logOut(HttpSession session){
        session.removeAttribute("id");
        return "redirect:/";
    }

}

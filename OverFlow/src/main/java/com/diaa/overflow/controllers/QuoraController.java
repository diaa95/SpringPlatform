package com.diaa.overflow.controllers;


import com.diaa.overflow.models.Answer;
import com.diaa.overflow.models.Question;
import com.diaa.overflow.models.Tag;
import com.diaa.overflow.services.QuoraService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class QuoraController {
    private final QuoraService quoraService;

    public QuoraController(QuoraService quoraService) {
        this.quoraService = quoraService;
    }
    @RequestMapping("/")
    public String index(Model model){
        List<Question> questions = quoraService.allQuestions();
        model.addAttribute("questions", questions);
        return "index.jsp";
    }
    @RequestMapping("/addQuestion")
    public String addQuestion(@ModelAttribute("question") Question question,@ModelAttribute("tag") Tag tag){
        return "addQuestion.jsp";
    }
    @RequestMapping(value = "/addQuestion", method = RequestMethod.POST)
    public String addQuestion(@Valid  @ModelAttribute("question") Question question,BindingResult result1,@Valid @ModelAttribute("tag") Tag tag, BindingResult result){
        if(result.hasErrors() || result1.hasErrors()){
            return "addQuestion.jsp";
        }else {
            quoraService.newQuestion(question, tag);
            return "redirect:/";
        }
    }
    @RequestMapping("/questions/{id}")
    public String Answer(@ModelAttribute("answer")Answer answer, @PathVariable("id")Long q_id, Model model){
        Question question = quoraService.getQuestion(q_id);
        model.addAttribute("question", question);
        return "answerQuestion.jsp";
    }
    @RequestMapping(value = "/questions/{id}", method = RequestMethod.POST)
    public String addAnswer(@Valid @ModelAttribute("answer")Answer answer,BindingResult result,@PathVariable("id") Long q_id){
        if(result.hasErrors()){
            return "answerQuestion.jsp";
        }else {
            quoraService.addNewAnswer(q_id, answer);
            return "redirect:/questions/"+q_id;
        }
    }
}

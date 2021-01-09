package com.diaa.languages.controllers;

import com.diaa.languages.models.Language;
import com.diaa.languages.services.LanguageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@Controller
public class LanguageController {
    private final LanguageService languageService;
    public LanguageController(LanguageService languageService){
        this.languageService = languageService;
    }

    @RequestMapping("/languages")
    public String index(Model model, @ModelAttribute("language") Language language){
        List<Language> languages = languageService.allLanguages();
        model.addAttribute("languages", languages);
        return "languages/index.jsp";
    }

    @RequestMapping(value = "/languages", method = RequestMethod.POST)
    public String add(@Valid @ModelAttribute("language") Language language, BindingResult result){
        if(result.hasErrors()){
            return "languages/index.jsp";
        } else {
            languageService.addLanguage(language);
            return "redirect:/languages";
        }
    }

    @RequestMapping("languages/{id}")
    public String show(Model model, @PathVariable("id") Long id){
        Language language = languageService.findLanguage(id);
        model.addAttribute("language",language);
        return "languages/show.jsp";
    }

    @RequestMapping("languages/{id}/edit")
    public String edit(@PathVariable("id") Long id, Model model){
        Language language = languageService.findLanguage(id);
        model.addAttribute(language);
        return "languages/edit.jsp";
    }
    @RequestMapping(value="/languages/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, @PathVariable("id") Long id){
        if(result.hasErrors()){
            return "languages/edit.jsp";
        } else {
            languageService.updateLanguage(id, language.getName(), language.getCreator(), language.getVersion());
            return "redirect:/languages";
        }
    }


    @RequestMapping(value="/languages/{id}", method=RequestMethod.DELETE)
    public String destroy(@PathVariable("id") Long id) {
        languageService.deleteLanguage(id);
        return "redirect:/languages";
    }
}

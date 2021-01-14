package com.groupactivity.querirsandjoins.controllers;


import com.groupactivity.querirsandjoins.models.Country;
import com.groupactivity.querirsandjoins.services.ApiService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    private final ApiService apiService;

    public AppController(ApiService apiService) {
        this.apiService = apiService;
    }

    @RequestMapping("/{lang}")
    public List<Object> speaks(@PathVariable("lang") String lang){
        return apiService.speaksSlovene(lang) ;
    }
    @RequestMapping("/n")
    public List<Object> num_cities(){
        return apiService.numOfCities();
    }
    @RequestMapping("/highLanguage")
    public List<Object> highLanguage(){
        return apiService.highlyUsedLanguages();
    }
    @RequestMapping("/highDensity")
    public List<Object> highDensity(){
        return apiService.highDensity();
    }

    @RequestMapping("/country/{country}")
    public List<Object> bigCities(@PathVariable("country") String country){
        return apiService.bigCities(country) ;
    }
    @RequestMapping("/specificQuery/{gov_form}")
    public List<Object> specificQuery(@PathVariable("gov_form") String gov_form){
        return apiService.specificQuery(gov_form) ;
    }


}

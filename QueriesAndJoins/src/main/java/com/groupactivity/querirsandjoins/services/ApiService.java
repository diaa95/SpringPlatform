package com.groupactivity.querirsandjoins.services;


import com.groupactivity.querirsandjoins.models.Country;
import com.groupactivity.querirsandjoins.repositories.CityRepo;
import com.groupactivity.querirsandjoins.repositories.CountryRepo;
import com.groupactivity.querirsandjoins.repositories.LanguageRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApiService {
    private final CityRepo cityRepo;
    private final CountryRepo countryRepo;
    private final LanguageRepo languageRepo;

    public ApiService(CityRepo cityRepo, CountryRepo countryRepo, LanguageRepo languageRepo) {
        this.cityRepo = cityRepo;
        this.countryRepo = countryRepo;
        this.languageRepo = languageRepo;
    }

    public List<Object> speaksSlovene(String language){
        return countryRepo.speaksSlovene(language);
    }
    public List<Object> numOfCities(){
        return countryRepo.numOfCities();
    }

    public List<Object> bigCities(String country){
        return countryRepo.bigCities(country);
    }
    public List<Object> specificQuery(String gov_form){
        return countryRepo.specificQuery(gov_form);
    }

    public List<Object> highlyUsedLanguages(){
        return countryRepo.highlyUsedLanguages();
    }
    public List<Object> highDensity(){
        return countryRepo.highDensity();
    }

}

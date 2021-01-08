package com.diaa.languages.services;


import com.diaa.languages.models.Language;
import com.diaa.languages.repositories.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService {
    private final LanguageRepository languageRepository;

    public LanguageService(LanguageRepository languageRepository){
        this.languageRepository = languageRepository;
    }

    public List<Language> allLanguages(){
        return languageRepository.findAll();
    }
    public Language addLanguage(Language language){
        return languageRepository.save(language);
    }
    public Language findLanguage(Long id){
        Optional<Language> optionalLanguage = languageRepository.findById(id);
        if(optionalLanguage.isPresent()){
            return optionalLanguage.get();
        } else {
            return null;
        }
    }
    public void deleteLanguage(Long id){
        languageRepository.deleteById(id);
    }
    public Language updateLanguage(Long id, String name, String creator, String version){
        Language l = findLanguage(id);
        l.setName(name);
        l.setCreator(creator);
        l.setVersion(version);
        return languageRepository.save(l);
    }
}

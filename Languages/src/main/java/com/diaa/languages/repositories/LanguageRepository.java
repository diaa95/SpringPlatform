package com.diaa.languages.repositories;

import com.diaa.languages.models.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LanguageRepository extends CrudRepository<Language, Long> {
    List<Language> findAll();
    void deleteById(Long id);
}

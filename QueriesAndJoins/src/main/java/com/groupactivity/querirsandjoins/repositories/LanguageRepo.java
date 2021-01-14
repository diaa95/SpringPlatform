package com.groupactivity.querirsandjoins.repositories;

import com.groupactivity.querirsandjoins.models.Language;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepo extends CrudRepository<Language, Long> {
}

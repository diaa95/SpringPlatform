package com.diaa.overflow.reposirories;

import com.diaa.overflow.models.Answer;
import com.diaa.overflow.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AnswerRepository extends CrudRepository<Answer, Long> {
    List<Answer> findAll();
}

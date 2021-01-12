package com.diaa.overflow.reposirories;

import com.diaa.overflow.models.Question;
import com.diaa.overflow.models.Tag;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TagRepository extends CrudRepository<Tag, Long> {
    List<Tag> findAll();
    Tag findBySubject(String subject);
}

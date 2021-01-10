package com.diaa.dojosandninjas.repositories;

import com.diaa.dojosandninjas.models.Dojo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
    void deleteById(Long id);
}

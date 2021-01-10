package com.diaa.dojosandninjas.repositories;

import com.diaa.dojosandninjas.models.Ninja;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {
    List<Ninja> findAll();
    void deleteById(Long id);
}

package com.diaa.dojosandninjas.services;

import com.diaa.dojosandninjas.models.Dojo;
import com.diaa.dojosandninjas.models.Ninja;
import com.diaa.dojosandninjas.repositories.DojoRepository;
import com.diaa.dojosandninjas.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class DojoService {
    private final DojoRepository dojoRepository;
    private final NinjaRepository ninjaRepository;

    public DojoService(DojoRepository dojoRepository, NinjaRepository ninjaRepository) {
        this.dojoRepository = dojoRepository;
        this.ninjaRepository = ninjaRepository;
    }

    public List<Dojo> allDojos(){
        return dojoRepository.findAll();
    }
    public Dojo addDojo(Dojo dojo){
        return dojoRepository.save(dojo);
    }
    public Dojo getDojo(Long id){
        return dojoRepository.findById(id).orElse(null);
    }
    public List<Ninja> allNinjas(){
        return ninjaRepository.findAll();
    }
    public Ninja addNinja(Ninja ninja){
        return ninjaRepository.save(ninja);
    }
    public Ninja getNinja(Long id){
        return ninjaRepository.findById(id).orElse(null);
    }

}

package com.diaa.driverslicense.services;


import com.diaa.driverslicense.models.License;
import com.diaa.driverslicense.models.Person;
import com.diaa.driverslicense.repositories.LicenseRepository;
import com.diaa.driverslicense.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverService {
    private final PersonRepository personRepository;
    private final LicenseRepository licenseRepository;
    public DriverService(PersonRepository personRepositories, LicenseRepository licenseRepository){
        this.personRepository = personRepositories;
        this.licenseRepository = licenseRepository;
    }

    public List<Person> allPersons(){
        return personRepository.findAll();
    }
    public Person addPerson(Person person){
        return personRepository.save(person);
    }
    public Person getPerson(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    public List<Person> getUnlicensedPeople() {
        return personRepository.findByLicenseIdIsNull();
    }
    public License addLicense(License license){
        license.setNumber(this.generateLicenseNumber());
        return licenseRepository.save(license);
    }
    public Integer generateLicenseNumber(){
        License license = licenseRepository.findTopByOrderByNumberDesc();
        if(license == null){
            return 1;
        }
        int largestNumber = license.getNumber();
        largestNumber++;
        return largestNumber;
    }
}

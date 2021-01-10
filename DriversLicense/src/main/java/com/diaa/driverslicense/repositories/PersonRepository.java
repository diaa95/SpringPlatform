package com.diaa.driverslicense.repositories;

import com.diaa.driverslicense.models.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person, Long> {
    List<Person> findAll();
    void deleteById(Long id);
    @Query(value="SELECT p.* FROM persons p LEFT OUTER JOIN licenses l ON p.id = l.person_id WHERE l.id IS NULL", nativeQuery=true)
    List<Person> findByNoLicense();
    List<Person> findByLicenseIdIsNull();

}

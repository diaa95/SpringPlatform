package com.diaa.driverslicense.repositories;

import com.diaa.driverslicense.models.License;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LicenseRepository extends CrudRepository<License, Long> {
    List<License> findAll();
    void deleteById(Long id);
    License findTopByOrderByNumberDesc();
}

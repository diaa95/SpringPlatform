package com.groupactivity.querirsandjoins.repositories;

import com.groupactivity.querirsandjoins.models.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends CrudRepository<City, Long> {
}

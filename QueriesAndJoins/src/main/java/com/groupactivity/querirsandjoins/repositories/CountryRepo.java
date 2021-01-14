package com.groupactivity.querirsandjoins.repositories;

import com.groupactivity.querirsandjoins.models.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CountryRepo extends CrudRepository<Country, Long> {
    @Query("SELECT c.name, c.name, l.percentage FROM Country c JOIN Language l ON c.id = l.country.id WHERE l.language LIKE %?1% ORDER BY l.percentage DESC")
    public List<Object> speaksSlovene(String language);
    @Query("SELECT  c.id, c.name, COUNT(cities.country.id) AS count_cities FROM Country c JOIN City cities ON c.id = cities.country.id GROUP BY c.id ORDER BY count_cities DESC")
    public List<Object> numOfCities();
    @Query("SELECT cities.name, cities.population ,  countries.name FROM Country countries JOIN City cities ON countries.name LIKE %?1% WHERE cities.population > 500000 ORDER BY cities.population DESC")
    public List<Object> bigCities(String country);
    @Query("SELECT countries.name AS Country_Name, languages.language, languages.percentage FROM Country countries,Language languages WHERE countries.id = languages.country.id AND languages.percentage > 89 ORDER BY languages.percentage DESC")
    public List<Object> highlyUsedLanguages();
    @Query("SELECT countries.name, countries.surface_area, countries.population From Country countries WHERE countries.surface_area < 501 AND countries.population > 100000")
    public List<Object> highDensity();
    @Query("SELECT countries.name, countries.government_form FROM Country countries WHERE  countries.government_form LIKE %?1% AND countries.surface_area > 200 AND countries.life_expectancy > 75")
    public List<Object> specificQuery(String gov_form);

}




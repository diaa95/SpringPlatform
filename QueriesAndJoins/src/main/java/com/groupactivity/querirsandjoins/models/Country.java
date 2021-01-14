package com.groupactivity.querirsandjoins.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, max = 3)
    private String code;
    @Size(min = 3, max = 52)
    private String name;
    private String continent;
    @Size(min = 3, max = 26)
    private String region;
    @Digits(integer=10, fraction=2)
    private Float surface_area;
    private Date ind_year;
    @Digits(integer = 6,fraction = 0)
    private Integer population;
    @Digits(integer = 3, fraction = 1)
    private Float life_expectancy;
    @Digits(integer = 10, fraction = 2)
    private Float gnp;
    @Digits(integer = 10, fraction = 2)
    private Float gnpOld;
    @Size(min = 3, max = 45)
    private String localName;
    @Size(min = 3,max = 45)
    private String government_form;
    @Size(min = 3, max = 60)
    private String heaOfState;
    @Size(min = 3,max = 11)
    private String capital;
    @Size(min = 2,max = 2)
    private String code2;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<City> cities;
    @OneToMany(mappedBy="country", fetch = FetchType.LAZY)
    private List<Language> languages;

    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }

    public Country() {
    }

    public Country(Long id,String code, String name, String continent,String region,Float surface_area, Date ind_year,  Integer population, Float life_expectancy,Float gnp,Float gnpOld, String localName,String government_form,String heaOfState, String capital,String code2, Date createdAt, Date updatedAt) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surface_area = surface_area;
        this.ind_year = ind_year;
        this.population = population;
        this.life_expectancy = life_expectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.government_form = government_form;
        this.heaOfState = heaOfState;
        this.capital = capital;
        this.code2 = code2;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Float getsurface_area() {
        return surface_area;
    }

    public void setsurface_area(Float surface_area) {
        this.surface_area = surface_area;
    }

    public Date getInd_year() {
        return ind_year;
    }

    public void setInd_year(Date ind_year) {
        this.ind_year = ind_year;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Float getlife_expectancy() {
        return life_expectancy;
    }

    public void setlife_expectancy(Float life_expectancy) {
        this.life_expectancy = life_expectancy;
    }

    public Float getGnp() {
        return gnp;
    }

    public void setGnp(Float gnp) {
        this.gnp = gnp;
    }

    public Float getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(Float gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getgovernment_form() {
        return government_form;
    }

    public void setgovernment_form(String government_form) {
        this.government_form = government_form;
    }

    public String getHeaOfState() {
        return heaOfState;
    }

    public void setHeaOfState(String heaOfState) {
        this.heaOfState = heaOfState;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}


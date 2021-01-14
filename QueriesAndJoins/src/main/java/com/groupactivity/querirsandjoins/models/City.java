package com.groupactivity.querirsandjoins.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3,max = 35)
    private String name;
    @Size(min = 3, max = 3)
    private String countryCode;
    @Size(min = 3,max = 20)
    private String district;
    @Digits(integer = 11,fraction = 0)
    private Integer population;

    @Column(updatable=false)
    private Date createdAt;
    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coutnry_id")
    private Country country;


    @PrePersist
    protected void onCreate() {
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}

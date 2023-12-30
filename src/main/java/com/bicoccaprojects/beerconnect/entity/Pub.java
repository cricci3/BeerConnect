package com.bicoccaprojects.beerconnect.entity;

import jakarta.persistence.*;

import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name="Pub")
public class Pub {
    @Id
    @SequenceGenerator(name="pub_sequence", sequenceName = "pub_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "pub_sequence") // per avere ID che parte da 1 e incrementa di 1 per ogni entità nella tabella
    @Column(name = "id_pub", updatable = false)
    private Long idPub;

    @Column(name = "name_pub", nullable = false) // nullable = false -> not null, "TEXT"-> varchar
    private String namePub;

    @Column(name = "country", nullable = false)
    private String country;

    @Column(name = "year_of_foundation", nullable = false)
    private Integer yearOfFoundation;

    public Pub(String name, String address, Integer yearOfFoundation) {
        this.namePub = name;
        this.country = address;
        this.yearOfFoundation = yearOfFoundation;
    }

    public Pub(Long idPub) {
        this.idPub = idPub;
    }

    public Pub() {}

    @OneToMany(mappedBy = "pub")
    private List<Beer> beers;


    public Long getIdPub() {
        return idPub;
    }

    public void setIdPub(Long id) {
        this.idPub = id;
    }

    public String getNamePub() {
        return namePub;
    }

    public void setNamePub(String name) {
        this.namePub = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    @Override
    public String toString() {
        return "Pub{" +
                "id=" + idPub +
                ", name='" + namePub + '\'' +
                ", address='" + country + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                '}';
    }
}

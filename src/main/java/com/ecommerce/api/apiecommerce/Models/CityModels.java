package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "City")
public class CityModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_city;
    @Column(nullable = false)
    private String nome_city;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<BairroModels> bairro;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private StadeModels stade;

    public CityModels(long id_city, String nome_city, StadeModels stade) {
        this.id_city = id_city;
        this.nome_city = nome_city;
        this.stade = stade;
    }

    public CityModels() {
    }

    public long getId_city() {
        return id_city;
    }

    public void setId_city(long id_city) {
        this.id_city = id_city;
    }

    public String getNome_city() {
        return nome_city;
    }

    public void setNome_city(String nome_city) {
        this.nome_city = nome_city;
    }

    public StadeModels getStade() {
        return stade;
    }

    public void setStade(StadeModels stade) {
        this.stade = stade;
    }
}

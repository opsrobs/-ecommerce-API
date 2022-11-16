package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity(name = "Bairro")
public class BairroModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id_bairro;
    @Column(nullable = false)
    private String nome_bairro;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private CityModels city;

    public BairroModels(long id_bairro, String nome_bairro, CityModels city) {
        this.id_bairro = id_bairro;
        this.nome_bairro = nome_bairro;
        this.city = city;
    }

    public BairroModels() {
    }

    public long getId_bairro() {
        return id_bairro;
    }

    public void setId_bairro(long id_bairro) {
        this.id_bairro = id_bairro;
    }

    public String getNome_bairro() {
        return nome_bairro;
    }

    public void setNome_bairro(String nome_bairro) {
        this.nome_bairro = nome_bairro;
    }

    public CityModels getCity() {
        return city;
    }

    public void setCity(CityModels city) {
        this.city = city;
    }
}

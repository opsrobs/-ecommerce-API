package com.ecommerce.api.apiecommerce.Models;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name= "City")
public class CityModels {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idCidade;
    @Column(nullable = false)
    private String nome_city;
    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    private List<BairroModels> bairro;
    @ManyToOne @Cascade(org.hibernate.annotations.CascadeType.MERGE)
    private StadeModels stade;

    public CityModels(long idCidade, String nome_city, StadeModels stade) {
        this.idCidade = idCidade;
        this.nome_city = nome_city;
        this.stade = stade;
    }

    public CityModels() {
    }

    public long getidCidade() {
        return idCidade;
    }

    public void setidCidade(long idCidade) {
        this.idCidade = idCidade;
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

    @Override
    public String toString() {
        return "CityModels{" +
                "idCidade=" + idCidade +
                ", nome_city='" + nome_city + '\'' +
                ", bairro=" + bairro +
                ", stade=" + stade +
                '}';
    }
}

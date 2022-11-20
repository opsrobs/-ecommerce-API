package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.StadeModels;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

public class CityDto {
    @NotNull
    private long id_city;
    @NotNull
    private String nome_city;
    @NotNull
    private StadeModels stade;

    public CityDto(long id_city, String nome_city, StadeModels stade) {
        this.id_city = id_city;
        this.nome_city = nome_city;
        this.stade = stade;
    }

    public StadeModels getStade() {
        return stade;
    }

    public void setStade(StadeModels stade) {
        this.stade = stade;
    }

    public CityDto() {
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
}

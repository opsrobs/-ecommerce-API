package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.StadeModels;

import javax.validation.constraints.NotNull;

public class CityDto {
    @NotNull
    private String nome_city;
    @NotNull
    private StadeModels stade;

    public CityDto(String nome_city, StadeModels stade) {
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

    public String getNome_city() {
        return nome_city;
    }

    public void setNome_city(String nome_city) {
        this.nome_city = nome_city;
    }
}

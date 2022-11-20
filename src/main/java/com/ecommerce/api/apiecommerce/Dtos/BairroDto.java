package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.CityModels;
import com.ecommerce.api.apiecommerce.Models.StadeModels;

import javax.validation.constraints.NotNull;

public class BairroDto {
    @NotNull
    private String nomeBairro;
    @NotNull
    private CityModels city;

    public BairroDto(String nomeBairro, CityModels city) {
        this.nomeBairro = nomeBairro;
        this.city = city;
    }

    public BairroDto() {
    }

    public String getnomeBairro() {
        return nomeBairro;
    }

    public void setnomeBairro(String nomeBairro) {
        this.nomeBairro = nomeBairro;
    }

    public CityModels getCity() {
        return city;
    }

    public void setCity(CityModels city) {
        this.city = city;
    }
}

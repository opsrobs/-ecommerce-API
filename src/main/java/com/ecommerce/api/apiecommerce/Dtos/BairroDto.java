package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.StadeModels;

import javax.validation.constraints.NotNull;

public class BairroDto {
    @NotNull
    private String nome_bairro;
    @NotNull
    private StadeModels city;

    public BairroDto(String nome_bairro, StadeModels city) {
        this.nome_bairro = nome_bairro;
        this.city = city;
    }

    public BairroDto() {
    }

    public String getNome_bairro() {
        return nome_bairro;
    }

    public void setNome_bairro(String nome_bairro) {
        this.nome_bairro = nome_bairro;
    }

    public StadeModels getCity() {
        return city;
    }

    public void setCity(StadeModels city) {
        this.city = city;
    }
}

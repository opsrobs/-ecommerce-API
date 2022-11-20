package com.ecommerce.api.apiecommerce.Dtos;

import javax.validation.constraints.NotNull;

public class ProductTypeDto {

    @NotNull
    private String nomeTipo;

    public ProductTypeDto(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public ProductTypeDto() {
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    @Override
    public String toString() {
        return "ProductTypeDto{" +
                "nomeTipo='" + nomeTipo + '\'' +
                '}';
    }
}

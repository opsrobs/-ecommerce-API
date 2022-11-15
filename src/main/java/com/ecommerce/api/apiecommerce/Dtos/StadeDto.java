package com.ecommerce.api.apiecommerce.Dtos;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

public class StadeDto {
    @NotNull
    private String UF;
    @NotNull
    private String nome_estado;

    public StadeDto(String UF, String nome_estado) {
        this.UF = UF;
        this.nome_estado = nome_estado;
    }

    public StadeDto() {
    }

    public String getUF() {
        return UF;
    }

    public void setUF(String UF) {
        this.UF = UF;
    }

    public String getNome_estado() {
        return nome_estado;
    }

    public void setNome_estado(String nome_estado) {
        this.nome_estado = nome_estado;
    }
}

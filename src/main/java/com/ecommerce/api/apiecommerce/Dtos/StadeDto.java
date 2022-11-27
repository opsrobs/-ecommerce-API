package com.ecommerce.api.apiecommerce.Dtos;

import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class StadeDto {
    @Nullable
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

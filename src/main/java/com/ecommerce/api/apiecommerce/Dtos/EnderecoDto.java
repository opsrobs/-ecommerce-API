package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.BairroModels;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public class EnderecoDto {
    @NotNull
    private String cep;
    @NotNull
    private String rua;
    @NotNull
    private String complemento;
    @NotNull
    private long numero;
    @NotNull
    private Boolean ativo;

    private BairroModels bairro;

    public EnderecoDto(String cep, String rua, String complemento, long numero, Boolean ativo, BairroModels bairro) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.numero = numero;
        this.ativo = ativo;
        this.bairro = bairro;
    }

    public EnderecoDto() {
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public BairroModels getBairro() {
        return bairro;
    }

    public void setBairro(BairroModels bairro) {
        this.bairro = bairro;
    }
}

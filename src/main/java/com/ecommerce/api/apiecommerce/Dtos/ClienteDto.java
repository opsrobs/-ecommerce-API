package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;

import javax.validation.constraints.NotNull;

public class ClienteDto {
    @NotNull
    private long id_cliente;
    @NotNull
    private PessoaModels pessoa;

    public ClienteDto(long id_cliente, PessoaModels pessoa) {
        this.id_cliente = id_cliente;
        this.pessoa = pessoa;
    }

    public ClienteDto() {
    }

    public long getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(long id_cliente) {
        this.id_cliente = id_cliente;
    }

    public PessoaModels getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModels pessoa) {
        this.pessoa = pessoa;
    }
}

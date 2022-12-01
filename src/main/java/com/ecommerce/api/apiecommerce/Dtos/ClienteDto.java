package com.ecommerce.api.apiecommerce.Dtos;

import com.ecommerce.api.apiecommerce.Models.PessoaModels;

import javax.validation.constraints.NotNull;

public class ClienteDto {

    @NotNull
    private PessoaModels pessoa;

    public ClienteDto(PessoaModels pessoa) {
        this.pessoa = pessoa;
    }

    public ClienteDto() {
    }
    public PessoaModels getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaModels pessoa) {
        this.pessoa = pessoa;
    }

    @Override
    public String toString() {
        return "ClienteDto{" +
                ", pessoa=" + pessoa +
                '}';
    }
}
